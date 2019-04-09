package tech.lmru.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.lmru.entity.order.DeliveryItem;

public interface DeliveryItemRepository extends JpaRepository<DeliveryItem, Long> {
    
}