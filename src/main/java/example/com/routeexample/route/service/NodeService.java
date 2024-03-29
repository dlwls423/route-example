package example.com.routeexample.route.service;

import example.com.routeexample.route.dto.RouteGetResDto;
import example.com.routeexample.route.repository.NodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NodeService {

    private final NodeRepository nodeRepository;

    public RouteGetResDto getRoute(Long startNodeId, Long endNodeId) {
        // 최단 경로 찾기

        return new RouteGetResDto();
    }

}
