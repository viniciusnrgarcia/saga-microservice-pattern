package br.com.vnrg.sagaorderservice.service;

import br.com.vnrg.sagaorderservice.mapper.OrderMapper;
import br.com.vnrg.sagaorderservice.openapi.model.Order;
import br.com.vnrg.sagaorderservice.producer.OrderEventProducer;
import br.com.vnrg.sagaorderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    private final OrderRepository repository;

    private final OrderEventProducer eventProducer;

    public OrderService(OrderRepository repository, OrderEventProducer eventProducer) {
        this.repository = repository;
        this.eventProducer = eventProducer;
    }

    public void createOrder(Order order) {
        var entity = OrderMapper.INSTANCE.toOrderEntity(order);
        entity.setUserCreated("saga-order-service");
        entity.setUserUpdated("saga-order-service");
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());

        this.repository.save(entity);

        // this.orderPublisher.publish(new OrderCreatedEvent(order));
        // this.eventProducer.send(order);
    }
}
