package example.com.routeexample.entrance.repository;

import static org.junit.jupiter.api.Assertions.*;

import example.com.routeexample.JpaConfig;
import example.com.routeexample.building.entity.Building;
import example.com.routeexample.building.repository.BuildingRepository;
import example.com.routeexample.entrance.entity.Entrance;
import example.com.routeexample.route.entity.Node;
import example.com.routeexample.route.repository.NodeRepository;
import java.util.ArrayList;
import java.util.List;
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
class EntranceRepositoryTest {
    @Autowired
    EntranceRepository entranceRepository;

    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    NodeRepository nodeRepository;

    @Test
//    @Disabled
    @Transactional
    @Rollback(value = false)
    void save애기능() {
        Building aegineung = buildingRepository.findByName("애기능생활관");
        Node frontNode = nodeRepository.findById(1L).orElseThrow();
        Node backNode = nodeRepository.findById(6L).orElseThrow();

        entranceRepository.save(new Entrance("정문", aegineung, frontNode));
        entranceRepository.save(new Entrance("후문", aegineung, backNode));
    }
}