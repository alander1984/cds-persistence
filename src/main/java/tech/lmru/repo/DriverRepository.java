package tech.lmru.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.lmru.entity.transport.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

}
