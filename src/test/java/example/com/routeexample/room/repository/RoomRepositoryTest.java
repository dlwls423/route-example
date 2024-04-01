package example.com.routeexample.room.repository;

import static org.junit.jupiter.api.Assertions.*;

import example.com.routeexample.JpaConfig;
import example.com.routeexample.building.entity.Building;
import example.com.routeexample.building.repository.BuildingRepository;
import example.com.routeexample.room.entity.Room;
import example.com.routeexample.route.entity.Node;
import example.com.routeexample.route.repository.NodeRepository;
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
class RoomRepositoryTest {
    @Autowired
    RoomRepository roomRepository;

    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    NodeRepository nodeRepository;

    @Test
    @Disabled
    @Transactional
    @Rollback(value = false)
    void save애기능() {
        Building aegineung = buildingRepository.findByName("애기능생활관");

        Node node301 = nodeRepository.findById(9L).orElseThrow();
        roomRepository.save(new Room("301", "애기능 301호 강의실", true, null, aegineung, node301));

        Node node302 = nodeRepository.findById(18L).orElseThrow();
        roomRepository.save(new Room("302", "애기능 302호 강의실", true, null, aegineung, node302));

        Node node303 = nodeRepository.findById(16L).orElseThrow();
        roomRepository.save(new Room("303", "애기능 303호 강의실", true, null, aegineung, node303));

        Node node304 = nodeRepository.findById(15L).orElseThrow();
        roomRepository.save(new Room("304", "애기능 304호 강의실", true, null, aegineung, node304));

        Node node305 = nodeRepository.findById(14L).orElseThrow();
        roomRepository.save(new Room("305", "애기능 305호 강의실", true, null, aegineung, node305));

        Node node306 = nodeRepository.findById(13L).orElseThrow();
        roomRepository.save(new Room("306", "애기능 306호 강의실", true, null, aegineung, node306));

        Node node2 = nodeRepository.findById(2L).orElseThrow();
        roomRepository.save(new Room("학생식당", "애기능 학생식당", true, null, aegineung, node2));

        Node node4 = nodeRepository.findById(4L).orElseThrow();
        roomRepository.save(new Room("교직원식당", "애기능 교직원식당", true, null, aegineung, node4));
    }
}