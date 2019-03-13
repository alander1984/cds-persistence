package tech.lmru.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.lmru.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    
}