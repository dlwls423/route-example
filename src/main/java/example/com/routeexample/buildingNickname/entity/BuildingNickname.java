package example.com.routeexample.buildingNickname.entity;

import example.com.routeexample.building.entity.Building;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_building_nickname")
public class BuildingNickname {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    private String nickname;

    public BuildingNickname(Building building, String nickname) {
        this.building = building;
        this.nickname = nickname;
    }
}
