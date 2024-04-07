package example.com.routeexample.classroom.repository;

import example.com.routeexample.JpaConfig;
import example.com.routeexample.building.entity.Building;
import example.com.routeexample.building.repository.BuildingRepository;
import example.com.routeexample.classroom.entity.Classroom;
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
class ClassroomRepositoryTest {
    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    NodeRepository nodeRepository;

//    @Test
//    @Disabled
//    @Transactional
//    @Rollback(value = false)
//    void save_애기능_강의실() {
//        Building aegineung = buildingRepository.findByName("애기능생활관");
//
//        Node node301 = nodeRepository.findById(9L).orElseThrow();
//        classroomRepository.save(new Classroom("301", "애기능 301호 강의실", true, null, aegineung, node301));
//
//        Node node302 = nodeRepository.findById(18L).orElseThrow();
//        classroomRepository.save(new Classroom("302", "애기능 302호 강의실", true, null, aegineung, node302));
//
//        Node node303 = nodeRepository.findById(16L).orElseThrow();
//        classroomRepository.save(new Classroom("303", "애기능 303호 강의실", true, null, aegineung, node303));
//
//        Node node304 = nodeRepository.findById(15L).orElseThrow();
//        classroomRepository.save(new Classroom("304", "애기능 304호 강의실", true, null, aegineung, node304));
//
//        Node node305 = nodeRepository.findById(14L).orElseThrow();
//        classroomRepository.save(new Classroom("305", "애기능 305호 강의실", true, null, aegineung, node305));
//
//        Node node306 = nodeRepository.findById(13L).orElseThrow();
//        classroomRepository.save(new Classroom("306", "애기능 306호 강의실", true, null, aegineung, node306));
//
//        Node node2 = nodeRepository.findById(2L).orElseThrow();
//        classroomRepository.save(new Classroom("학생식당", "애기능 학생식당", true, null, aegineung, node2));
//
//        Node node4 = nodeRepository.findById(4L).orElseThrow();
//        classroomRepository.save(new Classroom("교직원식당", "애기능 교직원식당", true, null, aegineung, node4));
//    }

    @Test
    @Disabled
    @Transactional
    @Rollback(value = false)
    void save_우당교양관_강의실() {
        Building udang = buildingRepository.findByName("우당교양관");

        // 1층
        classroomRepository.save(new Classroom("101", "우당교양관 101호 강의실", true, 1L, null, udang,
            nodeRepository.findById(12L).orElseThrow()));
        classroomRepository.save(new Classroom("102", "우당교양관 102호 강의실", true, 1L, null, udang,
            nodeRepository.findById(6L).orElseThrow()));
        classroomRepository.save(new Classroom("103", "우당교양관 103호 강의실", true, 1L, null, udang,
            nodeRepository.findById(3L).orElseThrow()));
        classroomRepository.save(new Classroom("104", "우당교양관 104호 강의실", true, 1L, null, udang,
            nodeRepository.findById(4L).orElseThrow()));
        classroomRepository.save(new Classroom("105", "우당교양관 105호 강의실", true, 1L, null, udang,
            nodeRepository.findById(7L).orElseThrow()));
        classroomRepository.save(new Classroom("108", "우당교양관 108호 강의실", true, 1L, null, udang,
            nodeRepository.findById(19L).orElseThrow()));
        classroomRepository.save(new Classroom("109", "우당교양관 109호 강의실", true, 1L, null, udang,
            nodeRepository.findById(22L).orElseThrow()));
        classroomRepository.save(new Classroom("110", "우당교양관 110호 강의실", true, 1L, null, udang,
            nodeRepository.findById(23L).orElseThrow()));
        classroomRepository.save(new Classroom("111", "우당교양관 111호 강의실", true, 1L, null, udang,
            nodeRepository.findById(20L).orElseThrow()));

        // 2층
        classroomRepository.save(new Classroom("201", "우당교양관 201호 강의실", true, 2L, null, udang,
            nodeRepository.findById(34L).orElseThrow()));
        classroomRepository.save(new Classroom("202", "우당교양관 202호 강의실", true, 2L, null, udang,
            nodeRepository.findById(30L).orElseThrow()));
        classroomRepository.save(new Classroom("203", "우당교양관 203호 강의실", true, 2L, null, udang,
            nodeRepository.findById(28L).orElseThrow()));
        classroomRepository.save(new Classroom("204", "우당교양관 204호 강의실", true, 2L, null, udang,
            nodeRepository.findById(32L).orElseThrow()));
        classroomRepository.save(new Classroom("207", "우당교양관 207호 강의실", true, 2L, null, udang,
            nodeRepository.findById(43L).orElseThrow()));
        classroomRepository.save(new Classroom("208", "우당교양관 208호 강의실", true, 2L, null, udang,
            nodeRepository.findById(46L).orElseThrow()));
        classroomRepository.save(new Classroom("209", "우당교양관 209호 강의실", true, 2L, null, udang,
            nodeRepository.findById(48L).orElseThrow()));
        classroomRepository.save(new Classroom("210", "우당교양관 210호 강의실", true, 2L, null, udang,
            nodeRepository.findById(44L).orElseThrow()));

        // 3층
        classroomRepository.save(new Classroom("301", "우당교양관 301호 강의실", true, 3L, null, udang,
            nodeRepository.findById(62L).orElseThrow()));
        classroomRepository.save(new Classroom("302", "우당교양관 302호 강의실", true, 3L, null, udang,
            nodeRepository.findById(60L).orElseThrow()));
        classroomRepository.save(new Classroom("303", "우당교양관 303호 강의실", true, 3L, null, udang,
            nodeRepository.findById(56L).orElseThrow()));
        classroomRepository.save(new Classroom("304", "우당교양관 304호 강의실", true, 3L, null, udang,
            nodeRepository.findById(52L).orElseThrow()));
        classroomRepository.save(new Classroom("305", "우당교양관 305호 강의실", true, 3L, null, udang,
            nodeRepository.findById(53L).orElseThrow()));
        classroomRepository.save(new Classroom("306", "우당교양관 306호 강의실", true, 3L, null, udang,
            nodeRepository.findById(55L).orElseThrow()));
        classroomRepository.save(new Classroom("309", "우당교양관 309호 강의실", true, 3L, null, udang,
            nodeRepository.findById(71L).orElseThrow()));
        classroomRepository.save(new Classroom("310", "우당교양관 310호 강의실", true, 3L, null, udang,
            nodeRepository.findById(74L).orElseThrow()));
        classroomRepository.save(new Classroom("311", "우당교양관 311호 강의실", true, 3L, null, udang,
            nodeRepository.findById(75L).orElseThrow()));
        classroomRepository.save(new Classroom("312", "우당교양관 312호 강의실", true, 3L, null, udang,
            nodeRepository.findById(73L).orElseThrow()));
        classroomRepository.save(new Classroom("313", "우당교양관 313호 강의실", true, 3L, null, udang,
            nodeRepository.findById(72L).orElseThrow()));
        classroomRepository.save(new Classroom("314", "우당교양관 314호 강의실", true, 3L, null, udang,
            nodeRepository.findById(69L).orElseThrow()));
        classroomRepository.save(new Classroom("315", "우당교양관 315호 강의실", true, 3L, null, udang,
            nodeRepository.findById(63L).orElseThrow()));

        // 4층
        classroomRepository.save(new Classroom("401", "우당교양관 401호 강의실", true, 4L, null, udang,
            nodeRepository.findById(89L).orElseThrow()));
        classroomRepository.save(new Classroom("402", "우당교양관 402호 강의실", true, 4L, null, udang,
            nodeRepository.findById(87L).orElseThrow()));
        classroomRepository.save(new Classroom("403", "우당교양관 403호 강의실", true, 4L, null, udang,
            nodeRepository.findById(82L).orElseThrow()));
        classroomRepository.save(new Classroom("404", "우당교양관 404호 강의실", true, 4L, null, udang,
            nodeRepository.findById(79L).orElseThrow()));
        classroomRepository.save(new Classroom("405", "우당교양관 405호 강의실", true, 4L, null, udang,
            nodeRepository.findById(80L).orElseThrow()));
        classroomRepository.save(new Classroom("406", "우당교양관 406호 강의실", true, 4L, null, udang,
            nodeRepository.findById(83L).orElseThrow()));
        classroomRepository.save(new Classroom("409", "우당교양관 409호 강의실", true, 4L, null, udang,
            nodeRepository.findById(98L).orElseThrow()));
        classroomRepository.save(new Classroom("410", "우당교양관 410호 강의실", true, 4L, null, udang,
            nodeRepository.findById(101L).orElseThrow()));
        classroomRepository.save(new Classroom("411", "우당교양관 411호 강의실", true, 4L, null, udang,
            nodeRepository.findById(102L).orElseThrow()));
        classroomRepository.save(new Classroom("412", "우당교양관 412호 강의실", true, 4L, null, udang,
            nodeRepository.findById(99L).orElseThrow()));
        classroomRepository.save(new Classroom("413", "우당교양관 413호 강의실", true, 4L, null, udang,
            nodeRepository.findById(95L).orElseThrow()));
        classroomRepository.save(new Classroom("414", "우당교양관 414호 강의실", true, 4L, null, udang,
            nodeRepository.findById(90L).orElseThrow()));

    }
}