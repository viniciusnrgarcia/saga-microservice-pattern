package br.com.vnrg.sagaorderservice.repository;

import br.com.vnrg.sagaorderservice.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
}
