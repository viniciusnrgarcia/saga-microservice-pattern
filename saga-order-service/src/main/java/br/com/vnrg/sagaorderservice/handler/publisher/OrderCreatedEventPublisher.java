package br.com.vnrg.sagaorderservice.handler.publisher;

import br.com.vnrg.sagaorderservice.handler.event.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderCreatedEventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    @Async
    public void publish(OrderCreatedEvent event) {
        log.info("publish {} ", event.getOrder().toString());
        this.publisher.publishEvent(event);
    }
}
