package example.com.routeexample.route.service;

import example.com.routeexample.route.entity.Edge;
import example.com.routeexample.route.entity.Node;
import java.util.*;

public class DijkstraAlgorithm {
    private Map<Node, Long> distances;
    private Map<Node, Node> predecessors;
    private Set<Node> visitedNodes;

    public DijkstraAlgorithm() {
        distances = new HashMap<>();
        predecessors = new HashMap<>();
        visitedNodes = new HashSet<>();
    }

    public void findShortestPath(Node source, Node target, Set<Edge> edges) {
        distances.clear();
        predecessors.clear();
        visitedNodes.clear();

        // 초기화
        for (Node node : edges.stream().map(Edge::getStart).distinct().toArray(Node[]::new)) {
            distances.put(node, Long.MAX_VALUE);
            predecessors.put(node, null);
        }
        distances.put(source, 0L);

        while (!visitedNodes.contains(target)) {
            Node current = getClosestUnvisitedNode();
            if (current == null) {
                break;
            }

            visitedNodes.add(current);
            updateDistances(current, edges);
        }
    }

    private Node getClosestUnvisitedNode() {
        return distances.entrySet().stream()
            .filter(entry -> !visitedNodes.contains(entry.getKey()))
            .min(Comparator.comparingLong(Map.Entry::getValue))
            .map(Map.Entry::getKey)
            .orElse(null);
    }

    private void updateDistances(Node current, Set<Edge> edges) {
        for (Edge edge : edges) {
            if (edge.getStart().equals(current) && !visitedNodes.contains(edge.getEnd())) {
                long newDistance = distances.get(current) + edge.getDistance();
                if (newDistance < distances.getOrDefault(edge.getEnd(), Long.MAX_VALUE)) {
                    distances.put(edge.getEnd(), newDistance);
                    predecessors.put(edge.getEnd(), current);
                }
            }
        }
    }

    public List<Long> getShortestPathTo(Node target) {
        List<Long> path = new ArrayList<>();
        for (Node node = target; node != null; node = predecessors.get(node)) {
            path.add(node.getId());
        }
        Collections.reverse(path);
        return path;
    }

    public long getShortestDistanceTo(Node target) {
        return distances.getOrDefault(target, Long.MAX_VALUE);
    }
}