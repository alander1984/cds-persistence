package tech.lmru.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tech.lmru.entity.order.Delivery;


public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    
    @Query("SELECT d FROM Delivery d WHERE d.status = 'NEW'")
    List<Delivery> newDeliveries();

}