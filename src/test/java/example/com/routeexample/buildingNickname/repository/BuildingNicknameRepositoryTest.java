package example.com.routeexample.buildingNickname.repository;

import example.com.routeexample.JpaConfig;
import example.com.routeexample.buildingNickname.entity.BuildingNickname;
import example.com.routeexample.building.entity.Building;
import example.com.routeexample.building.repository.BuildingRepository;
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
class BuildingNicknameRepositoryTest {
    @Autowired
    BuildingNicknameRepository buildingNicknameRepository;

    @Autowired
    BuildingRepository buildingRepository;

    @Test
    @Disabled
    @Transactional
    @Rollback(value = false)
    void save애기능() {
        Building aegineung = buildingRepository.findByName("애기능생활관");
        buildingNicknameRepository.save(new BuildingNickname(aegineung, "애기능"));
        buildingNicknameRepository.save(new BuildingNickname(aegineung, "애기능 생활관"));
        buildingNicknameRepository.save(new BuildingNickname(aegineung, "애기능생활관"));
    }

    @Test
    @Disabled
    @Transactional
    @Rollback(value = false)
    void save_우당교양관_별명() {
        Building udang = buildingRepository.findByName("우당교양관");
        buildingNicknameRepository.save(new BuildingNickname(udang, "우당교양관"));
        buildingNicknameRepository.save(new BuildingNickname(udang, "우당 교양관"));
    }
}