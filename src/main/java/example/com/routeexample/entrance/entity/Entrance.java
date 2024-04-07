package example.com.routeexample.entrance.entity;

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
@Table(name = "tb_entrance")
public class Entrance {
    @Id
    @GeneratedValue
    private Long entranceId;

    private String detail;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @OneToOne
    @JoinColumn(name = "node_id")
    private Node node;

    public Entrance(String detail, Building building, Node node) {
        this.detail = detail;
        this.building = building;
        this.node = node;
    }
}
