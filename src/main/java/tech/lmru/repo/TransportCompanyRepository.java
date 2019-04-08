package tech.lmru.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.lmru.entity.transport.TransportCompany;

public interface TransportCompanyRepository extends JpaRepository<TransportCompany, Long> {

}
