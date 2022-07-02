package br.com.vnrg.sagaorderservice.producer;

import br.com.vnrg.sagaorderservice.openapi.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cloudevents.CloudEvent;
import io.cloudevents.CloudEventData;
import io.cloudevents.core.CloudEventUtils;
import io.cloudevents.core.builder.CloudEventBuilder;
import io.cloudevents.core.data.PojoCloudEventData;
import io.cloudevents.core.provider.EventFormatProvider;
import io.cloudevents.jackson.JsonFormat;
import io.cloudevents.jackson.PojoCloudEventDataMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.UUID;

import static io.cloudevents.core.CloudEventUtils.mapData;

@Slf4j
@Component
public class OrderEventProducer {

    @SneakyThrows
    public void send(final Object data) {
        CloudEvent event = CloudEventBuilder.v1()
                .withId(UUID.randomUUID().toString())
                .withData(new ObjectMapper().writeValueAsBytes(data))
                .withTime(OffsetDateTime.now())
                .build();
        log.info("Send event: {}", event);

        // test
        String id = event.getId();
        CloudEventData dataEvent = event.getData();
        byte[] dataEventBytes = dataEvent.toBytes();

        PojoCloudEventData<Order> cloudEventData = mapData(
                event,
                PojoCloudEventDataMapper.from(new ObjectMapper(), Order.class)
        );

        Order order = cloudEventData.getValue();
        log.info(order.toString());
    }
}
