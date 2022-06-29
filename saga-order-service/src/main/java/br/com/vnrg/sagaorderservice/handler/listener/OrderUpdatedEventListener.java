package br.com.vnrg.sagaorderservice.handler.listener;

import br.com.vnrg.sagaorderservice.handler.event.OrderUpdatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderUpdatedEventListener implements ApplicationListener<OrderUpdatedEvent> {

    @Override
    public void onApplicationEvent(OrderUpdatedEvent event) {
        log.info("onApplicationEvent {}", event.toString());
    }
}
