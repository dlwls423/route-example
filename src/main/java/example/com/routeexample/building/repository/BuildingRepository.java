package example.com.routeexample.building.repository;

import example.com.routeexample.building.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Long> {

    Building findByName(String name);
}
