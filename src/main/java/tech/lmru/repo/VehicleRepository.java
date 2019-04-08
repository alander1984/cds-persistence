package tech.lmru.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.lmru.entity.transport.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
