package example.com.routeexample.facility.entity;

import example.com.routeexample.building.entity.Building;
import example.com.routeexample.route.entity.Node;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_facility")
public class Facility {
    @Id
    @GeneratedValue
    private Long id;

    private Type type;
    private Long floor;
    private Boolean availability;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @OneToOne
    @JoinColumn(name = "node_id")
    private Node node;

    public Facility(Type type, Long floor, Boolean availability, String imageUrl, Building building,
        Node node) {
        this.type = type;
        this.floor = floor;
        this.availability = availability;
        this.imageUrl = imageUrl;
        this.building = building;
        this.node = node;
    }
}
