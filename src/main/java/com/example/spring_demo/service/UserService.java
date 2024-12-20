package com.example.spring_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_demo.model.User;
import com.example.spring_demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User findByUsernameAndPassword(String username, String password) {  
        return userRepository.findByUsernameAndPassword(username, password);  
    }  
}
