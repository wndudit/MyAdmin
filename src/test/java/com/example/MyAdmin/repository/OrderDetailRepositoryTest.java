package com.example.MyAdmin.repository;

import com.example.MyAdmin.model.entity.OrderDetail;
import com.example.MyAdmin.model.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Test
    @Transactional
    public void create(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderAt(LocalDateTime.now());
        //orderDetail.setUserId(3L);
        //orderDetail.setItemId(2L);

        OrderDetail newOrder = orderDetailRepository.save(orderDetail);

        Assert.assertNotNull(newOrder);


    }




}
