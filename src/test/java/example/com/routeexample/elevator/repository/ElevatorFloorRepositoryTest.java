package example.com.routeexample.elevator.repository;

import static org.junit.jupiter.api.Assertions.*;

import example.com.routeexample.JpaConfig;
import example.com.routeexample.building.entity.Building;
import example.com.routeexample.elevator.entity.Elevator;
import example.com.routeexample.elevator.entity.ElevatorFloor;
import example.com.routeexample.route.entity.Node;
import example.com.routeexample.route.repository.NodeRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
@Import(JpaConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ElevatorFloorRepositoryTest {
    @Autowired
    ElevatorFloorRepository elevatorFloorRepository;

    @Autowired
    ElevatorRepository elevatorRepository;

    @Autowired
    NodeRepository nodeRepository;

    @Test
    @Disabled
    @Transactional
    @Rollback(value = false)
    void save_우당교양관_엘리베이터_층() {
        Elevator elevator = elevatorRepository.findById(1L).orElseThrow();

        Node node1 = nodeRepository.findById(14L).orElseThrow();
        elevatorFloorRepository.save(new ElevatorFloor(elevator, node1, 1L));

        Node node2 = nodeRepository.findById(38L).orElseThrow();
        elevatorFloorRepository.save(new ElevatorFloor(elevator, node2, 2L));

        Node node3 = nodeRepository.findById(66L).orElseThrow();
        elevatorFloorRepository.save(new ElevatorFloor(elevator, node3, 3L));

        Node node4 = nodeRepository.findById(93L).orElseThrow();
        elevatorFloorRepository.save(new ElevatorFloor(elevator, node4, 4L));
    }
}