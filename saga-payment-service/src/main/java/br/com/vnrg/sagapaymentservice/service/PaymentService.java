package br.com.vnrg.sagapaymentservice.service;

import br.com.vnrg.sagapaymentservice.domain.OrderDomain;
import br.com.vnrg.sagapaymentservice.messaging.producer.PaymentCompletedPublisher;
import br.com.vnrg.sagapaymentservice.repository.PaymentRepository;
import br.com.vnrg.sagapaymentservice.repository.mapper.PaymentOrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class PaymentService {

    private final PaymentRepository repository;

    private final PaymentCompletedPublisher publisher;

    public PaymentService(PaymentRepository repository, PaymentCompletedPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    public void payment(OrderDomain order) {
        var entity = PaymentOrderMapper.INSTANCE.toEntity(order);
        entity.setUserCreated("saga-payment-service");
        entity.setUserUpdated("saga-payment-service");
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdateAt(LocalDateTime.now());
        this.repository.save(entity);
        order.setOrderState(5);
        this.publisher.send(order);
        log.info("payment completed {} ", entity.toString());
    }

}
