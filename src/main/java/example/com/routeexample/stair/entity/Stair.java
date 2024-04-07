package example.com.routeexample.stair.entity;

import example.com.routeexample.route.entity.Node;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_stair")
public class Stair {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "node_id")
    private Node node;

}
