package tech.lmru.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.lmru.entity.deliveryzone.DeliveryZoneCoordinate;

public interface DeliveryZoneCoordinateRepository extends JpaRepository<DeliveryZoneCoordinate, Long> {

}