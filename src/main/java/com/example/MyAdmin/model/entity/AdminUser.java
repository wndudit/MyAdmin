package com.example.MyAdmin.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class) // AuditingEntityListener를 감시자로 사용하겠다.
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;
    private String password;
    private String status;
    private String role;
    private LocalDateTime lastLoginAt;
    private LocalDateTime passwordUpdateAt;
    private int loginFailCount;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;

    @CreatedDate
    private LocalDateTime createdAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @LastModifiedBy
    private String updatedBy;
}
