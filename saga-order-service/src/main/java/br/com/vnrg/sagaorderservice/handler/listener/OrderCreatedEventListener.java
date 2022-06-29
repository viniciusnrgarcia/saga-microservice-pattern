package br.com.vnrg.sagaorderservice.handler.listener;

import br.com.vnrg.sagaorderservice.handler.event.OrderCreatedEvent;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderCreatedEventListener {

    @SneakyThrows
    @EventListener(classes = OrderCreatedEvent.class)
    public void orderCreatedListener(OrderCreatedEvent event) {
        log.info("orderCreatedListener {}", event);
    }
}
