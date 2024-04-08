package example.com.routeexample.route.service;

import example.com.routeexample.buildingNickname.repository.BuildingNicknameRepository;
import example.com.routeexample.classroom.repository.ClassroomRepository;
import example.com.routeexample.elevator.entity.Elevator;
import example.com.routeexample.elevator.entity.ElevatorFloor;
import example.com.routeexample.elevator.repository.ElevatorFloorRepository;
import example.com.routeexample.elevator.repository.ElevatorRepository;
import example.com.routeexample.route.dto.RouteGetResDto;
import example.com.routeexample.route.entity.Edge;
import example.com.routeexample.route.entity.Node;
import example.com.routeexample.route.repository.EdgeRepository;
import example.com.routeexample.route.repository.NodeRepository;
import example.com.routeexample.stair.entity.Stair;
import example.com.routeexample.stair.entity.StairFloor;
import example.com.routeexample.stair.repository.StairFloorRepository;
import example.com.routeexample.stair.repository.StairRepository;
import jakarta.annotation.Nullable;
import java.util.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RouteService {

    private final NodeRepository nodeRepository;
    private final EdgeRepository edgeRepository;
    private final ClassroomRepository classroomRepository;
    private final BuildingNicknameRepository buildingNicknameRepository;
    private final ElevatorFloorRepository elevatorFloorRepository;
    private final StairFloorRepository stairFloorRepository;
    private final ElevatorRepository elevatorRepository;
    private final StairRepository stairRepository;

    public RouteGetResDto findRoute(String startBuilding, String startRoom, String endBuilding, String endRoom) {
        // 노드 ID 찾기
        Node startNode;
        Node endNode;

        // 건물 ID 찾기
        Long startBuildingId = buildingNicknameRepository.findByNickname(startBuilding).getBuilding().getId();
        Long endBuildingId = buildingNicknameRepository.findByNickname(endBuilding).getBuilding().getId();

        startNode = classroomRepository.findByNameAndBuildingId(startRoom, startBuildingId).getNode();
        endNode = classroomRepository.findByNameAndBuildingId(endRoom, endBuildingId).getNode();

        RouteGetResDto stairRouteDto = new RouteGetResDto(startNode.getId(), startBuilding + " " + startRoom, endNode.getId(), endBuilding + " " + endRoom, 0L, new ArrayList<>());
        RouteGetResDto elevatorRouteDto = new RouteGetResDto(startNode.getId(), startBuilding + " " + startRoom, endNode.getId(), endBuilding + " " + endRoom, 0L, new ArrayList<>());

        // 건물이 다른 경우 - 생략

        // 건물이 같은 경우
        Long startFloor = startNode.getFloor();
        Long endFloor = endNode.getFloor();

        if(startFloor.equals(endFloor)) { // 같은 층인 경우
            stairRouteDto.setRouteInfo(useDijkstra(startNode.getId(), endNode.getId(), startBuildingId, startFloor));
            elevatorRouteDto.setRouteInfo(useDijkstra(startNode.getId(), endNode.getId(), startBuildingId, startFloor));
        }
        else { // 다른 층인 경우
            ElevatorFloor startElevator = findElevator(startNode, endNode, startBuildingId, startFloor); // 출발점과 도착점에서 가장 가까운 엘리베이터 찾기
            StairFloor startStair = findStair(startNode, endNode, startBuildingId, startFloor); // 출발점과 도착점에서 가장 가까운 계단 찾기

            if(startElevator != null) {
                // 시작점 -> 시작 층의 엘리베이터
                elevatorRouteDto.setRouteInfo(useDijkstra(startNode.getId(), startElevator.getNode().getId(), startBuildingId, startFloor));

                // 엘리베이터로 층 이동
                RouteInfo routeInfo = moveFloorByElevator(startFloor, endFloor, startElevator.getElevator().getId());
                elevatorRouteDto.setRouteInfo(routeInfo);

                // 도착 층의 엘리베이터 -> 도착 점
                elevatorRouteDto.setRouteInfo(useDijkstra(routeInfo.getLastNodeId(), endNode.getId(), startBuildingId, endFloor));
            }
            if(startStair != null) {
                // 시작점 -> 시작 층의 계단
                stairRouteDto.setRouteInfo(useDijkstra(startNode.getId(), startStair.getNode().getId(), startBuildingId, startFloor));

                // 계단으로 층 이동
                RouteInfo routeInfo = moveFloorByStair(startFloor, endFloor, startStair.getStair().getId());
                stairRouteDto.setRouteInfo(routeInfo);

                // 도착 층의 계단 -> 도착 점
                stairRouteDto.setRouteInfo(useDijkstra(routeInfo.getLastNodeId(), endNode.getId(), startBuildingId, endFloor));
            }
        }

        RouteGetResDto routeGetResDto;
        if(stairRouteDto.getPath().isEmpty()) routeGetResDto = elevatorRouteDto;
        else if(elevatorRouteDto.getPath().isEmpty()) routeGetResDto = stairRouteDto;
        else if(stairRouteDto.getDistance() < elevatorRouteDto.getDistance()) routeGetResDto = stairRouteDto;
        else routeGetResDto = elevatorRouteDto;

        return routeGetResDto;
    }

    private RouteInfo useDijkstra(Long startNodeId, Long endNodeId, Long buildingId, Long floor) { // 같은 건물, 층에서 두 노드 간 최단 경로 찾기
        // 최단 경로 찾기
        Map<Long, Long> distances = new HashMap<>();
        Map<Long, Long> previousNodes = new HashMap<>();
        PriorityQueue<NodeDistance> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(NodeDistance::getDistance));
        List<Node> nodes = nodeRepository.findByBuildingIdAndFloor(buildingId, floor);

        // 초기화
        for (Node node : nodes) {
            Long nodeId = node.getId();
            distances.put(nodeId, nodeId.equals(startNodeId) ? 0 : Long.MAX_VALUE);
            previousNodes.put(nodeId, null);
            priorityQueue.add(new NodeDistance(nodeId, distances.get(nodeId)));
        }

        while (!priorityQueue.isEmpty()) {
            Long currentNodeId = priorityQueue.poll().getNodeId();
            Map<Long, Long> neighbors = findNeighbors(currentNodeId);

            if (!neighbors.isEmpty()) {
                for (Long neighborId : neighbors.keySet()) {
                    long newDistance = distances.get(currentNodeId) + neighbors.get(neighborId);
                    log.info("neighborId: {}", neighborId);
                    if (newDistance < distances.get(neighborId)) {
                        distances.put(neighborId, newDistance);
                        previousNodes.put(neighborId, currentNodeId);
                        priorityQueue.add(new NodeDistance(neighborId, newDistance));
                    }
                }
            }
        }

        // 최단 경로 계산
        List<Long> shortestPath = new ArrayList<>();
        Long currentNode = endNodeId;
        while (currentNode != null) {
            shortestPath.add(currentNode);
            currentNode = previousNodes.get(currentNode);
        }
        Collections.reverse(shortestPath);

        // 결과 출력
        RouteInfo routeInfo = new RouteInfo(distances.get(endNodeId), shortestPath);
        log.info("최단 경로: " + shortestPath);
        log.info("최단 거리: " + distances.get(endNodeId));

        return routeInfo;
    }

    private Map<Long, Long> findNeighbors(Long currentNodeId) {
        Map<Long, Long> neighbors = new HashMap<>();
        Node node = nodeRepository.findById(currentNodeId).orElseThrow();
        List<Edge> edges = edgeRepository.findByStartNode(node);
        for(Edge edge : edges) {
            neighbors.put(edge.getEndNode().getId(), edge.getDistance());
        }
        return neighbors;
    }

    private ElevatorFloor findElevator(Node startNode, Node endNode, Long buildingId, Long floor){
        List<Elevator> elevatorList = elevatorRepository.findAllByBuildingId(buildingId); // 건물에 존재하는 엘리베이터
        if(elevatorList.isEmpty()) return null; // 건물에 엘레베이터가 없는 경우

        int size = elevatorList.size(); // 엘리베이터 개수
        double minDistance = -1;
        ElevatorFloor closestElevatorFloor = null;

        for (int i = 0; i < size; i++) {
            Elevator elevator = elevatorList.get(i);
            ElevatorFloor elevatorFloor = elevatorFloorRepository.findByElevatorIdAndFloor(
                    elevator.getId(), floor)
                .orElse(null);
            if (elevatorFloor == null) { // 현재 층을 운행하는 엘리베이터이가 없는 경우
                return null;
            }
            double distance = getEuclidDistance(elevatorFloor.getNode(), startNode) + getEuclidDistance(elevatorFloor.getNode(), endNode);
            if(minDistance == -1) {
                minDistance = distance;
                closestElevatorFloor = elevatorFloor;
            }
            else{
                if(minDistance > distance) {
                    minDistance = distance;
                    closestElevatorFloor = elevatorFloor;
                }
            }
        }

        return closestElevatorFloor;
    }

    private StairFloor findStair(Node startNode, Node endNode, Long buildingId, Long floor){
        List<Stair> stairList = stairRepository.findAllByBuildingId(buildingId);
        if(stairList.isEmpty()) return null;

        int size = stairList.size(); // 계단 개수
        double minDistance = -1;
        StairFloor closestStairFloor = null;

        for (int i = 0; i < size; i++) {
            Stair stair = stairList.get(i);
            StairFloor stairFloor = stairFloorRepository.findByStairIdAndFloor(
                    stair.getId(), floor)
                .orElse(null);
            if (stairFloor == null) { // 현재 층을 운행하는 계단이 없는 경우
                return null;
            }
            double distance = getEuclidDistance(stairFloor.getNode(), startNode) + getEuclidDistance(stairFloor.getNode(), endNode);
            if(minDistance == -1) {
                minDistance = distance;
                closestStairFloor = stairFloor;
            }
            else{
                if(minDistance > distance) {
                    minDistance = distance;
                    closestStairFloor = stairFloor;
                }
            }
        }

        return closestStairFloor;
    }

    private RouteInfo moveFloorByElevator(Long startFloor, Long endFloor, Long elevatorId) {
        if(Objects.equals(startFloor, endFloor)) return new RouteInfo();

        long distance = 0L;
        Long lastNodeId = null;
        List<Long> path = new LinkedList<>();
        if(startFloor < endFloor) {
            for (Long i = startFloor; i <= endFloor; i++) {
                ElevatorFloor elevatorFloor = elevatorFloorRepository.findByElevatorIdAndFloor(elevatorId, i).orElse(null);
                if(elevatorFloor == null) return new RouteInfo();
                distance += 5L;
                if(i.equals(endFloor)) lastNodeId = elevatorFloor.getNode().getId();
                else if(!i.equals(startFloor)) path.add(elevatorFloor.getNode().getId());
            }
        }
        else {
            for (Long i = startFloor; i >= endFloor; i--) {
                ElevatorFloor elevatorFloor = elevatorFloorRepository.findByElevatorIdAndFloor(elevatorId, i).orElse(null);
                if(elevatorFloor == null) return new RouteInfo();
                distance += 5L;
                if(i.equals(endFloor)) lastNodeId = elevatorFloor.getNode().getId();
                else if(!i.equals(startFloor)) path.add(elevatorFloor.getNode().getId());
            }
        }

        return new RouteInfo(distance, path, lastNodeId);
    }

    private RouteInfo moveFloorByStair(Long startFloor, Long endFloor, Long stairId) {
        if(Objects.equals(startFloor, endFloor)) return new RouteInfo();

        long distance = 0L;
        Long lastNodeId = null;
        List<Long> path = new LinkedList<>();
        if(startFloor < endFloor) {
            for (Long i = startFloor; i <= endFloor; i++) {
                StairFloor stairFloor = stairFloorRepository.findByStairIdAndFloor(stairId, i).orElse(null);
                if(stairFloor == null) return new RouteInfo();
                distance += 20L;
                if(i.equals(endFloor)) lastNodeId = stairFloor.getNode().getId();
                else if(!i.equals(startFloor)) path.add(stairFloor.getNode().getId());
            }
        }
        else {
            for (Long i = startFloor; i >= endFloor; i--) {
                StairFloor stairFloor = stairFloorRepository.findByStairIdAndFloor(stairId, i).orElse(null);
                if(stairFloor == null) return new RouteInfo();
                distance += 20L;
                if(i.equals(endFloor)) lastNodeId = stairFloor.getNode().getId();
                else if(!i.equals(startFloor)) path.add(stairFloor.getNode().getId());
            }
        }

        return new RouteInfo(distance, path, lastNodeId);
    }

    private double getEuclidDistance(Node node1, Node node2) {
        return (node1.getLatitude() - node2.getLatitude()) * (node1.getLatitude() - node2.getLatitude()) +
            (node1.getLongitude() - node2.getLongitude()) * (node1.getLongitude() - node2.getLongitude());
    }

    @Getter
    public static class NodeDistance {
        private final Long nodeId;
        private final Long distance;

        public NodeDistance(Long nodeId, Long distance) {
            this.nodeId = nodeId;
            this.distance = distance;
        }
    }

    @Getter
    public static class RouteInfo {
        private Long distance = 0L;
        private List<Long> path = new LinkedList<>();
        @Nullable
        private Long lastNodeId;

        public RouteInfo() {}

        public RouteInfo(Long distance, List<Long> path, @Nullable Long lastNodeId) {
            this.distance = distance;
            this.path = path;
            this.lastNodeId = lastNodeId;
        }

        public RouteInfo(Long distance, List<Long> path) {
            this.distance = distance;
            this.path = path;
        }
    }

}
