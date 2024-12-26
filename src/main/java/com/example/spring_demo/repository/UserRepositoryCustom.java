package com.example.spring_demo.repository;

import java.util.List;

import com.example.spring_demo.model.User;

public interface UserRepositoryCustom {
    User findByUsernameAndPassword(String username, String password);
    List<User> findListUserOther(Long id);
    User findUserById(Long id);
}
