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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Node start;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Node end;

    private Long distance;

    public Edge(Node start, Node end, Long distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }
}
