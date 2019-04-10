package tech.lmru.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.lmru.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByCode(String code);
}