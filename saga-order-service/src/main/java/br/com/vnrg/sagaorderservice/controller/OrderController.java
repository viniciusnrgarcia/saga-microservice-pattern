package br.com.vnrg.sagaorderservice.controller;

import br.com.vnrg.sagaorderservice.openapi.api.OrderApi;
import br.com.vnrg.sagaorderservice.openapi.model.Order;
import com.github.javafaker.Faker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class OrderController implements OrderApi {

    public ResponseEntity<Order> getOrderById(Long orderId) {
        var faker = new Faker();
        var order = new Order();
        order.setId(faker.random().nextLong());
        order.setOrderId(faker.random().nextLong());
        order.setQuantity(faker.hashCode());
        order.setOrderDate(LocalDateTime.now());
        return ResponseEntity.ok(order);
    }
}
