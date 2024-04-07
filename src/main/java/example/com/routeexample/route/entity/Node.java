package example.com.routeexample.route.entity;

import example.com.routeexample.building.entity.Building;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_node")
public class Node {
    @Id
    private Long id;

    private Double latitude;

    private Double longitude;

    private Long floor;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @Builder
    public Node(Long id, Double latitude, Double longitude, Long floor, Building building) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.floor = floor;
        this.building = building;
    }

}
