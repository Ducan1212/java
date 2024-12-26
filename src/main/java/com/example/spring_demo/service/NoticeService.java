package com.example.spring_demo.service;

import org.springframework.stereotype.Service;

@Service
public class NoticeService {
    public void sendNotice(String email, String content) {
        System.out.println("Send notice to " + email + " with content: " + content);
    }
}
