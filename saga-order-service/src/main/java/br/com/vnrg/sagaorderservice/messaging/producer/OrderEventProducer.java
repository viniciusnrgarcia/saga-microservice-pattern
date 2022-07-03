package br.com.vnrg.sagaorderservice.messaging.producer;

import br.com.vnrg.sagaorderservice.openapi.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderEventProducer {

    private final ObjectMapper objectMapper;
    private final RabbitTemplate rabbitTemplate;

    public OrderEventProducer(ObjectMapper objectMapper, RabbitTemplate rabbitTemplate) {
        this.objectMapper = objectMapper;
        this.rabbitTemplate = rabbitTemplate;
    }

    @SneakyThrows
    public void send(final Order data) {
        /*CloudEventBuilder eventBuilder = CloudEventBuilder.v1()
                .withId(UUID.randomUUID().toString())
                .withType("order-created")
                .withSource(URI.create("saga-order-service.svc.cluster.local"))
                .withData(this.objectMapper.writeValueAsBytes(data))
                .withDataContentType("application/json; charset=UTF-8")
                .withTime(OffsetDateTime.now());
                CloudEvent event = eventBuilder.build();
                */
        log.info("Send event: {}", data.toString());

//        Message message = new Message(this.objectMapper.writeValueAsBytes(data));
//        rabbitTemplate.send("order-created-exchange", "*", message);
        rabbitTemplate.convertAndSend("order-created-exchange", "", data);

    }
}
