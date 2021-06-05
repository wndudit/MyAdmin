package com.example.MyAdmin.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor // 모든 매개변수가 들어가는 생성자를 만들어주자.
@NoArgsConstructor // 기본 생성자 만들어준다.  public User () {}  매개변수 없음.
@Data //객체를 가질 거임
@Entity
@ToString(exclude = {"user","item"})
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderAt;
    @ManyToOne
    private User user; // mappedBy="user"여기 변수명과 같아야한다.

    @ManyToOne
    private Item item; //getItem으로 객체를 가져올 수 있게된다.


}
