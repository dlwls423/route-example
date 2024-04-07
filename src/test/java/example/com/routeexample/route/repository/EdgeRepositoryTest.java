package example.com.routeexample.route.repository;

import static org.junit.jupiter.api.Assertions.*;

import example.com.routeexample.JpaConfig;
import example.com.routeexample.route.entity.Edge;
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
class EdgeRepositoryTest {
    @Autowired
    EdgeRepository edgeRepository;

    @Autowired
    NodeRepository nodeRepository;

    @Test
    @Disabled
    @Transactional
    @Rollback(value = false)
    void saveGraph1() {
        // 애기능 간선
        edgeRepository.save(new Edge(nodeRepository.findById(1L).orElseThrow(), nodeRepository.findById(2L).orElseThrow(), 14L));
        edgeRepository.save(new Edge(nodeRepository.findById(1L).orElseThrow(), nodeRepository.findById(5L).orElseThrow(), 9L));
        edgeRepository.save(new Edge(nodeRepository.findById(1L).orElseThrow(), nodeRepository.findById(7L).orElseThrow(), 30L));
        edgeRepository.save(new Edge(nodeRepository.findById(2L).orElseThrow(), nodeRepository.findById(1L).orElseThrow(), 14L));
        edgeRepository.save(new Edge(nodeRepository.findById(2L).orElseThrow(), nodeRepository.findById(3L).orElseThrow(), 22L));
        edgeRepository.save(new Edge(nodeRepository.findById(2L).orElseThrow(), nodeRepository.findById(5L).orElseThrow(), 9L));
        edgeRepository.save(new Edge(nodeRepository.findById(3L).orElseThrow(), nodeRepository.findById(2L).orElseThrow(), 22L));
        edgeRepository.save(new Edge(nodeRepository.findById(3L).orElseThrow(), nodeRepository.findById(4L).orElseThrow(), 13L));
        edgeRepository.save(new Edge(nodeRepository.findById(3L).orElseThrow(), nodeRepository.findById(6L).orElseThrow(), 11L));
        edgeRepository.save(new Edge(nodeRepository.findById(4L).orElseThrow(), nodeRepository.findById(3L).orElseThrow(), 13L));
        edgeRepository.save(new Edge(nodeRepository.findById(4L).orElseThrow(), nodeRepository.findById(5L).orElseThrow(), 24L));
        edgeRepository.save(new Edge(nodeRepository.findById(4L).orElseThrow(), nodeRepository.findById(6L).orElseThrow(), 6L));
        edgeRepository.save(new Edge(nodeRepository.findById(5L).orElseThrow(), nodeRepository.findById(1L).orElseThrow(), 9L));
        edgeRepository.save(new Edge(nodeRepository.findById(5L).orElseThrow(), nodeRepository.findById(2L).orElseThrow(), 19L));
        edgeRepository.save(new Edge(nodeRepository.findById(5L).orElseThrow(), nodeRepository.findById(4L).orElseThrow(), 24L));
        edgeRepository.save(new Edge(nodeRepository.findById(6L).orElseThrow(), nodeRepository.findById(3L).orElseThrow(), 11L));
        edgeRepository.save(new Edge(nodeRepository.findById(6L).orElseThrow(), nodeRepository.findById(4L).orElseThrow(), 6L));
        edgeRepository.save(new Edge(nodeRepository.findById(6L).orElseThrow(), nodeRepository.findById(21L).orElseThrow(), 30L));
        edgeRepository.save(new Edge(nodeRepository.findById(7L).orElseThrow(), nodeRepository.findById(8L).orElseThrow(), 4L));
        edgeRepository.save(new Edge(nodeRepository.findById(8L).orElseThrow(), nodeRepository.findById(9L).orElseThrow(), 12L));
        edgeRepository.save(new Edge(nodeRepository.findById(8L).orElseThrow(), nodeRepository.findById(20L).orElseThrow(), 4L));
        edgeRepository.save(new Edge(nodeRepository.findById(9L).orElseThrow(), nodeRepository.findById(8L).orElseThrow(), 12L));
        edgeRepository.save(new Edge(nodeRepository.findById(9L).orElseThrow(), nodeRepository.findById(10L).orElseThrow(), 6L));
        edgeRepository.save(new Edge(nodeRepository.findById(10L).orElseThrow(), nodeRepository.findById(9L).orElseThrow(), 6L));
        edgeRepository.save(new Edge(nodeRepository.findById(10L).orElseThrow(), nodeRepository.findById(11L).orElseThrow(), 5L));
        edgeRepository.save(new Edge(nodeRepository.findById(11L).orElseThrow(), nodeRepository.findById(10L).orElseThrow(), 5L));
        edgeRepository.save(new Edge(nodeRepository.findById(11L).orElseThrow(), nodeRepository.findById(12L).orElseThrow(), 5L));
        edgeRepository.save(new Edge(nodeRepository.findById(12L).orElseThrow(), nodeRepository.findById(11L).orElseThrow(), 5L));
        edgeRepository.save(new Edge(nodeRepository.findById(12L).orElseThrow(), nodeRepository.findById(13L).orElseThrow(), 5L));
        edgeRepository.save(new Edge(nodeRepository.findById(13L).orElseThrow(), nodeRepository.findById(12L).orElseThrow(), 5L));
        edgeRepository.save(new Edge(nodeRepository.findById(13L).orElseThrow(), nodeRepository.findById(14L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(14L).orElseThrow(), nodeRepository.findById(13L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(14L).orElseThrow(), nodeRepository.findById(15L).orElseThrow(), 7L));
        edgeRepository.save(new Edge(nodeRepository.findById(15L).orElseThrow(), nodeRepository.findById(14L).orElseThrow(), 7L));
        edgeRepository.save(new Edge(nodeRepository.findById(15L).orElseThrow(), nodeRepository.findById(16L).orElseThrow(), 5L));
        edgeRepository.save(new Edge(nodeRepository.findById(15L).orElseThrow(), nodeRepository.findById(21L).orElseThrow(), 2L));
        edgeRepository.save(new Edge(nodeRepository.findById(16L).orElseThrow(), nodeRepository.findById(15L).orElseThrow(), 5L));
        edgeRepository.save(new Edge(nodeRepository.findById(16L).orElseThrow(), nodeRepository.findById(17L).orElseThrow(), 12L));
        edgeRepository.save(new Edge(nodeRepository.findById(17L).orElseThrow(), nodeRepository.findById(16L).orElseThrow(), 12L));
        edgeRepository.save(new Edge(nodeRepository.findById(17L).orElseThrow(), nodeRepository.findById(18L).orElseThrow(), 10L));
        edgeRepository.save(new Edge(nodeRepository.findById(18L).orElseThrow(), nodeRepository.findById(17L).orElseThrow(), 10L));
        edgeRepository.save(new Edge(nodeRepository.findById(18L).orElseThrow(), nodeRepository.findById(19L).orElseThrow(), 5L));
        edgeRepository.save(new Edge(nodeRepository.findById(19L).orElseThrow(), nodeRepository.findById(18L).orElseThrow(), 5L));
        edgeRepository.save(new Edge(nodeRepository.findById(19L).orElseThrow(), nodeRepository.findById(20L).orElseThrow(), 4L));
        edgeRepository.save(new Edge(nodeRepository.findById(20L).orElseThrow(), nodeRepository.findById(8L).orElseThrow(), 4L));
        edgeRepository.save(new Edge(nodeRepository.findById(20L).orElseThrow(), nodeRepository.findById(19L).orElseThrow(), 4L));
        edgeRepository.save(new Edge(nodeRepository.findById(21L).orElseThrow(), nodeRepository.findById(15L).orElseThrow(), 5L));
        edgeRepository.save(new Edge(nodeRepository.findById(21L).orElseThrow(), nodeRepository.findById(6L).orElseThrow(), 30L));

    }
}