package br.com.vnrg.sagaproductservice.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class BroadcastConfig {

    @Value("${spring.rabbitmq.exchange-name}")
    private String exchangeName;

    @Value("${spring.rabbitmq.product-not-available-exchange-name}")
    private String productNotAvailableExchangeName;

    @Value("${spring.rabbitmq.reserved-product-exchange-name}")
    private String reservedProductExchangeName;

    @Value("${spring.rabbitmq.routingKey}")
    private String routingKey;

    @Value("${spring.rabbitmq.queue.order-created-product}")
    private String orderCreatedQueue;

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
