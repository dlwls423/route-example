package example.com.routeexample.buildingNickname.repository;

import example.com.routeexample.buildingNickname.entity.BuildingNickname;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingNicknameRepository extends JpaRepository<BuildingNickname, Long> {
    BuildingNickname findByAlias(String alias);
}
