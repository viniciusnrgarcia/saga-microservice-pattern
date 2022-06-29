package br.com.vnrg.sagaorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan
@SpringBootApplication
@EnableAsync
public class SagaOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SagaOrderServiceApplication.class, args);
    }

}