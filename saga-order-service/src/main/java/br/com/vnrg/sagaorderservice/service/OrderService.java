package br.com.vnrg.sagaorderservice.service;

import br.com.vnrg.sagaorderservice.repository.mapper.OrderMapper;
import br.com.vnrg.sagaorderservice.openapi.model.Order;
import br.com.vnrg.sagaorderservice.messaging.producer.OrderEventProducer;
import br.com.vnrg.sagaorderservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class OrderService {

    private final OrderRepository repository;

    private final OrderEventProducer eventProducer;

    public OrderService(OrderRepository repository, OrderEventProducer eventProducer) {
        this.repository = repository;
        this.eventProducer = eventProducer;
    }

    public void createOrder(Order order) {
        this.saveOrder(order);
        this.sendEvent(order);
        log.info("created-order completed");
    }

    private void sendEvent(Order order) {
        this.eventProducer.send(order);
    }

    private void saveOrder(Order order) {
        var entity = OrderMapper.INSTANCE.toOrderEntity(order);
        entity.setUserCreated("saga-order-service");
        entity.setUserUpdated("saga-order-service");
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        this.repository.save(entity);
    }
}
