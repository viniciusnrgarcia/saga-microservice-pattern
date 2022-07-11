package br.com.vnrg.sagapaymentservice.service;

import br.com.vnrg.sagapaymentservice.domain.OrderDomain;
import br.com.vnrg.sagapaymentservice.repository.PaymentRepository;
import br.com.vnrg.sagapaymentservice.repository.mapper.PaymentOrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class PaymentService {

    private final PaymentRepository repository;

    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    public void payment(OrderDomain order) {
        var entity = PaymentOrderMapper.INSTANCE.toEntity(order);
        entity.setUserCreated("saga-payment-service");
        entity.setUserUpdated("saga-payment-service");
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdateAt(LocalDateTime.now());
        this.repository.save(entity);
        log.info("payment completed {} ", entity.toString());
    }

}
