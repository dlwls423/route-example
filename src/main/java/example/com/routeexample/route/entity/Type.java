package example.com.routeexample.route.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Type {
    NORMAL("일반"),
    STAIR("계단"),
    ELEVATOR("엘리베이터"),
    ENTRANCE("출입구");

    private final String value;
}
