package br.com.vnrg.sagaorderservice.messaging.consumer;

import br.com.vnrg.sagaorderservice.openapi.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderEventReceiver {

    @RabbitListener(queues = "order-created-queue", concurrency = "1")
    public void listen(Order event) {
        log.info("AAAAAAAAAAAAAA Message read from order-created-queue : {}", event.toString());
        log.info("AAAAAAAAAAAAAA End queue ");
    }

}
