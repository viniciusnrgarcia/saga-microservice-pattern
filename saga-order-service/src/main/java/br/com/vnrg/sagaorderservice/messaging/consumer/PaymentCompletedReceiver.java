package br.com.vnrg.sagaorderservice.messaging.consumer;

import br.com.vnrg.sagaorderservice.domain.OrderDomain;
import br.com.vnrg.sagaorderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentCompletedReceiver {

    private final OrderService service;

    public PaymentCompletedReceiver(OrderService service) {
        this.service = service;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue.payment-completed}")
    public void listen(final OrderDomain order) {
        log.info("payment-completed received {}", order.toString());
        this.service.updateOrder(order);
    }

}