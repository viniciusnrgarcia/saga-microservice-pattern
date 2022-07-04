package br.com.vnrg.sagaproductservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan
@SpringBootApplication
@EnableAsync
@EnableRabbit
public class SagaProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SagaProductServiceApplication.class, args);
    }

}