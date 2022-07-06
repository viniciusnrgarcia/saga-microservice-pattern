package br.com.vnrg.sagaproductservice.repository;

import br.com.vnrg.sagaproductservice.repository.entity.ProductOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrderEntity, Long> {

}
