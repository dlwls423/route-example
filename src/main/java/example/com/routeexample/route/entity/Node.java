package example.com.routeexample.route.entity;

import example.com.routeexample.building.entity.Building;
import example.com.routeexample.classroom.entity.Classroom;
import example.com.routeexample.elevator.entity.Elevator;
import example.com.routeexample.facility.entity.Facility;
import example.com.routeexample.stair.entity.Stair;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_node")
public class Node {
    @Id
    @GeneratedValue
    private Long nodeId;

    private Double latitude;

    private Double longitude;

    private Long floor;

    @Nullable
    @OneToOne
    private Classroom classroom;

    @Nullable
    @OneToOne
    private Facility facility;

    @Nullable
    @ManyToOne
    private Building building;

    @Nullable
    @OneToOne
    private Elevator elevator;

    @Nullable
    @OneToOne
    private Stair stair;


    public Node(Long id, Double latitude, Double longitude, Long floor) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.floor = floor;
    }
}
