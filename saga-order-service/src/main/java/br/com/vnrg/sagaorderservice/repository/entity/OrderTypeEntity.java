package br.com.vnrg.sagaorderservice.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_order_type")
public class OrderTypeEntity {

    @Id
    private Integer id;

    @Column(name = "order_type_description")
    private String orderTypeDescription;
}
