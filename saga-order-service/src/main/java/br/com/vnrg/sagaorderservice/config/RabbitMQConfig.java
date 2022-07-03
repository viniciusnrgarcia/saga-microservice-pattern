package br.com.vnrg.sagaorderservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.Collections;

@Configuration
public class RabbitMQConfig {

    private final ObjectMapper objectMapper;

    public RabbitMQConfig(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    // producer configuration

    /**
     * Configuração
     * https://docs.spring.io/spring-amqp/reference/html/#connections
     * @return {@link CachingConnectionFactory}
     */
    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        // cluster host
        // connectionFactory.setAddresses("host1:5672,host2:5672,host3:5672");
        // connectionFactory.setAddressShuffleMode(AddressShuffleMode.RANDOM);
        // this.props.getUsername()
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    public RabbitAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    // consumer configuration
    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        RetryTemplate retryTemplate = new RetryTemplate();
        ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
        backOffPolicy.setInitialInterval(500);
        backOffPolicy.setMultiplier(10.0);
        backOffPolicy.setMaxInterval(10000);
        retryTemplate.setBackOffPolicy(backOffPolicy);
        template.setRetryTemplate(retryTemplate);
        template.setMessageConverter(jsonConverter());
        return template;
    }

    @Bean
    public MessageConverter jsonConverter() {
        return new Jackson2JsonMessageConverter(this.objectMapper);
    }

    @Bean
    public Queue queue() {
        return new Queue("order-created-queue", false);
    }

    @Bean
    public Queue queue2() {
        return new Queue("order-created-queue2", false);
    }

    @Bean
    public DirectExchange directExchange() {
        // public DirectExchange directExchange() {
        // return new TopicExchange("order-created-exchange");
        // return new FanoutExchange("order-created-exchange");
        return new DirectExchange("order-created-exchange");
        // return new FanoutExchange("order-created-exchange");
    }

    @Bean
    public Binding binding() {
        // return BindingBuilder.bind(queue()).to(exchange()).with("*");
        // return BindingBuilder.bind(queue()).to(directExchange());
        return BindingBuilder.bind(queue()).to(directExchange()).withQueueName();
    }

    @Bean
    public Binding binding2() {
        // return BindingBuilder.bind(queue2()).to(directExchange()).with("*");
        // return BindingBuilder.bind(queue2()).to(directExchange());
        // new Binding(
                //this.destination.name,
            // this.destination.type,
            // this.exchange,
            // this.destination.name,
            // Collections.emptyMap());
        return BindingBuilder.bind(queue2()).to(directExchange()).withQueueName();
    }

    /*
    @Bean
public Declarables topicBindings() {
    Queue topicQueue1 = new Queue(topicQueue1Name, false);
    Queue topicQueue2 = new Queue(topicQueue2Name, false);
    TopicExchange topicExchange = new TopicExchange(topicExchangeName);
    return new Declarables(
      topicQueue1,
      topicQueue2,
      topicExchange,
      BindingBuilder
        .bind(topicQueue1)
        .to(topicExchange).with("*.important.*"),
      BindingBuilder
        .bind(topicQueue2)
        .to(topicExchange).with("#.error"));
}
     */


    /**
     @Configuration
     public class BroadcastConfig {

     private static final boolean NON_DURABLE = false;

     public final static String FANOUT_QUEUE_1_NAME = "com.baeldung.spring-amqp-simple.fanout.queue1";
     public final static String FANOUT_QUEUE_2_NAME = "com.baeldung.spring-amqp-simple.fanout.queue2";
     public final static String FANOUT_EXCHANGE_NAME = "com.baeldung.spring-amqp-simple.fanout.exchange";

     public final static String TOPIC_QUEUE_1_NAME = "com.baeldung.spring-amqp-simple.topic.queue1";
     public final static String TOPIC_QUEUE_2_NAME = "com.baeldung.spring-amqp-simple.topic.queue2";
     public final static String TOPIC_EXCHANGE_NAME = "com.baeldung.spring-amqp-simple.topic.exchange";
     public static final String BINDING_PATTERN_IMPORTANT = "*.important.*";
     public static final String BINDING_PATTERN_ERROR = "#.error";

     @Bean
     public Declarables topicBindings() {
     Queue topicQueue1 = new Queue(TOPIC_QUEUE_1_NAME, NON_DURABLE);
     Queue topicQueue2 = new Queue(TOPIC_QUEUE_2_NAME, NON_DURABLE);

     TopicExchange topicExchange = new TopicExchange(TOPIC_EXCHANGE_NAME, NON_DURABLE, false);

     return new Declarables(topicQueue1, topicQueue2, topicExchange, BindingBuilder
     .bind(topicQueue1)
     .to(topicExchange)
     .with(BINDING_PATTERN_IMPORTANT), BindingBuilder
     .bind(topicQueue2)
     .to(topicExchange)
     .with(BINDING_PATTERN_ERROR));
     }

     @Bean
     public Declarables fanoutBindings() {
     Queue fanoutQueue1 = new Queue(FANOUT_QUEUE_1_NAME, NON_DURABLE);
     Queue fanoutQueue2 = new Queue(FANOUT_QUEUE_2_NAME, NON_DURABLE);

     FanoutExchange fanoutExchange = new FanoutExchange(FANOUT_EXCHANGE_NAME, NON_DURABLE, false);

     return new Declarables(fanoutQueue1, fanoutQueue2, fanoutExchange, BindingBuilder
     .bind(fanoutQueue1)
     .to(fanoutExchange), BindingBuilder
     .bind(fanoutQueue2)
     .to(fanoutExchange));
     }
     */
}
