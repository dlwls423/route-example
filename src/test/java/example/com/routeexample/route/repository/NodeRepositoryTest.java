package example.com.routeexample.route.repository;

import static org.junit.jupiter.api.Assertions.*;

import example.com.routeexample.JpaConfig;
import example.com.routeexample.building.entity.Building;
import example.com.routeexample.building.repository.BuildingRepository;
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

    @Autowired
    BuildingRepository buildingRepository;

//    @Test
//    @Disabled
//    @Transactional
//    @Rollback(value = false)
//    void saveGraph1() {
//        // 애기능 1층 노드
//        nodeRepository.save(new Node(1L, 230.0, 790.0, 1L));
//        nodeRepository.save(new Node(2L, 198.0, 216.0, 1L));
//        nodeRepository.save(new Node(3L, 222.0, 498.0, 1L));
//        nodeRepository.save(new Node(4L, 760.0, 392.0, 1L));
//        nodeRepository.save(new Node(5L, 556.0, 708.0, 1L));
//        nodeRepository.save(new Node(6L, 788.0, 242.0, 1L));
//    }
//
//    @Test
//    @Disabled
//    @Transactional
//    @Rollback(value = false)
//    void saveGraph2() {
//        // 애기능 2층 노드
//        nodeRepository.save(new Node(7L, 194.0, 748.0, 2L)); //7
//        nodeRepository.save(new Node(8L, 284.0, 694.0, 2L));
//        nodeRepository.save(new Node(9L, 164.0, 461.0, 2L));
//        nodeRepository.save(new Node(10L, 198.0, 336.0, 2L));
//        nodeRepository.save(new Node(11L, 257.0, 247.0, 2L));
//        nodeRepository.save(new Node(12L, 354.0, 190.0, 2L));
//        nodeRepository.save(new Node(13L, 477.0, 163.0, 2L));
//        nodeRepository.save(new Node(14L, 549.0, 167.0, 2L));
//        nodeRepository.save(new Node(15L, 720.0, 220.0, 2L));
//        nodeRepository.save(new Node(16L, 750.0, 324.0, 2L));
//        nodeRepository.save(new Node(17L, 750.0, 573.0, 2L));
//        nodeRepository.save(new Node(18L, 590.0, 735.0, 2L));
//        nodeRepository.save(new Node(19L, 463.0, 756.0, 2L));
//        nodeRepository.save(new Node(20L, 378.0, 742.0, 2L));
//        nodeRepository.save(new Node(21L, 780.0, 162.0, 2L));
//    }

    @Test
    @Disabled
    @Transactional
    @Rollback(value = false)
    void save_우당교양관_1층_노드() {
        Building udang = buildingRepository.findByName("우당교양관");

        // 1층
        // 출입구
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(1L).longitude(410.0).latitude(207.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(24L).longitude(51.0).latitude(128.0).build());

        // 화장실
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(10L).longitude(500.0).latitude(100.0).build()); // 여자
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(17L).longitude(314.0).latitude(100.0).build()); // 남자

        // 라운지
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(16L).longitude(304.0).latitude(175.0).build());

        // 엘리베이터
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(14L).longitude(360.0).latitude(60.0).build());

        // 계단
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(13L).longitude(420.0).latitude(36.0).build()); // 가운데
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(25L).longitude(51.0).latitude(79.0).build()); // 왼쪽
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(26L).longitude(770.0).latitude(79.0).build()); // 오른쪽

        // 강의실
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(12L).longitude(514.0).latitude(150.0).build()); // 101
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(6L).longitude(597.0).latitude(160.0).build()); // 102
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(3L).longitude(724.0).latitude(160.0).build()); // 103
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(4L).longitude(708.0).latitude(84.0).build()); // 104
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(7L).longitude(595.0).latitude(84.0).build()); // 105
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(19L).longitude(220.0).latitude(84.0).build()); // 108
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(22L).longitude(112.0).latitude(84.0).build()); // 109
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(23L).longitude(95.0).latitude(160.0).build()); // 110
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(20L).longitude(205.0).latitude(160.0).build()); // 111

        // 일반
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(2L).longitude(770.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(5L).longitude(660.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(8L).longitude(535.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(9L).longitude(500.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(11L).longitude(408.0).latitude(120.0).build()); // 중앙
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(15L).longitude(312.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(18L).longitude(260.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(1L).id(21L).longitude(157.0).latitude(120.0).build());

    }

    @Test
    @Disabled
    @Transactional
    @Rollback(value = false)
    void save_우당교양관_2층_노드() {
        Building udang = buildingRepository.findByName("우당교양관");

        // 2층
        // 화장실
        nodeRepository.save(Node.builder().building(udang).floor(2L).id(35L).longitude(500.0).latitude(100.0).build()); // 여자
        nodeRepository.save(Node.builder().building(udang).floor(2L).id(41L).longitude(314.0).latitude(100.0).build()); // 남자

        // 엘리베이터
        nodeRepository.save(Node.builder().building(udang).floor(2L).id(38L).longitude(360.0).latitude(60.0).build());

        // 계단
        nodeRepository.save(Node.builder().building(udang).floor(2L).id(37L).longitude(438.0).latitude(66.0).build()); // 가운데
        nodeRepository.save(Node.builder().building(udang).floor(2L).id(49L).longitude(51.0).latitude(79.0).build()); // 왼쪽
        nodeRepository.save(Node.builder().building(udang).floor(2L).id(27L).longitude(770.0).latitude(79.0).build()); // 오른쪽

        // 강의실
        nodeRepository.save(Node.builder().building(udang).floor(2L).id(34L).longitude(597.0).latitude(160.0).build()); // 201
        nodeRepository.save(Node.builder().building(udang).floor(2L).id(30L).longitude(724.0).latitude(160.0).build()); // 202
        nodeRepository.save(Node.builder().building(udang).floor(2L).id(28L).longitude(708.0).latitude(84.0).build()); // 203
        nodeRepository.save(Node.builder().building(udang).floor(2L).id(32L).longitude(595.0).latitude(84.0).build()); // 204
        nodeRepository.save(Node.builder().building(udang).floor(2L).id(43L).longitude(220.0).latitude(84.0).build()); // 207
        nodeRepository.save(Node.builder().building(udang).floor(2L).id(46L).longitude(112.0).latitude(84.0).build()); // 208
        nodeRepository.save(Node.builder().building(udang).floor(2L).id(48L).longitude(95.0).latitude(160.0).build()); // 209
        nodeRepository.save(Node.builder().building(udang).floor(2L).id(44L).longitude(230.0).latitude(160.0).build()); // 210

        // 일반
        nodeRepository.save(Node.builder().building(udang).floor(2L).id(29L).longitude(770.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(2L).id(31L).longitude(660.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(2L).id(33L).longitude(535.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(2L).id(36L).longitude(500.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(2L).id(39L).longitude(408.0).latitude(120.0).build()); // 중앙
        nodeRepository.save(Node.builder().building(udang).floor(2L).id(40L).longitude(312.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(2L).id(42L).longitude(260.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(2L).id(40L).longitude(157.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(2L).id(47L).longitude(51.0).latitude(120.0).build());
    }

    @Test
    @Disabled
    @Transactional
    @Rollback(value = false)
    void save_우당교양관_3층_노드() {
        Building udang = buildingRepository.findByName("우당교양관");

        // 3층
        // 화장실
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(58L).longitude(500.0).latitude(100.0).build()); // 여자
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(68L).longitude(314.0).latitude(100.0).build()); // 남자

        // 엘리베이터
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(66L).longitude(360.0).latitude(60.0).build());

        // 계단
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(65L).longitude(438.0).latitude(66.0).build()); // 가운데
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(76L).longitude(51.0).latitude(79.0).build()); // 왼쪽
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(50L).longitude(770.0).latitude(79.0).build()); // 오른쪽

        // 강의실
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(62L).longitude(440.0).latitude(160.0).build()); // 301
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(60L).longitude(502.0).latitude(160.0).build()); // 302
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(56L).longitude(597.0).latitude(160.0).build()); // 303
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(52L).longitude(724.0).latitude(160.0).build()); // 304
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(53L).longitude(708.0).latitude(84.0).build()); // 305
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(55L).longitude(595.0).latitude(84.0).build()); // 306
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(71L).longitude(220.0).latitude(84.0).build()); // 309
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(74L).longitude(112.0).latitude(84.0).build()); // 310
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(75L).longitude(95.0).latitude(160.0).build()); // 311
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(73L).longitude(188.0).latitude(160.0).build()); // 312
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(72L).longitude(252.0).latitude(160.0).build()); // 313
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(69L).longitude(316.0).latitude(160.0).build()); // 314
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(63L).longitude(376.0).latitude(160.0).build()); // 315

        // 일반
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(51L).longitude(770.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(54L).longitude(660.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(57L).longitude(535.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(59L).longitude(500.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(61L).longitude(469.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(64L).longitude(408.0).latitude(120.0).build()); // 중앙
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(67L).longitude(312.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(70L).longitude(206.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(105L).longitude(157.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(3L).id(106L).longitude(51.0).latitude(120.0).build());
    }

    @Test
    @Disabled
    @Transactional
    @Rollback(value = false)
    void save_우당교양관_4층_노드() {
        Building udang = buildingRepository.findByName("우당교양관");

        // 4층
        // 화장실
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(85L).longitude(500.0).latitude(100.0).build()); // 여자
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(96L).longitude(314.0).latitude(100.0).build()); // 남자

        // 엘리베이터
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(93L).longitude(360.0).latitude(60.0).build());

        // 계단
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(92L).longitude(438.0).latitude(66.0).build()); // 가운데
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(104L).longitude(51.0).latitude(79.0).build()); // 왼쪽
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(77L).longitude(770.0).latitude(79.0).build()); // 오른쪽

        // 강의실
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(89L).longitude(440.0).latitude(160.0).build()); // 401
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(87L).longitude(502.0).latitude(160.0).build()); // 402
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(82L).longitude(597.0).latitude(160.0).build()); // 403
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(79L).longitude(724.0).latitude(160.0).build()); // 404
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(80L).longitude(708.0).latitude(84.0).build()); // 405
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(83L).longitude(595.0).latitude(84.0).build()); // 406
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(98L).longitude(220.0).latitude(84.0).build()); // 409
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(101L).longitude(112.0).latitude(84.0).build()); // 410
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(102L).longitude(95.0).latitude(160.0).build()); // 411
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(99L).longitude(230.0).latitude(160.0).build()); // 412
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(95L).longitude(316.0).latitude(160.0).build()); // 413
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(90L).longitude(376.0).latitude(160.0).build()); // 414

        // 일반
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(78L).longitude(770.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(81L).longitude(660.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(84L).longitude(535.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(86L).longitude(500.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(88L).longitude(469.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(91L).longitude(408.0).latitude(120.0).build()); // 중앙
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(94L).longitude(312.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(97L).longitude(206.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(100L).longitude(157.0).latitude(120.0).build());
        nodeRepository.save(Node.builder().building(udang).floor(4L).id(103L).longitude(51.0).latitude(120.0).build());
    }
}