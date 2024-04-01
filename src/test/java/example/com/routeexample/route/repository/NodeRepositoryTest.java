package example.com.routeexample.route.repository;

import static example.com.routeexample.route.entity.Type.ENTRANCE;
import static example.com.routeexample.route.entity.Type.NORMAL;
import static example.com.routeexample.route.entity.Type.STAIR;
import static org.junit.jupiter.api.Assertions.*;

import example.com.routeexample.JpaConfig;
import example.com.routeexample.route.entity.Node;
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
class NodeRepositoryTest {
    @Autowired
    NodeRepository nodeRepository;

    @Test
    @Disabled
    @Transactional
    @Rollback(value = false)
    void saveGraph1() {
        // 애기능 1층 노드
        nodeRepository.save(new Node(1L, 230.0, 790.0, 1L, ENTRANCE));
        nodeRepository.save(new Node(2L, 198.0, 216.0, 1L, NORMAL));
        nodeRepository.save(new Node(3L, 222.0, 498.0, 1L, NORMAL));
        nodeRepository.save(new Node(4L, 760.0, 392.0, 1L, NORMAL));
        nodeRepository.save(new Node(5L, 556.0, 708.0, 1L, NORMAL));
        nodeRepository.save(new Node(6L, 788.0, 242.0, 1L, ENTRANCE));
    }

    @Test
    @Disabled
    @Transactional
    @Rollback(value = false)
    void saveGraph2() {
        // 애기능 2층 노드
        nodeRepository.save(new Node(7L, 194.0, 748.0, 2L, STAIR)); //7
        nodeRepository.save(new Node(8L, 284.0, 694.0, 2L, NORMAL));
        nodeRepository.save(new Node(9L, 164.0, 461.0, 2L, NORMAL));
        nodeRepository.save(new Node(10L, 198.0, 336.0, 2L, NORMAL));
        nodeRepository.save(new Node(11L, 257.0, 247.0, 2L, NORMAL));
        nodeRepository.save(new Node(12L, 354.0, 190.0, 2L, NORMAL));
        nodeRepository.save(new Node(13L, 477.0, 163.0, 2L, NORMAL));
        nodeRepository.save(new Node(14L, 549.0, 167.0, 2L, NORMAL));
        nodeRepository.save(new Node(15L, 720.0, 220.0, 2L, NORMAL));
        nodeRepository.save(new Node(16L, 750.0, 324.0, 2L, NORMAL));
        nodeRepository.save(new Node(17L, 750.0, 573.0, 2L, NORMAL));
        nodeRepository.save(new Node(18L, 590.0, 735.0, 2L, NORMAL));
        nodeRepository.save(new Node(19L, 463.0, 756.0, 2L, NORMAL));
        nodeRepository.save(new Node(20L, 378.0, 742.0, 2L, NORMAL));
        nodeRepository.save(new Node(21L, 780.0, 162.0, 2L, STAIR));
    }
}