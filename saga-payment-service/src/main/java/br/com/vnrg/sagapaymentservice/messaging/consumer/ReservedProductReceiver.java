package br.com.vnrg.sagapaymentservice.messaging.consumer;

import br.com.vnrg.sagapaymentservice.domain.OrderDomain;
import br.com.vnrg.sagapaymentservice.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReservedProductReceiver {

    private final PaymentService service;

    public ReservedProductReceiver(PaymentService service) {
        this.service = service;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue.reserved-product-payment}",
            concurrency = "${spring.rabbitmq.queue.order-created-product-concurrency:1}")
    public void listen(final OrderDomain order) {
        log.info("reserved-product received {}", order.toString());
        this.service.payment(order);
    }

}