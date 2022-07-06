package br.com.vnrg.sagaorderservice.service;

import br.com.vnrg.sagaorderservice.domain.OrderDomain;
import br.com.vnrg.sagaorderservice.messaging.producer.OrderCreatedPublisher;
import br.com.vnrg.sagaorderservice.openapi.model.Order;
import br.com.vnrg.sagaorderservice.repository.OrderRepository;
import br.com.vnrg.sagaorderservice.repository.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class OrderService {

    private final OrderRepository repository;

    private final OrderCreatedPublisher eventProducer;

    public OrderService(OrderRepository repository, OrderCreatedPublisher eventProducer) {
        this.repository = repository;
        this.eventProducer = eventProducer;
    }

    public void createOrder(Order order) {
        var orderDomain = this.saveOrder(order);
        this.sendEvent(orderDomain);
        log.info("created-order completed");
    }

    private void sendEvent(OrderDomain order) {
        this.eventProducer.send(order);
    }

    private OrderDomain saveOrder(Order order) {
        var mapper = OrderMapper.INSTANCE;
        var entity = mapper.toOrderEntity(order);
        entity.setUserCreated("saga-order-service");
        entity.setUserUpdated("saga-order-service");
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        this.repository.save(entity);
        return mapper.toOrderDomain(entity);
    }

    public void updateOrder(OrderDomain order) {
        var entityOptional = this.repository.findById(order.getOrderId());
        if (entityOptional.isPresent()) {
            var entity = entityOptional.get();
            entity.setOrderState(order.getOrderState());
            this.repository.save(entity);
        }
    }
}
