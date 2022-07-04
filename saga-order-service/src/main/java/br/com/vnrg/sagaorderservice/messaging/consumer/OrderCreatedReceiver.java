package br.com.vnrg.sagaorderservice.messaging.consumer;

import br.com.vnrg.sagaorderservice.openapi.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderCreatedReceiver {

    @RabbitListener(queues = "${spring.rabbitmq.queue.order-created}",
            concurrency = "${spring.rabbitmq.queue.order-created-concurrency:1}")
    public void listen(final Order order) {
        log.info("Order-created published and received {}", order.toString());
    }

}