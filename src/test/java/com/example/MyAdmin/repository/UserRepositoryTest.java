package com.example.MyAdmin.repository;

import com.example.MyAdmin.model.entity.Item;
import com.example.MyAdmin.model.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired // private UserRepository userRepository = new UserRepository(); 로 생성하는것을 줄여준다. (DI) Spring이 주입.
    private UserRepository userRepository;

    @Test
    public void create(){
        String account="Test01";
        String password= "Test01";
        String status = "REGISTERED";
        String email = "test01@gmail.com";
        String phoneNumber ="010-1234-1234";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "Admin";

        User user = new User();
        user.setAccount(account);
        user.setEmail(email);
        user.setStatus(status);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);

        Assert.assertNotNull(newUser);


    }

    @Test
    @Transactional
    public void read(){
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1234-2345");

        user.getOrderGroupList().stream().forEach(orderGroup -> {
            System.out.println("----------------주문묶음-----------------");
            System.out.println(orderGroup.getTotalPrice());
            System.out.println(orderGroup.getRevAddress());
            System.out.println(orderGroup.getRevName());

            System.out.println("-----------------주문상세----------------");

            orderGroup.getOrderDetailList().forEach(orderDetail -> {
                System.out.println("파트너사: "+ orderDetail.getItem().getPartner().getName());
                System.out.println("카테고리:" + orderDetail.getItem().getPartner().getCategory().getTitle());
                System.out.println("주문상품: " + orderDetail.getItem().getName());
                System.out.println("고객센터번호: "+ orderDetail.getItem().getPartner().getCallCenter());
                System.out.println("주문상태: "+orderDetail.getStatus());
                System.out.println("도착예정일자: "+ orderDetail.getArrivedDate());

            });

        });

    }


}
