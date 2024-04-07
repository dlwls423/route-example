package example.com.routeexample.route.entity;

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
@Table(name = "tb_edge")
public class Edge {
    @Id
    @GeneratedValue
    private Long edgeId;

    @ManyToOne
    @JoinColumn(name = "startNodeId", nullable = false)
    private Node startNode;

    @ManyToOne
    @JoinColumn(name = "endNodeId", nullable = false)
    private Node endNode;

    private Long distance;

    public Edge(Node startNode, Node endNode, Long distance) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.distance = distance;
    }
}
