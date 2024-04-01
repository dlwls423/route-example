package example.com.routeexample.alias.repository;

import example.com.routeexample.alias.entity.Alias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AliasRepository extends JpaRepository<Alias, Long> {
    Alias findByAlias(String alias);
}
