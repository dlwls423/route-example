package example.com.routeexample.route.repository;

import example.com.routeexample.route.entity.Node;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeRepository extends JpaRepository<Node, Long> {
    List<Node> findByBuildingIdAndFloor(Long buildingId, Long floor);
}
