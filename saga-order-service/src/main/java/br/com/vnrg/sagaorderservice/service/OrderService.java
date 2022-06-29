package br.com.vnrg.sagaorderservice.service;

import br.com.vnrg.sagaorderservice.handler.event.OrderCreatedEvent;
import br.com.vnrg.sagaorderservice.handler.publisher.OrderCreatedEventPublisher;
import br.com.vnrg.sagaorderservice.openapi.model.Order;
import br.com.vnrg.sagaorderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repository;

    private final OrderCreatedEventPublisher orderPublisher;

    public OrderService(OrderRepository repository, OrderCreatedEventPublisher orderPublisher) {
        this.repository = repository;
        this.orderPublisher = orderPublisher;
    }

    public void createOrder(Order order) {
        this.repository.save(order);
        this.orderPublisher.publish(new OrderCreatedEvent(order));
    }
}
