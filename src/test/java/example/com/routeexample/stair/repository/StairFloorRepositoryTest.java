package example.com.routeexample.stair.repository;

import static org.junit.jupiter.api.Assertions.*;

import example.com.routeexample.JpaConfig;
import example.com.routeexample.route.entity.Node;
import example.com.routeexample.route.repository.NodeRepository;
import example.com.routeexample.stair.entity.Stair;
import example.com.routeexample.stair.entity.StairFloor;
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
class StairFloorRepositoryTest {
    @Autowired
    StairFloorRepository stairFloorRepository;

    @Autowired
    StairRepository stairRepository;

    @Autowired
    NodeRepository nodeRepository;

    @Test
    @Disabled
    @Transactional
    @Rollback(value = false)
    void save_우당교양관_계단_층() {
        Stair stair1 = stairRepository.findById(1L).orElseThrow();
        Stair stair2 = stairRepository.findById(2L).orElseThrow();
        Stair stair3 = stairRepository.findById(3L).orElseThrow();

        Node node11 = nodeRepository.findById(13L).orElseThrow();
        stairFloorRepository.save(new StairFloor(stair1, node11, 1L));
        Node node12 = nodeRepository.findById(25L).orElseThrow();
        stairFloorRepository.save(new StairFloor(stair2, node12, 1L));
        Node node13 = nodeRepository.findById(26L).orElseThrow();
        stairFloorRepository.save(new StairFloor(stair3, node13, 1L));

        Node node21 = nodeRepository.findById(37L).orElseThrow();
        stairFloorRepository.save(new StairFloor(stair1, node21, 2L));
        Node node22 = nodeRepository.findById(49L).orElseThrow();
        stairFloorRepository.save(new StairFloor(stair2, node22, 2L));
        Node node23 = nodeRepository.findById(27L).orElseThrow();
        stairFloorRepository.save(new StairFloor(stair3, node23, 2L));

        Node node31 = nodeRepository.findById(65L).orElseThrow();
        stairFloorRepository.save(new StairFloor(stair1, node31, 3L));
        Node node32 = nodeRepository.findById(76L).orElseThrow();
        stairFloorRepository.save(new StairFloor(stair2, node32, 3L));
        Node node33 = nodeRepository.findById(50L).orElseThrow();
        stairFloorRepository.save(new StairFloor(stair3, node33, 3L));

        Node node41 = nodeRepository.findById(92L).orElseThrow();
        stairFloorRepository.save(new StairFloor(stair1, node41, 4L));
        Node node42 = nodeRepository.findById(104L).orElseThrow();
        stairFloorRepository.save(new StairFloor(stair2, node42, 4L));
        Node node43 = nodeRepository.findById(77L).orElseThrow();
        stairFloorRepository.save(new StairFloor(stair3, node43, 4L));
    }

}