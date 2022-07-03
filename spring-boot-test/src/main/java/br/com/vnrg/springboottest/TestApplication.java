package br.com.vnrg.springboottest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.Serializable;
import java.util.UUID;

@ComponentScan
@SpringBootApplication
@EnableAsync
@Slf4j
public class TestApplication implements CommandLineRunner {

    private final ObjectMapper objectMapper;

    public TestApplication(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Running");

        var f = Faker.instance();
        var c = Customer.builder()
                .id(f.number().randomNumber())
                .name(f.name().firstName())
                .uuid(UUID.randomUUID())
                .build();

        try {
            this.rabbitTemplate().convertAndSend("exchange1", "*", objectMapper.writeValueAsString(c));

            Customer c2 = objectMapper.readValue((String) this.rabbitTemplate().receiveAndConvert("queue_a"), Customer.class);
            log.info("event received {} ", c2.toString());

            this.rabbitTemplate().convertAndSend("exchange1", "*", objectMapper.writeValueAsString(c));

        } catch (Exception e) {
            log.error("Error", e);
        }
    }

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    public Queue queue1() {
        return new Queue("queue_a");
    }

    @Bean
    public DirectExchange exchange1() {
        return new DirectExchange("exchange1");
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue1()).to(exchange1()).with("*");
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setMessageConverter(jsonConverter());
        return template;
    }

    @Bean
    public MessageConverter jsonConverter() {
        return new Jackson2JsonMessageConverter(this.objectMapper);
    }

}

@Builder
@Data
class Customer implements Serializable {
    private Long id;
    private String name;
    private UUID uuid;

}
