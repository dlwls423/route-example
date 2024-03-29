package example.com.routeexample.route.dto;

import example.com.routeexample.route.entity.Node;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RouteGetResDto {
    private Long startId;
    private String startName;
    private Long endId;
    private String endName;
    private Long distance;
    private Long minutes;
    private List<Node> nodeList = new ArrayList<>();
}
