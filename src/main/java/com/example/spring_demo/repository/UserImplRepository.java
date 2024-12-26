package com.example.spring_demo.repository;  

import com.example.spring_demo.repository.UserRepositoryCustom;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.spring_demo.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Primary;

@Repository
@Primary
public class UserImplRepository implements UserRepositoryCustom {
    @Override
    public User findByUsernameAndPassword(String name, String password) {
        System.out.println("Find user by username and password");
        return new User();
    }

    @Override
    public List<User> findListUserOther(Long id) {
        System.out.println("Find list user other");
        return List.of();
    }

    @Override
    public User findUserById(Long id) {
        System.out.println("Find user by id");
        return new User();
    }
}
