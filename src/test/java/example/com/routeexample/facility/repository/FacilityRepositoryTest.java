package example.com.routeexample.facility.repository;

import static org.junit.jupiter.api.Assertions.*;

import example.com.routeexample.JpaConfig;
import example.com.routeexample.building.entity.Building;
import example.com.routeexample.building.repository.BuildingRepository;
import example.com.routeexample.facility.entity.Facility;
import example.com.routeexample.facility.entity.Type;
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
class FacilityRepositoryTest {
    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    NodeRepository nodeRepository;

    @Autowired
    FacilityRepository facilityRepository;

    @Test
//    @Disabled
    @Transactional
    @Rollback(value = false)
    void save_우당교양관_시설() {
        Building udang = buildingRepository.findByName("우당교양관");

        // 1층
        // 여자화장실
        facilityRepository.save(new Facility(Type.WOMEN_RESTROOM, 1L, true, null, udang,
            nodeRepository.findById(10L).orElseThrow()));

        // 남자화장실
        facilityRepository.save(new Facility(Type.MEN_RESTROOM, 1L, true, null, udang,
            nodeRepository.findById(17L).orElseThrow()));

        // 라운지
        facilityRepository.save(new Facility(Type.LOUNGE, 1L, true, null, udang,
            nodeRepository.findById(16L).orElseThrow()));

        // 2층
        // 여자화장실
        facilityRepository.save(new Facility(Type.WOMEN_RESTROOM, 2L, true, null, udang,
            nodeRepository.findById(35L).orElseThrow()));

        // 남자화장실
        facilityRepository.save(new Facility(Type.MEN_RESTROOM, 2L, true, null, udang,
            nodeRepository.findById(41L).orElseThrow()));

        // 3층
        // 여자화장실
        facilityRepository.save(new Facility(Type.WOMEN_RESTROOM, 3L, true, null, udang,
            nodeRepository.findById(58L).orElseThrow()));

        // 남자화장실
        facilityRepository.save(new Facility(Type.MEN_RESTROOM, 3L, true, null, udang,
            nodeRepository.findById(68L).orElseThrow()));

        // 4층
        // 여자화장실
        facilityRepository.save(new Facility(Type.WOMEN_RESTROOM, 4L, true, null, udang,
            nodeRepository.findById(85L).orElseThrow()));

        // 남자화장실
        facilityRepository.save(new Facility(Type.MEN_RESTROOM, 4L, true, null, udang,
            nodeRepository.findById(96L).orElseThrow()));
    }
}