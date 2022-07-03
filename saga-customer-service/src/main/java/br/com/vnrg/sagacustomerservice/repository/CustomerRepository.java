package br.com.vnrg.sagacustomerservice.repository;

import br.com.vnrg.sagacustomerservice.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
