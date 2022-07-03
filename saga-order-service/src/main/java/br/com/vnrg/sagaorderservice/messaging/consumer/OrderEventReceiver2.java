package br.com.vnrg.sagaorderservice.messaging.consumer;

import br.com.vnrg.sagaorderservice.openapi.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderEventReceiver2 {

    @RabbitListener(queues = "order-created-queue2", concurrency = "1")
    public void listen2(Order event) {
        log.info("BBBBBBBBBBBBB Message read from order-created-queue2 : {}", event.toString());
        if (event != null) {
            log.info("BBBBBBBBBBBBB event queue2 not null");
        }

        log.info("BBBBBBBBBBBBB End processing queue2");
    }
}
