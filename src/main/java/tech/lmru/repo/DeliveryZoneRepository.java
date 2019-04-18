package tech.lmru.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.lmru.entity.deliveryzone.DeliveryZone;

public interface DeliveryZoneRepository extends JpaRepository<DeliveryZone, Long> {

}