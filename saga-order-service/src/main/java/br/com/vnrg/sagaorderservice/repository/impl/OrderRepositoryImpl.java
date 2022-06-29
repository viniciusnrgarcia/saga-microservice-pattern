package br.com.vnrg.sagaorderservice.repository.impl;

import br.com.vnrg.sagaorderservice.entity.OrderEntity;
import br.com.vnrg.sagaorderservice.openapi.model.Order;
import br.com.vnrg.sagaorderservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public OrderEntity save(Order order) {
        log.info("save {} ", order.toString());
        return new OrderEntity();
    }
}
