package example.com.routeexample.route.service;

import example.com.routeexample.route.dto.RouteGetResDto;
import example.com.routeexample.route.entity.Edge;
import example.com.routeexample.route.entity.Node;
import example.com.routeexample.route.repository.EdgeRepository;
import example.com.routeexample.route.repository.NodeRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NodeService {

    private final NodeRepository nodeRepository;
    private final EdgeRepository edgeRepository;

    public RouteGetResDto findRoute(Long startNodeId, Long endNodeId) {
        // 최단 경로 찾기
        Map<Long, Long> distances = new HashMap<>();
        Map<Long, Long> previousNodes = new HashMap<>();
        PriorityQueue<NodeDistance> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(NodeDistance::getDistance));
        List<Node> nodes = nodeRepository.findAll();

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

            if (neighbors != null) {
                for (Long neighborId : neighbors.keySet()) {
                    long newDistance = distances.get(currentNodeId) + neighbors.get(neighborId);
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
        RouteGetResDto routeGetResDto = new RouteGetResDto(startNodeId, "출발지 노드의 이름", endNodeId, "도착지 노드의 이름", distances.get(endNodeId), shortestPath);
        log.info("최단 경로: " + shortestPath);
        log.info("최단 거리: " + distances.get(endNodeId));

        return routeGetResDto;
    }

    public Map<Long, Long> findNeighbors(Long currentNodeId) {
        Map<Long, Long> neighbors = new HashMap<>();
        Node node = nodeRepository.findById(currentNodeId).orElseThrow();
        List<Edge> edges = edgeRepository.findByStart(node);
        for(Edge edge : edges) {
            neighbors.put(edge.getEnd().getId(), edge.getDistance());
        }
        return neighbors;
    }

    @Getter
    static class NodeDistance {
        private final Long nodeId;
        private final Long distance;

        public NodeDistance(Long nodeId, Long distance) {
            this.nodeId = nodeId;
            this.distance = distance;
        }

    }

}
