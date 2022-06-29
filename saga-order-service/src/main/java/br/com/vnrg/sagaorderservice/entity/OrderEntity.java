package br.com.vnrg.sagaorderservice.entity;

import lombok.Data;

@Data
public class OrderEntity {
    private String orderId;
    private String orderType;
}
