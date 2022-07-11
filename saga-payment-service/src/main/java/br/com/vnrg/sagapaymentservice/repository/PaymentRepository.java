package br.com.vnrg.sagapaymentservice.repository;

import br.com.vnrg.sagapaymentservice.repository.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

}
