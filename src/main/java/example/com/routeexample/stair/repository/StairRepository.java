package example.com.routeexample.stair.repository;

import example.com.routeexample.stair.entity.Stair;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StairRepository extends JpaRepository<Stair, Long> {
    List<Stair> findAllByBuildingId(Long buildingId);
}
