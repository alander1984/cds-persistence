package tech.lmru.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import tech.lmru.entity.order.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    
}