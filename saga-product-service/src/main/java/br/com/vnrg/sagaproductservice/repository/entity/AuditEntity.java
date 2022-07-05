package br.com.vnrg.sagaproductservice.repository.entity;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AuditEntity implements Serializable {

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "user_created")
    private String userCreated;

    @Column(name = "updated_at")
    private LocalDateTime updateAt;

    @Column(name = "user_updated")
    private String userUpdated;

}
