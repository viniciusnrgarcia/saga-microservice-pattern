package br.com.vnrg.sagapaymentservice.messaging.producer;

import br.com.vnrg.sagapaymentservice.config.BroadcastConfig;
import br.com.vnrg.sagapaymentservice.domain.OrderDomain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentCompletedPublisher {

    private final RabbitTemplate rabbitTemplate;

    private final BroadcastConfig broadcastConfig;

    public PaymentCompletedPublisher(final RabbitTemplate rabbitTemplate, final BroadcastConfig broadcastConfig) {
        this.rabbitTemplate = rabbitTemplate;
        this.broadcastConfig = broadcastConfig;
    }

    public void send(final OrderDomain data) {
        log.info("Send event: {}", data.toString());
        this.rabbitTemplate.convertAndSend(broadcastConfig.getPaymentCompletedExchangeName(), "", data);
    }
}
