package com.example.MyAdmin.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor // 모든 매개변수가 들어가는 생성자를 만들어주자.
@NoArgsConstructor // 기본 생성자 만들어준다.  public User () {}  매개변수 없음.
@Data //객체를 가질 거임
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;
    private String email;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updateAt;
    private String updatedBy;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    private List<OrderDetail> orderDetailList;



}
