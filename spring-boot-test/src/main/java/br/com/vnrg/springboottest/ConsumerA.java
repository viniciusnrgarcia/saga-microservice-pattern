package br.com.vnrg.springboottest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsumerA {

    @RabbitListener(queues = "qeue_a")
    public void queuA(String event) {
        log.info("Event: {}", event);
    }
}
