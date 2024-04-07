package example.com.routeexample.facility.entity;

public enum Type {
    MEN_RESTROOM("남자 화장실"),
    WOMEN_RESTROOM("여자 화장실"),
    DISABLED_RESTROOM("장애인 화장실"),
    VENDING_MACHINE("자판기"),
    PRINTER("프린트기"),
    LOUNGE("라운지"),
    CAFE("카페"),
    RESTAURANT("음식점"),
    SLEEPING_ROOM("수면실"),
    WATER_PURIFIER("정수기"),
    SMOKING_AREA("흡연 구역"),
    CONVENIENCE_STORE("편의점"),
    READING_ROOM("열람실"),
    STUDY_ROOM("스터디룸");

    private String name;

    Type(String name) {
        this.name = name;
    }
}
