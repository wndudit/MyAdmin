package com.example.MyAdmin.repository;

import com.example.MyAdmin.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    // select * from user where account = ?
    Optional<User> findByAccount(String account);

    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);

}
