package br.com.vnrg.sagaproductservice.messaging.consumer;

import br.com.vnrg.sagaproductservice.domain.Order;
import br.com.vnrg.sagaproductservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderCreatedReceiver {

    private final ProductService productService;

    public OrderCreatedReceiver(ProductService productService) {
        this.productService = productService;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue.order-created-product}",
            concurrency = "${spring.rabbitmq.queue.order-created-product-concurrency:1}")
    public void listen(final Order order) {
        log.info("order-created received {}", order.toString());
        this.productService.reserveProduct(order);
        this.productService.createProductOrder();
    }

}