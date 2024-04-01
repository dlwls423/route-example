package example.com.routeexample.building.repository;

import static org.junit.jupiter.api.Assertions.*;

import example.com.routeexample.JpaConfig;
import example.com.routeexample.building.entity.Building;
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
class BuildingRepositoryTest {
    @Autowired
    BuildingRepository buildingRepository;

    @Test
    @Disabled
    @Transactional
    @Rollback(value = false)
    void save애기능() {
        buildingRepository.save(new Building("애기능생활관", "고려대학교 서울캠퍼스 애기능생활관", "서울 성북구 안암로 73-15", "운영시간", false));
    }
}