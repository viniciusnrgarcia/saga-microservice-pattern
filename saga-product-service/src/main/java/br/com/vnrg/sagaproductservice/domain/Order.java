package br.com.vnrg.sagaproductservice.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Order implements Serializable {

    private Integer orderType;

    private Integer orderState;

    private String orderDescription;

    private BigDecimal orderValue;

    private UUID productId;

    private Integer productItems;

    private String productDescription;

    private UUID customerId;

}
