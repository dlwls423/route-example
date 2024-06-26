package example.com.routeexample.building.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_building")
public class Building {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String detail;

    private String address;

    private String operatingTime;

    private Boolean needStudentCard;

    private Double longitude;

    private Double latitude;

    public Building(String name, String detail, String address, String operatingTime,
        Boolean needStudentCard, Double longitude, Double latitude) {
        this.name = name;
        this.detail = detail;
        this.address = address;
        this.operatingTime = operatingTime;
        this.needStudentCard = needStudentCard;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
