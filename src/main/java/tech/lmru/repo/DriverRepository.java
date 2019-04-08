package tech.lmru.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.lmru.entity.transport.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {


}
