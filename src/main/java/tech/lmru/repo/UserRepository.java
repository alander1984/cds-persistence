package tech.lmru.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.lmru.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByCode(String code);
}