package tech.lmru.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import tech.lmru.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    
}