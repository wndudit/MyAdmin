package com.example.MyAdmin.repository;

import com.example.MyAdmin.model.entity.Item;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;

@SpringBootTest
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void create(){
        Item item = new Item();
        item.setName("노트북");
        item.setContent("삼성 노트북");
        item.setPrice(10000);

        Item newItem = itemRepository.save(item);

        Assert.assertNotNull(newItem);

    }

    @Test
    public void read(){
        Long id = 2L;

        Optional<Item> item = itemRepository.findById(id);

        Assert.assertTrue(item.isPresent());
    }
}
