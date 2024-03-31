package example.com.routeexample.route.dto;

import java.util.ArrayList;
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
    private Long distance;
    private List<Long> path = new ArrayList<>();

    public RouteGetResDto(Long startId, String startName, Long endId, String endName, Long distance,
        List<Long> path) {
        this.startId = startId;
        this.startName = startName;
        this.endId = endId;
        this.endName = endName;
        this.distance = distance;
        this.path = path;
    }
}
