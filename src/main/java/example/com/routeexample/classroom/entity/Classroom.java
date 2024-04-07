package example.com.routeexample.classroom.entity;

import example.com.routeexample.building.entity.Building;
import example.com.routeexample.route.entity.Node;
import jakarta.annotation.Nullable;
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
@Table(name = "tb_classroom")
public class Classroom {
    @Id
    @GeneratedValue
    private Long classroomId;

    private String name;
    private String detail;
    private Boolean plugAvailability;

    @Nullable
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @OneToOne
    @JoinColumn(name = "node_id")
    private Node node;

    public Classroom(String name, String detail, Boolean plugAvailability, @Nullable String imageUrl,
        Building building, Node node) {
        this.name = name;
        this.detail = detail;
        this.plugAvailability = plugAvailability;
        this.imageUrl = imageUrl;
        this.building = building;
        this.node = node;
    }
}
