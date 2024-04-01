package example.com.routeexample.alias.repository;

import static org.junit.jupiter.api.Assertions.*;

import example.com.routeexample.JpaConfig;
import example.com.routeexample.alias.entity.Alias;
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
class AliasRepositoryTest {
    @Autowired
    AliasRepository aliasRepository;

    @Autowired
    BuildingRepository buildingRepository;

    @Test
    @Disabled
    @Transactional
    @Rollback(value = false)
    void save애기능() {
        Building aegineung = buildingRepository.findByName("애기능생활관");
        aliasRepository.save(new Alias(aegineung, "애기능"));
        aliasRepository.save(new Alias(aegineung, "애기능 생활관"));
        aliasRepository.save(new Alias(aegineung, "애기능생활관"));
    }
}