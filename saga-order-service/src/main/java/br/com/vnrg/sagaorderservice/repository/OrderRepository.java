package br.com.vnrg.sagaorderservice.repository;

import br.com.vnrg.sagaorderservice.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
