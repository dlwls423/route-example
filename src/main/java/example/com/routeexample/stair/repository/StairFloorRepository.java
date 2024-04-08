package example.com.routeexample.stair.repository;

import example.com.routeexample.stair.entity.StairFloor;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StairFloorRepository extends JpaRepository<StairFloor, Long> {
    Optional<StairFloor> findByStairIdAndFloor(Long StairId, Long floor);
}
