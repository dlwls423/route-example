package example.com.routeexample.route.service;

import example.com.routeexample.route.dto.RouteGetResDto;
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

    private static final Map<Long, Map<Long, Integer>> graph = new HashMap<>();

    public RouteGetResDto findRoute(Long startNodeId, Long endNodeId) {
        // 그래프
        graph.put(1L, new HashMap<>());
        graph.get(1L).put(2L, 14);
        graph.get(1L).put(5L, 9);
        graph.get(1L).put(7L, 30);
        graph.put(2L, new HashMap<>());
        graph.get(2L).put(1L, 14);
        graph.get(2L).put(3L, 22);
        graph.get(2L).put(5L, 9);
        graph.put(3L, new HashMap<>());
        graph.get(3L).put(2L, 22);
        graph.get(3L).put(4L, 13);
        graph.get(3L).put(6L, 11);
        graph.put(4L, new HashMap<>());
        graph.get(4L).put(3L, 13);
        graph.get(4L).put(5L, 24);
        graph.get(4L).put(6L, 6);
        graph.put(5L, new HashMap<>());
        graph.get(5L).put(1L, 9);
        graph.get(5L).put(2L, 19);
        graph.get(5L).put(4L, 24);
        graph.put(6L, new HashMap<>());
        graph.get(6L).put(3L, 11);
        graph.get(6L).put(4L, 6);
        graph.get(6L).put(21L, 30);
        graph.put(7L, new HashMap<>());
        graph.get(7L).put(8L, 4);
        graph.put(8L, new HashMap<>());
        graph.get(8L).put(9L, 12);
        graph.get(8L).put(20L, 4);
        graph.put(9L, new HashMap<>());
        graph.get(9L).put(8L, 12);
        graph.get(9L).put(10L, 6);
        graph.put(10L, new HashMap<>());
        graph.get(10L).put(9L, 6);
        graph.get(10L).put(11L, 5);
        graph.put(11L, new HashMap<>());
        graph.get(11L).put(10L, 5);
        graph.get(11L).put(12L, 5);
        graph.put(12L, new HashMap<>());
        graph.get(12L).put(11L, 5);
        graph.get(12L).put(13L, 5);
        graph.put(13L, new HashMap<>());
        graph.get(13L).put(12L, 5);
        graph.get(13L).put(14L, 3);
        graph.put(14L, new HashMap<>());
        graph.get(14L).put(13L, 3);
        graph.get(14L).put(15L, 7);
        graph.put(15L, new HashMap<>());
        graph.get(15L).put(14L, 7);
        graph.get(15L).put(16L, 5);
        graph.get(15L).put(21L, 2);
        graph.put(16L, new HashMap<>());
        graph.get(16L).put(15L, 5);
        graph.get(16L).put(17L, 12);
        graph.put(17L, new HashMap<>());
        graph.get(17L).put(16L, 12);
        graph.get(17L).put(18L, 10);
        graph.put(18L, new HashMap<>());
        graph.get(18L).put(17L, 10);
        graph.get(18L).put(19L, 5);
        graph.put(19L, new HashMap<>());
        graph.get(19L).put(18L, 5);
        graph.get(19L).put(20L, 4);
        graph.put(20L, new HashMap<>());
        graph.get(20L).put(8L, 4);
        graph.get(20L).put(19L, 4);
        graph.put(21L, new HashMap<>());
        graph.get(21L).put(15L, 5);
        graph.get(21L).put(6L, 30);

        // 최단 경로 찾기
        Map<Long, Long> distances = new HashMap<>();
        Map<Long, Long> previousNodes = new HashMap<>();
        PriorityQueue<NodeDistance> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(NodeDistance::getDistance));

        // 초기화
        for (Long nodeId : graph.keySet()) {
            distances.put(nodeId, nodeId.equals(startNodeId) ? 0 : Long.MAX_VALUE);
            previousNodes.put(nodeId, null);
            priorityQueue.add(new NodeDistance(nodeId, distances.get(nodeId)));
        }

        while (!priorityQueue.isEmpty()) {
            Long currentNodeId = priorityQueue.poll().getNodeId();
            Map<Long, Integer> neighbors = graph.get(currentNodeId);

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
