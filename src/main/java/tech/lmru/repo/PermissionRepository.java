package tech.lmru.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.lmru.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
    
}