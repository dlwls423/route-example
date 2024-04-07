package example.com.routeexample.classroom.repository;

import example.com.routeexample.classroom.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    Classroom findByName(String name);
}
