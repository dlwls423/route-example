package example.com.routeexample.route.repository;

import example.com.routeexample.route.entity.Edge;
import example.com.routeexample.route.entity.Node;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdgeRepository extends JpaRepository<Edge, Long> {

    List<Edge> findByStartNode(Node node);
}
