package example.com.routeexample.elevator.entity;

import example.com.routeexample.building.entity.Building;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_elevator")
public class Elevator {
    @Id
    @GeneratedValue
    private Long id;

    private Long floor;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
}
