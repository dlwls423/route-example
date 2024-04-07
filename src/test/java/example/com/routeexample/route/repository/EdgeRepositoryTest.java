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

//    @Test
//    @Disabled
//    @Transactional
//    @Rollback(value = false)
//    void save_애기능_간선() {
//        // 애기능 간선
//        edgeRepository.save(new Edge(nodeRepository.findById(1L).orElseThrow(), nodeRepository.findById(2L).orElseThrow(), 14L));
//        edgeRepository.save(new Edge(nodeRepository.findById(1L).orElseThrow(), nodeRepository.findById(5L).orElseThrow(), 9L));
//        edgeRepository.save(new Edge(nodeRepository.findById(1L).orElseThrow(), nodeRepository.findById(7L).orElseThrow(), 30L));
//        edgeRepository.save(new Edge(nodeRepository.findById(2L).orElseThrow(), nodeRepository.findById(1L).orElseThrow(), 14L));
//        edgeRepository.save(new Edge(nodeRepository.findById(2L).orElseThrow(), nodeRepository.findById(3L).orElseThrow(), 22L));
//        edgeRepository.save(new Edge(nodeRepository.findById(2L).orElseThrow(), nodeRepository.findById(5L).orElseThrow(), 9L));
//        edgeRepository.save(new Edge(nodeRepository.findById(3L).orElseThrow(), nodeRepository.findById(2L).orElseThrow(), 22L));
//        edgeRepository.save(new Edge(nodeRepository.findById(3L).orElseThrow(), nodeRepository.findById(4L).orElseThrow(), 13L));
//        edgeRepository.save(new Edge(nodeRepository.findById(3L).orElseThrow(), nodeRepository.findById(6L).orElseThrow(), 11L));
//        edgeRepository.save(new Edge(nodeRepository.findById(4L).orElseThrow(), nodeRepository.findById(3L).orElseThrow(), 13L));
//        edgeRepository.save(new Edge(nodeRepository.findById(4L).orElseThrow(), nodeRepository.findById(5L).orElseThrow(), 24L));
//        edgeRepository.save(new Edge(nodeRepository.findById(4L).orElseThrow(), nodeRepository.findById(6L).orElseThrow(), 6L));
//        edgeRepository.save(new Edge(nodeRepository.findById(5L).orElseThrow(), nodeRepository.findById(1L).orElseThrow(), 9L));
//        edgeRepository.save(new Edge(nodeRepository.findById(5L).orElseThrow(), nodeRepository.findById(2L).orElseThrow(), 19L));
//        edgeRepository.save(new Edge(nodeRepository.findById(5L).orElseThrow(), nodeRepository.findById(4L).orElseThrow(), 24L));
//        edgeRepository.save(new Edge(nodeRepository.findById(6L).orElseThrow(), nodeRepository.findById(3L).orElseThrow(), 11L));
//        edgeRepository.save(new Edge(nodeRepository.findById(6L).orElseThrow(), nodeRepository.findById(4L).orElseThrow(), 6L));
//        edgeRepository.save(new Edge(nodeRepository.findById(6L).orElseThrow(), nodeRepository.findById(21L).orElseThrow(), 30L));
//        edgeRepository.save(new Edge(nodeRepository.findById(7L).orElseThrow(), nodeRepository.findById(8L).orElseThrow(), 4L));
//        edgeRepository.save(new Edge(nodeRepository.findById(8L).orElseThrow(), nodeRepository.findById(9L).orElseThrow(), 12L));
//        edgeRepository.save(new Edge(nodeRepository.findById(8L).orElseThrow(), nodeRepository.findById(20L).orElseThrow(), 4L));
//        edgeRepository.save(new Edge(nodeRepository.findById(9L).orElseThrow(), nodeRepository.findById(8L).orElseThrow(), 12L));
//        edgeRepository.save(new Edge(nodeRepository.findById(9L).orElseThrow(), nodeRepository.findById(10L).orElseThrow(), 6L));
//        edgeRepository.save(new Edge(nodeRepository.findById(10L).orElseThrow(), nodeRepository.findById(9L).orElseThrow(), 6L));
//        edgeRepository.save(new Edge(nodeRepository.findById(10L).orElseThrow(), nodeRepository.findById(11L).orElseThrow(), 5L));
//        edgeRepository.save(new Edge(nodeRepository.findById(11L).orElseThrow(), nodeRepository.findById(10L).orElseThrow(), 5L));
//        edgeRepository.save(new Edge(nodeRepository.findById(11L).orElseThrow(), nodeRepository.findById(12L).orElseThrow(), 5L));
//        edgeRepository.save(new Edge(nodeRepository.findById(12L).orElseThrow(), nodeRepository.findById(11L).orElseThrow(), 5L));
//        edgeRepository.save(new Edge(nodeRepository.findById(12L).orElseThrow(), nodeRepository.findById(13L).orElseThrow(), 5L));
//        edgeRepository.save(new Edge(nodeRepository.findById(13L).orElseThrow(), nodeRepository.findById(12L).orElseThrow(), 5L));
//        edgeRepository.save(new Edge(nodeRepository.findById(13L).orElseThrow(), nodeRepository.findById(14L).orElseThrow(), 3L));
//        edgeRepository.save(new Edge(nodeRepository.findById(14L).orElseThrow(), nodeRepository.findById(13L).orElseThrow(), 3L));
//        edgeRepository.save(new Edge(nodeRepository.findById(14L).orElseThrow(), nodeRepository.findById(15L).orElseThrow(), 7L));
//        edgeRepository.save(new Edge(nodeRepository.findById(15L).orElseThrow(), nodeRepository.findById(14L).orElseThrow(), 7L));
//        edgeRepository.save(new Edge(nodeRepository.findById(15L).orElseThrow(), nodeRepository.findById(16L).orElseThrow(), 5L));
//        edgeRepository.save(new Edge(nodeRepository.findById(15L).orElseThrow(), nodeRepository.findById(21L).orElseThrow(), 2L));
//        edgeRepository.save(new Edge(nodeRepository.findById(16L).orElseThrow(), nodeRepository.findById(15L).orElseThrow(), 5L));
//        edgeRepository.save(new Edge(nodeRepository.findById(16L).orElseThrow(), nodeRepository.findById(17L).orElseThrow(), 12L));
//        edgeRepository.save(new Edge(nodeRepository.findById(17L).orElseThrow(), nodeRepository.findById(16L).orElseThrow(), 12L));
//        edgeRepository.save(new Edge(nodeRepository.findById(17L).orElseThrow(), nodeRepository.findById(18L).orElseThrow(), 10L));
//        edgeRepository.save(new Edge(nodeRepository.findById(18L).orElseThrow(), nodeRepository.findById(17L).orElseThrow(), 10L));
//        edgeRepository.save(new Edge(nodeRepository.findById(18L).orElseThrow(), nodeRepository.findById(19L).orElseThrow(), 5L));
//        edgeRepository.save(new Edge(nodeRepository.findById(19L).orElseThrow(), nodeRepository.findById(18L).orElseThrow(), 5L));
//        edgeRepository.save(new Edge(nodeRepository.findById(19L).orElseThrow(), nodeRepository.findById(20L).orElseThrow(), 4L));
//        edgeRepository.save(new Edge(nodeRepository.findById(20L).orElseThrow(), nodeRepository.findById(8L).orElseThrow(), 4L));
//        edgeRepository.save(new Edge(nodeRepository.findById(20L).orElseThrow(), nodeRepository.findById(19L).orElseThrow(), 4L));
//        edgeRepository.save(new Edge(nodeRepository.findById(21L).orElseThrow(), nodeRepository.findById(15L).orElseThrow(), 5L));
//        edgeRepository.save(new Edge(nodeRepository.findById(21L).orElseThrow(), nodeRepository.findById(6L).orElseThrow(), 30L));
//
//    }

    @Test
    @Disabled
    @Transactional
    @Rollback(value = false)
    void save_우당교양관_1층_간선() {
        // 2번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(26L).orElseThrow(),
            nodeRepository.findById(2L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(2L).orElseThrow(),
            nodeRepository.findById(26L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(2L).orElseThrow(),
            nodeRepository.findById(4L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(4L).orElseThrow(),
            nodeRepository.findById(2L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(2L).orElseThrow(),
            nodeRepository.findById(3L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(3L).orElseThrow(),
            nodeRepository.findById(2L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(2L).orElseThrow(),
            nodeRepository.findById(5L).orElseThrow(), 12L));
        edgeRepository.save(new Edge(nodeRepository.findById(5L).orElseThrow(),
            nodeRepository.findById(2L).orElseThrow(), 12L));

        // 5번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(4L).orElseThrow(),
            nodeRepository.findById(5L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(5L).orElseThrow(),
            nodeRepository.findById(4L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(3L).orElseThrow(),
            nodeRepository.findById(5L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(5L).orElseThrow(),
            nodeRepository.findById(3L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(5L).orElseThrow(),
            nodeRepository.findById(7L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(7L).orElseThrow(),
            nodeRepository.findById(5L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(5L).orElseThrow(),
            nodeRepository.findById(8L).orElseThrow(), 12L));
        edgeRepository.save(new Edge(nodeRepository.findById(8L).orElseThrow(),
            nodeRepository.findById(5L).orElseThrow(), 12L));
        edgeRepository.save(new Edge(nodeRepository.findById(5L).orElseThrow(),
            nodeRepository.findById(6L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(6L).orElseThrow(),
            nodeRepository.findById(5L).orElseThrow(), 1L));

        // 8번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(8L).orElseThrow(),
            nodeRepository.findById(7L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(7L).orElseThrow(),
            nodeRepository.findById(8L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(8L).orElseThrow(),
            nodeRepository.findById(6L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(6L).orElseThrow(),
            nodeRepository.findById(8L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(8L).orElseThrow(),
            nodeRepository.findById(9L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(9L).orElseThrow(),
            nodeRepository.findById(8L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(8L).orElseThrow(),
            nodeRepository.findById(12L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(12L).orElseThrow(),
            nodeRepository.findById(8L).orElseThrow(), 1L));

        // 9번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(9L).orElseThrow(),
            nodeRepository.findById(10L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(10L).orElseThrow(),
            nodeRepository.findById(9L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(9L).orElseThrow(),
            nodeRepository.findById(11L).orElseThrow(), 9L));
        edgeRepository.save(new Edge(nodeRepository.findById(11L).orElseThrow(),
            nodeRepository.findById(9L).orElseThrow(), 9L));

        // 11번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(1L).orElseThrow(),
            nodeRepository.findById(11L).orElseThrow(), 4L));
        edgeRepository.save(new Edge(nodeRepository.findById(11L).orElseThrow(),
            nodeRepository.findById(1L).orElseThrow(), 4L));
        edgeRepository.save(new Edge(nodeRepository.findById(11L).orElseThrow(),
            nodeRepository.findById(13L).orElseThrow(), 13L));
        edgeRepository.save(new Edge(nodeRepository.findById(13L).orElseThrow(),
            nodeRepository.findById(11L).orElseThrow(), 13L));
        edgeRepository.save(new Edge(nodeRepository.findById(11L).orElseThrow(),
            nodeRepository.findById(14L).orElseThrow(), 20L));
        edgeRepository.save(new Edge(nodeRepository.findById(14L).orElseThrow(),
            nodeRepository.findById(11L).orElseThrow(), 20L));
        edgeRepository.save(new Edge(nodeRepository.findById(11L).orElseThrow(),
            nodeRepository.findById(15L).orElseThrow(), 9L));
        edgeRepository.save(new Edge(nodeRepository.findById(15L).orElseThrow(),
            nodeRepository.findById(11L).orElseThrow(), 9L));
        edgeRepository.save(new Edge(nodeRepository.findById(11L).orElseThrow(),
            nodeRepository.findById(16L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(16L).orElseThrow(),
            nodeRepository.findById(11L).orElseThrow(), 1L));

        // 1번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(1L).orElseThrow(),
            nodeRepository.findById(16L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(16L).orElseThrow(),
            nodeRepository.findById(1L).orElseThrow(), 1L));

        // 15번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(15L).orElseThrow(),
            nodeRepository.findById(16L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(16L).orElseThrow(),
            nodeRepository.findById(15L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(15L).orElseThrow(),
            nodeRepository.findById(17L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(17L).orElseThrow(),
            nodeRepository.findById(15L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(15L).orElseThrow(),
            nodeRepository.findById(18L).orElseThrow(), 5L));
        edgeRepository.save(new Edge(nodeRepository.findById(18L).orElseThrow(),
            nodeRepository.findById(15L).orElseThrow(), 5L));

        // 18번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(18L).orElseThrow(),
            nodeRepository.findById(19L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(19L).orElseThrow(),
            nodeRepository.findById(18L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(18L).orElseThrow(),
            nodeRepository.findById(20L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(20L).orElseThrow(),
            nodeRepository.findById(18L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(18L).orElseThrow(),
            nodeRepository.findById(21L).orElseThrow(), 10L));
        edgeRepository.save(new Edge(nodeRepository.findById(21L).orElseThrow(),
            nodeRepository.findById(18L).orElseThrow(), 10L));
        edgeRepository.save(new Edge(nodeRepository.findById(18L).orElseThrow(),
            nodeRepository.findById(16L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(16L).orElseThrow(),
            nodeRepository.findById(18L).orElseThrow(), 1L));

        // 21번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(21L).orElseThrow(),
            nodeRepository.findById(19L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(19L).orElseThrow(),
            nodeRepository.findById(21L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(21L).orElseThrow(),
            nodeRepository.findById(20L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(20L).orElseThrow(),
            nodeRepository.findById(21L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(21L).orElseThrow(),
            nodeRepository.findById(22L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(22L).orElseThrow(),
            nodeRepository.findById(21L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(21L).orElseThrow(),
            nodeRepository.findById(23L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(23L).orElseThrow(),
            nodeRepository.findById(21L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(21L).orElseThrow(),
            nodeRepository.findById(24L).orElseThrow(), 12L));
        edgeRepository.save(new Edge(nodeRepository.findById(24L).orElseThrow(),
            nodeRepository.findById(21L).orElseThrow(), 12L));

        // 24번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(24L).orElseThrow(),
            nodeRepository.findById(22L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(22L).orElseThrow(),
            nodeRepository.findById(24L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(24L).orElseThrow(),
            nodeRepository.findById(23L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(23L).orElseThrow(),
            nodeRepository.findById(24L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(24L).orElseThrow(),
            nodeRepository.findById(25L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(25L).orElseThrow(),
            nodeRepository.findById(24L).orElseThrow(), 3L));
    }

    @Test
    @Disabled
    @Transactional
    @Rollback(value = false)
    void save_우당교양관_2층_간선() {
        // 24번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(27L).orElseThrow(),
            nodeRepository.findById(24L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(24L).orElseThrow(),
            nodeRepository.findById(27L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(24L).orElseThrow(),
            nodeRepository.findById(28L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(28L).orElseThrow(),
            nodeRepository.findById(24L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(24L).orElseThrow(),
            nodeRepository.findById(30L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(30L).orElseThrow(),
            nodeRepository.findById(24L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(24L).orElseThrow(),
            nodeRepository.findById(31L).orElseThrow(), 12L));
        edgeRepository.save(new Edge(nodeRepository.findById(31L).orElseThrow(),
            nodeRepository.findById(24L).orElseThrow(), 12L));

        // 31번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(31L).orElseThrow(),
            nodeRepository.findById(28L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(28L).orElseThrow(),
            nodeRepository.findById(31L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(31L).orElseThrow(),
            nodeRepository.findById(30L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(30L).orElseThrow(),
            nodeRepository.findById(31L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(31L).orElseThrow(),
            nodeRepository.findById(32L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(32L).orElseThrow(),
            nodeRepository.findById(31L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(31L).orElseThrow(),
            nodeRepository.findById(33L).orElseThrow(), 12L));
        edgeRepository.save(new Edge(nodeRepository.findById(33L).orElseThrow(),
            nodeRepository.findById(31L).orElseThrow(), 12L));
        edgeRepository.save(new Edge(nodeRepository.findById(31L).orElseThrow(),
            nodeRepository.findById(34L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(34L).orElseThrow(),
            nodeRepository.findById(31L).orElseThrow(), 1L));

        // 33번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(33L).orElseThrow(),
            nodeRepository.findById(32L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(32L).orElseThrow(),
            nodeRepository.findById(33L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(33L).orElseThrow(),
            nodeRepository.findById(34L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(34L).orElseThrow(),
            nodeRepository.findById(33L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(33L).orElseThrow(),
            nodeRepository.findById(36L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(36L).orElseThrow(),
            nodeRepository.findById(33L).orElseThrow(), 3L));

        // 36번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(36L).orElseThrow(),
            nodeRepository.findById(35L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(35L).orElseThrow(),
            nodeRepository.findById(36L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(36L).orElseThrow(),
            nodeRepository.findById(39L).orElseThrow(), 9L));
        edgeRepository.save(new Edge(nodeRepository.findById(39L).orElseThrow(),
            nodeRepository.findById(36L).orElseThrow(), 9L));

        // 39번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(39L).orElseThrow(),
            nodeRepository.findById(37L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(37L).orElseThrow(),
            nodeRepository.findById(39L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(39L).orElseThrow(),
            nodeRepository.findById(38L).orElseThrow(), 20L));
        edgeRepository.save(new Edge(nodeRepository.findById(38L).orElseThrow(),
            nodeRepository.findById(39L).orElseThrow(), 20L));
        edgeRepository.save(new Edge(nodeRepository.findById(39L).orElseThrow(),
            nodeRepository.findById(40L).orElseThrow(), 9L));
        edgeRepository.save(new Edge(nodeRepository.findById(40L).orElseThrow(),
            nodeRepository.findById(39L).orElseThrow(), 9L));

        // 40번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(40L).orElseThrow(),
            nodeRepository.findById(41L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(41L).orElseThrow(),
            nodeRepository.findById(40L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(40L).orElseThrow(),
            nodeRepository.findById(42L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(42L).orElseThrow(),
            nodeRepository.findById(40L).orElseThrow(), 3L));

        // 42번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(42L).orElseThrow(),
            nodeRepository.findById(43L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(43L).orElseThrow(),
            nodeRepository.findById(42L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(42L).orElseThrow(),
            nodeRepository.findById(44L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(44L).orElseThrow(),
            nodeRepository.findById(42L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(44L).orElseThrow(),
            nodeRepository.findById(45L).orElseThrow(), 12L));
        edgeRepository.save(new Edge(nodeRepository.findById(45L).orElseThrow(),
            nodeRepository.findById(44L).orElseThrow(), 12L));

        // 45번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(45L).orElseThrow(),
            nodeRepository.findById(43L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(43L).orElseThrow(),
            nodeRepository.findById(45L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(45L).orElseThrow(),
            nodeRepository.findById(44L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(44L).orElseThrow(),
            nodeRepository.findById(45L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(45L).orElseThrow(),
            nodeRepository.findById(46L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(46L).orElseThrow(),
            nodeRepository.findById(45L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(45L).orElseThrow(),
            nodeRepository.findById(48L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(48L).orElseThrow(),
            nodeRepository.findById(45L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(45L).orElseThrow(),
            nodeRepository.findById(47L).orElseThrow(), 12L));
        edgeRepository.save(new Edge(nodeRepository.findById(47L).orElseThrow(),
            nodeRepository.findById(45L).orElseThrow(), 12L));


        // 47번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(47L).orElseThrow(),
            nodeRepository.findById(46L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(46L).orElseThrow(),
            nodeRepository.findById(47L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(47L).orElseThrow(),
            nodeRepository.findById(48L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(48L).orElseThrow(),
            nodeRepository.findById(47L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(47L).orElseThrow(),
            nodeRepository.findById(49L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(49L).orElseThrow(),
            nodeRepository.findById(47L).orElseThrow(), 3L));
    }

    @Test
    @Disabled
    @Transactional
    @Rollback(value = false)
    void save_우당교양관_3층_간선() {
        // 51번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(51L).orElseThrow(),
            nodeRepository.findById(50L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(50L).orElseThrow(),
            nodeRepository.findById(51L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(51L).orElseThrow(),
            nodeRepository.findById(52L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(52L).orElseThrow(),
            nodeRepository.findById(52L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(51L).orElseThrow(),
            nodeRepository.findById(53L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(53L).orElseThrow(),
            nodeRepository.findById(51L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(51L).orElseThrow(),
            nodeRepository.findById(54L).orElseThrow(), 12L));
        edgeRepository.save(new Edge(nodeRepository.findById(54L).orElseThrow(),
            nodeRepository.findById(51L).orElseThrow(), 12L));

        // 54번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(54L).orElseThrow(),
            nodeRepository.findById(53L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(53L).orElseThrow(),
            nodeRepository.findById(54L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(54L).orElseThrow(),
            nodeRepository.findById(52L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(52L).orElseThrow(),
            nodeRepository.findById(54L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(54L).orElseThrow(),
            nodeRepository.findById(55L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(55L).orElseThrow(),
            nodeRepository.findById(54L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(54L).orElseThrow(),
            nodeRepository.findById(57L).orElseThrow(), 12L));
        edgeRepository.save(new Edge(nodeRepository.findById(57L).orElseThrow(),
            nodeRepository.findById(54L).orElseThrow(), 12L));
        edgeRepository.save(new Edge(nodeRepository.findById(54L).orElseThrow(),
            nodeRepository.findById(56L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(56L).orElseThrow(),
            nodeRepository.findById(54L).orElseThrow(), 1L));

        // 57번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(57L).orElseThrow(),
            nodeRepository.findById(55L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(55L).orElseThrow(),
            nodeRepository.findById(57L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(57L).orElseThrow(),
            nodeRepository.findById(56L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(56L).orElseThrow(),
            nodeRepository.findById(57L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(57L).orElseThrow(),
            nodeRepository.findById(59L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(59L).orElseThrow(),
            nodeRepository.findById(57L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(57L).orElseThrow(),
            nodeRepository.findById(60L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(60L).orElseThrow(),
            nodeRepository.findById(57L).orElseThrow(), 1L));

        // 59번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(59L).orElseThrow(),
            nodeRepository.findById(58L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(58L).orElseThrow(),
            nodeRepository.findById(59L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(59L).orElseThrow(),
            nodeRepository.findById(61L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(61L).orElseThrow(),
            nodeRepository.findById(59L).orElseThrow(), 3L));

        // 61번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(61L).orElseThrow(),
            nodeRepository.findById(60L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(60L).orElseThrow(),
            nodeRepository.findById(61L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(61L).orElseThrow(),
            nodeRepository.findById(62L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(62L).orElseThrow(),
            nodeRepository.findById(61L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(61L).orElseThrow(),
            nodeRepository.findById(64L).orElseThrow(), 6L));
        edgeRepository.save(new Edge(nodeRepository.findById(64L).orElseThrow(),
            nodeRepository.findById(61L).orElseThrow(), 6L));

        // 64번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(64L).orElseThrow(),
            nodeRepository.findById(65L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(65L).orElseThrow(),
            nodeRepository.findById(64L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(64L).orElseThrow(),
            nodeRepository.findById(66L).orElseThrow(), 20L));
        edgeRepository.save(new Edge(nodeRepository.findById(66L).orElseThrow(),
            nodeRepository.findById(64L).orElseThrow(), 20L));
        edgeRepository.save(new Edge(nodeRepository.findById(64L).orElseThrow(),
            nodeRepository.findById(63L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(63L).orElseThrow(),
            nodeRepository.findById(64L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(64L).orElseThrow(),
            nodeRepository.findById(67L).orElseThrow(), 9L));
        edgeRepository.save(new Edge(nodeRepository.findById(67L).orElseThrow(),
            nodeRepository.findById(64L).orElseThrow(), 9L));

        // 67번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(67L).orElseThrow(),
            nodeRepository.findById(68L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(68L).orElseThrow(),
            nodeRepository.findById(67L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(67L).orElseThrow(),
            nodeRepository.findById(70L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(70L).orElseThrow(),
            nodeRepository.findById(67L).orElseThrow(), 3L));

        // 70번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(70L).orElseThrow(),
            nodeRepository.findById(69L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(69L).orElseThrow(),
            nodeRepository.findById(70L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(70L).orElseThrow(),
            nodeRepository.findById(72L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(72L).orElseThrow(),
            nodeRepository.findById(70L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(70L).orElseThrow(),
            nodeRepository.findById(71L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(71L).orElseThrow(),
            nodeRepository.findById(70L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(70L).orElseThrow(),
            nodeRepository.findById(105L).orElseThrow(), 12L));
        edgeRepository.save(new Edge(nodeRepository.findById(105L).orElseThrow(),
            nodeRepository.findById(70L).orElseThrow(), 12L));

        // 105번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(105L).orElseThrow(),
            nodeRepository.findById(71L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(71L).orElseThrow(),
            nodeRepository.findById(105L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(105L).orElseThrow(),
            nodeRepository.findById(73L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(73L).orElseThrow(),
            nodeRepository.findById(105L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(105L).orElseThrow(),
            nodeRepository.findById(74L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(74L).orElseThrow(),
            nodeRepository.findById(105L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(105L).orElseThrow(),
            nodeRepository.findById(75L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(75L).orElseThrow(),
            nodeRepository.findById(105L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(105L).orElseThrow(),
            nodeRepository.findById(106L).orElseThrow(), 12L));
        edgeRepository.save(new Edge(nodeRepository.findById(106L).orElseThrow(),
            nodeRepository.findById(105L).orElseThrow(), 12L));

        // 106번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(106L).orElseThrow(),
            nodeRepository.findById(74L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(74L).orElseThrow(),
            nodeRepository.findById(106L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(106L).orElseThrow(),
            nodeRepository.findById(75L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(75L).orElseThrow(),
            nodeRepository.findById(106L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(106L).orElseThrow(),
            nodeRepository.findById(76L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(76L).orElseThrow(),
            nodeRepository.findById(106L).orElseThrow(), 3L));
    }

    @Test
    @Disabled
    @Transactional
    @Rollback(value = false)
    void save_우당교양관_4층_간선() {
        // 78번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(78L).orElseThrow(),
            nodeRepository.findById(77L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(77L).orElseThrow(),
            nodeRepository.findById(78L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(78L).orElseThrow(),
            nodeRepository.findById(80L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(80L).orElseThrow(),
            nodeRepository.findById(78L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(78L).orElseThrow(),
            nodeRepository.findById(79L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(79L).orElseThrow(),
            nodeRepository.findById(78L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(78L).orElseThrow(),
            nodeRepository.findById(81L).orElseThrow(), 12L));
        edgeRepository.save(new Edge(nodeRepository.findById(81L).orElseThrow(),
            nodeRepository.findById(78L).orElseThrow(), 12L));

        // 81번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(81L).orElseThrow(),
            nodeRepository.findById(80L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(80L).orElseThrow(),
            nodeRepository.findById(81L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(81L).orElseThrow(),
            nodeRepository.findById(79L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(79L).orElseThrow(),
            nodeRepository.findById(81L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(81L).orElseThrow(),
            nodeRepository.findById(82L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(82L).orElseThrow(),
            nodeRepository.findById(81L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(81L).orElseThrow(),
            nodeRepository.findById(83L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(83L).orElseThrow(),
            nodeRepository.findById(81L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(81L).orElseThrow(),
            nodeRepository.findById(84L).orElseThrow(), 12L));
        edgeRepository.save(new Edge(nodeRepository.findById(84L).orElseThrow(),
            nodeRepository.findById(81L).orElseThrow(), 12L));

        // 84번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(84L).orElseThrow(),
            nodeRepository.findById(82L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(82L).orElseThrow(),
            nodeRepository.findById(84L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(84L).orElseThrow(),
            nodeRepository.findById(83L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(83L).orElseThrow(),
            nodeRepository.findById(84L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(84L).orElseThrow(),
            nodeRepository.findById(87L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(87L).orElseThrow(),
            nodeRepository.findById(84L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(84L).orElseThrow(),
            nodeRepository.findById(86L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(86L).orElseThrow(),
            nodeRepository.findById(84L).orElseThrow(), 3L));

        // 86번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(86L).orElseThrow(),
            nodeRepository.findById(88L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(88L).orElseThrow(),
            nodeRepository.findById(86L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(86L).orElseThrow(),
            nodeRepository.findById(85L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(85L).orElseThrow(),
            nodeRepository.findById(86L).orElseThrow(), 1L));

        // 88번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(88L).orElseThrow(),
            nodeRepository.findById(87L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(87L).orElseThrow(),
            nodeRepository.findById(88L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(88L).orElseThrow(),
            nodeRepository.findById(89L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(89L).orElseThrow(),
            nodeRepository.findById(88L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(88L).orElseThrow(),
            nodeRepository.findById(91L).orElseThrow(), 6L));
        edgeRepository.save(new Edge(nodeRepository.findById(91L).orElseThrow(),
            nodeRepository.findById(88L).orElseThrow(), 6L));

        // 91번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(91L).orElseThrow(),
            nodeRepository.findById(90L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(90L).orElseThrow(),
            nodeRepository.findById(91L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(91L).orElseThrow(),
            nodeRepository.findById(92L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(92L).orElseThrow(),
            nodeRepository.findById(91L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(91L).orElseThrow(),
            nodeRepository.findById(93L).orElseThrow(), 20L));
        edgeRepository.save(new Edge(nodeRepository.findById(93L).orElseThrow(),
            nodeRepository.findById(91L).orElseThrow(), 20L));
        edgeRepository.save(new Edge(nodeRepository.findById(91L).orElseThrow(),
            nodeRepository.findById(94L).orElseThrow(), 9L));
        edgeRepository.save(new Edge(nodeRepository.findById(94L).orElseThrow(),
            nodeRepository.findById(91L).orElseThrow(), 9L));

        // 94번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(94L).orElseThrow(),
            nodeRepository.findById(96L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(96L).orElseThrow(),
            nodeRepository.findById(94L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(94L).orElseThrow(),
            nodeRepository.findById(97L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(97L).orElseThrow(),
            nodeRepository.findById(94L).orElseThrow(), 3L));

        // 97번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(97L).orElseThrow(),
            nodeRepository.findById(95L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(95L).orElseThrow(),
            nodeRepository.findById(97L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(97L).orElseThrow(),
            nodeRepository.findById(98L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(98L).orElseThrow(),
            nodeRepository.findById(97L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(97L).orElseThrow(),
            nodeRepository.findById(99L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(99L).orElseThrow(),
            nodeRepository.findById(97L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(97L).orElseThrow(),
            nodeRepository.findById(100L).orElseThrow(), 12L));
        edgeRepository.save(new Edge(nodeRepository.findById(100L).orElseThrow(),
            nodeRepository.findById(97L).orElseThrow(), 12L));

        // 100번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(100L).orElseThrow(),
            nodeRepository.findById(98L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(98L).orElseThrow(),
            nodeRepository.findById(100L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(100L).orElseThrow(),
            nodeRepository.findById(99L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(99L).orElseThrow(),
            nodeRepository.findById(100L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(100L).orElseThrow(),
            nodeRepository.findById(101L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(101L).orElseThrow(),
            nodeRepository.findById(100L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(100L).orElseThrow(),
            nodeRepository.findById(102L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(102L).orElseThrow(),
            nodeRepository.findById(100L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(100L).orElseThrow(),
            nodeRepository.findById(103L).orElseThrow(), 12L));
        edgeRepository.save(new Edge(nodeRepository.findById(103L).orElseThrow(),
            nodeRepository.findById(100L).orElseThrow(), 12L));

        // 103번 노드
        edgeRepository.save(new Edge(nodeRepository.findById(103L).orElseThrow(),
            nodeRepository.findById(101L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(101L).orElseThrow(),
            nodeRepository.findById(103L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(101L).orElseThrow(),
            nodeRepository.findById(102L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(102L).orElseThrow(),
            nodeRepository.findById(103L).orElseThrow(), 1L));
        edgeRepository.save(new Edge(nodeRepository.findById(103L).orElseThrow(),
            nodeRepository.findById(104L).orElseThrow(), 3L));
        edgeRepository.save(new Edge(nodeRepository.findById(104L).orElseThrow(),
            nodeRepository.findById(103L).orElseThrow(), 3L));
    }
}