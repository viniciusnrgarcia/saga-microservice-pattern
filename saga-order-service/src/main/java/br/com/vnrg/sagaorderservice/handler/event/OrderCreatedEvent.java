package br.com.vnrg.sagaorderservice.handler.event;

import br.com.vnrg.sagaorderservice.openapi.model.Order;
import org.springframework.context.ApplicationEvent;

public class OrderCreatedEvent extends ApplicationEvent {

    // private final Order order;

    // public OrderEvent(final Object source, final Order order) {
    public OrderCreatedEvent(final Object source) {
        super(source);
        // this.order = order;
    }

    //    public Order getOrder() {
//        return this.order;
//    }
    public Order getOrder() {
        return (Order) super.getSource();
    }

}
