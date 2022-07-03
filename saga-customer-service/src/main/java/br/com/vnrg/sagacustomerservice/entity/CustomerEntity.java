package br.com.vnrg.sagacustomerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String username;

    private String password;

    private String name;

    @Column(name = "customer_status")
    private Integer customerStatus;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "user_created")
    private String userCreated;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "user_updated")
    private String userUpdated;
}
