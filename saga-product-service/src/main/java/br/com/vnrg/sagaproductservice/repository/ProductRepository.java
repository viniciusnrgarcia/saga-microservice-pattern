package br.com.vnrg.sagaproductservice.repository;

import br.com.vnrg.sagaproductservice.repository.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Modifying
    @Query(value = "update tb_product p set p.product_items = (p.product_items -1) where p.id = :id and p.product_items > 0 ", nativeQuery = true)
    @Transactional
    int updateProductItemReserved(@Param("id") final Long id);
}
