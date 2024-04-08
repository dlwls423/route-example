package example.com.routeexample.route.dto;

import example.com.routeexample.route.service.RouteService.RouteInfo;
import java.util.LinkedList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RouteGetResDto {
    private Long startId;
    private String startName;
    private Long endId;
    private String endName;
    private Long distance = 0L;
    private List<Long> path = new LinkedList<>();

    public RouteGetResDto(Long startId, String startName, Long endId, String endName, Long distance,
        List<Long> path) {
        this.startId = startId;
        this.startName = startName;
        this.endId = endId;
        this.endName = endName;
        this.distance = distance;
        this.path = path;
    }

    public void setRouteInfo(RouteInfo routeInfo) {
        if(routeInfo.getDistance() != null) {
            this.distance += routeInfo.getDistance();
            this.path.addAll(routeInfo.getPath());
        }
    }
}
