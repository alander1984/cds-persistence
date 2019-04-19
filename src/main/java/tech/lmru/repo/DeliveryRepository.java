package tech.lmru.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import tech.lmru.entity.order.Delivery;
import tech.lmru.entity.order.DeliveryStatusEnum;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
  @Modifying
  @Transactional
  @Query("update Delivery d set d.status = :newStatus where d.id = :id")
  int updateDeliveryStatusById(@Param("id") Long id, @Param("newStatus") DeliveryStatusEnum newStatus);
}