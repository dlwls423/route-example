package example.com.routeexample.route.entity;

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
@Table(name = "tb_edge")
public class Edge {
    @Id
    @GeneratedValue
    private Long id;

    private Long startNodeId;

    private Long endNodeId;

    private Long distance;

    private Long minutes;
}
