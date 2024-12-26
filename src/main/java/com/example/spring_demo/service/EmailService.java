package com.example.spring_demo.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public void sendEmail(String email, String content) {
        System.out.println("Send email to " + email + " with content: " + content);
    }
}
