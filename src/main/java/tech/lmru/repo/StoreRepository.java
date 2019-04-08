package tech.lmru.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.lmru.entity.store.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
    
}