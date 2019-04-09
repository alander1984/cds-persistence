package tech.lmru.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.lmru.entity.route.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {

}
