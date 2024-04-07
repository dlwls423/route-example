package example.com.routeexample.elevator.entity;

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
@Table(name = "tb_elevator_floor")
public class ElevatorFloor {
    @Id
    @GeneratedValue
    private Long elevatorFloorId;

    @ManyToOne
    @JoinColumn(name = "elevator_id")
    private Elevator elevator;

    @OneToOne
    @JoinColumn(name = "node_id")
    private Node node;
}
