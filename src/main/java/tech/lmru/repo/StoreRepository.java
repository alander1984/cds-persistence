package tech.lmru.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import tech.lmru.entity.store.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
    
}