package com.example.MyAdmin.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor // 모든 매개변수가 들어가는 생성자를 만들어주자.
@NoArgsConstructor // 기본 생성자 만들어준다.  public User () {}  매개변수 없음.
@Data //객체를 가질 거임
@Entity
@ToString(exclude = {"orderGroup","item"})
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private LocalDateTime arrivedDate;
    private Integer quantity;
    private BigDecimal totalPrice;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    // Itme : OrderDetail = 1 : N
    @ManyToOne
    private Item item;
    // OrderDetail : OrderGroup = N : 1
    @ManyToOne
    private OrderGroup orderGroup; //mappedBy와 일치.


}
