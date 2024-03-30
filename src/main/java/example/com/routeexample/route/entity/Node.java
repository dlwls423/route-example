package example.com.routeexample.route.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_node")
public class Node {
    @Id
    @GeneratedValue
    private Long id;

    private Double latitude;

    private Double longitude;

    private Long floor;

    private Type type;

}
