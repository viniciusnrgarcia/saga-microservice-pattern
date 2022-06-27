package br.com.vnrg.sagaorderservice.ports.http;

import br.com.vnrg.sagaorderservice.ports.http.domain.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @GetMapping
    public ResponseEntity<Order> getOrder() {
        return ResponseEntity.ok(new Order("1", "Ordem de compra"));
    }
}
