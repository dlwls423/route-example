package example.com.routeexample.elevator.repository;

import example.com.routeexample.elevator.entity.ElevatorFloor;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElevatorFloorRepository extends JpaRepository<ElevatorFloor, Long> {
    Optional<ElevatorFloor> findByElevatorIdAndFloor(Long elevatorId, Long floor);
}
