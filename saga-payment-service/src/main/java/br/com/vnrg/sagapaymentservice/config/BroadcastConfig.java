package br.com.vnrg.sagapaymentservice.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class BroadcastConfig {

    @Value("${spring.rabbitmq.reserved-product-exchange-name}")
    private String reservedProductExchangeName;

    @Value("${spring.rabbitmq.queue.reserved-product-payment}")
    private String reservedProductQueue;

    @Value("${spring.rabbitmq.payment-completed-exchange-name}")
    private String paymentCompletedExchangeName;

    @Value("${spring.rabbitmq.routingKey}")
    private String routingKey;

    @Value("${spring.rabbitmq.connection-factory.hostname}")
    private String hostname;

    @Value("${spring.rabbitmq.connection-factory.port}")
    private Integer port;

    @Value("${spring.rabbitmq.connection-factory.username}")
    private String username;

    @Value("${spring.rabbitmq.connection-factory.password}")
    private String password;

    @Value("${spring.rabbitmq.rabbit-template.initial-interval}")
    private Integer initialInterval;

    @Value("${spring.rabbitmq.rabbit-template.multiplier}")
    private Integer multiplier;

    @Value("${spring.rabbitmq.rabbit-template.max-interval}")
    private Integer maxInterval;

}
