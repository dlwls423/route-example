package example.com.routeexample.elevator.repository;

import example.com.routeexample.elevator.entity.Elevator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElevatorRepository extends JpaRepository<Elevator, Long> {

}
