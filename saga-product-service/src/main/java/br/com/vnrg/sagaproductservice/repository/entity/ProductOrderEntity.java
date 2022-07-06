package br.com.vnrg.sagaproductservice.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_product_order")
public class ProductOrderEntity extends AuditEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_items")
    private Integer productItems;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_value")
    private BigDecimal orderValue;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "product_order_status")
    private Integer productOrderStatus;

}
