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
        User user = new User();
        user.setAccount("test05");
        user.setEmail("test05@gmail.com");
        user.setPhoneNumber("010-2345-1234");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user);

    }

    @Test
    public void read(){
        Optional<User> user = userRepository.findById(1L); //제네릭 타입

        user.ifPresent(selectUser -> {
            System.out.println("user: " + selectUser);
        });
    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(2L);
        user.ifPresent(selectUser -> {
            selectUser.setAccount("test002");
            selectUser.setUpdateAt(LocalDateTime.now());
            selectUser.setUpdatedBy("admin");

            userRepository.save(selectUser);
        });
    }

    @Test
    @Transactional  // delete해도 rollback해준다.
    public void delete(){
        Optional<User> user = userRepository.findById(3L);
        Assert.assertTrue(user.isPresent());

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> dUser = userRepository.findById(3L);

        Assert.assertFalse(dUser.isPresent());

    }

    @Test
    @Transactional
    public void readUser(){
        //Optional<User> user = userRepository.findById(3L);
        Optional<User> user = userRepository.findByAccount("test01");

        user.ifPresent( selectUser -> {
            selectUser.getOrderDetailList().stream().forEach( detail -> {
                Item item =  detail.getItem();
                System.out.println(item);
            });
        });

    }


}
