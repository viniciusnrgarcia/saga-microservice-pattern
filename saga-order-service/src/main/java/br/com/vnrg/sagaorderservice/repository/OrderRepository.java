package br.com.vnrg.sagaorderservice.repository;

import br.com.vnrg.sagaorderservice.entity.OrderEntity;
import br.com.vnrg.sagaorderservice.openapi.model.Order;

public interface OrderRepository {
    OrderEntity save(Order order);
}
