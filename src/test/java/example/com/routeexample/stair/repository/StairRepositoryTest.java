package example.com.routeexample.stair.repository;

import static org.junit.jupiter.api.Assertions.*;

import example.com.routeexample.JpaConfig;
import example.com.routeexample.building.entity.Building;
import example.com.routeexample.building.repository.BuildingRepository;
import example.com.routeexample.elevator.entity.Elevator;
import example.com.routeexample.stair.entity.Stair;
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
class StairRepositoryTest {
    @Autowired
    StairRepository stairRepository;

    @Autowired
    BuildingRepository buildingRepository;

    @Test
    @Disabled
    @Transactional
    @Rollback(value = false)
    void save_우당교양관_계단() {
        Building udang = buildingRepository.findByName("우당교양관");
        stairRepository.save(new Stair(udang));
        stairRepository.save(new Stair(udang));
        stairRepository.save(new Stair(udang));
    }
}