package com.example.spring_demo.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;  

public interface NoticeInterface {
    void sendNotice(String email, String content);
}
