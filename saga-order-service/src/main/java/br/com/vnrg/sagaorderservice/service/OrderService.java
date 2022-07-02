package br.com.vnrg.sagaorderservice.service;

import br.com.vnrg.sagaorderservice.mapper.OrderMapper;
import br.com.vnrg.sagaorderservice.openapi.model.Order;
import br.com.vnrg.sagaorderservice.producer.OrderEventProducer;
import br.com.vnrg.sagaorderservice.repository.OrderRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repository;

    private final OrderEventProducer eventProducer;

    private final NamedParameterJdbcTemplate template;

    public OrderService(OrderRepository repository, OrderEventProducer eventProducer, NamedParameterJdbcTemplate template) {
        this.repository = repository;
        this.eventProducer = eventProducer;
        this.template = template;
    }

    public void createOrder(Order order) {
        var entity = OrderMapper.INSTANCE.toOrderEntity(order);
        // entity.setId(GeneratorID.stringUUID());
//        entity.setCreatedAt(LocalDateTime.now());
//        entity.setUserCreated("saga-order-service");
//        entity.setUpdatedAt(LocalDateTime.now());
//        entity.setUserUpdated("saga-order-service");
        var paramMap = new MapSqlParameterSource();
        this.repository.save(entity);

        // this.orderPublisher.publish(new OrderCreatedEvent(order));
        // this.eventProducer.send(order);
    }
}
