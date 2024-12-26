package com.example.spring_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.spring_demo.service.EmailService;
import com.example.spring_demo.service.NoticeService;
import org.springframework.stereotype.Service;

@Service
public class NoticeImpl implements NoticeInterface {
    @Autowired
    private EmailService emailService;

    @Autowired
    private NoticeService noticeService;

    @Override
    public void sendNotice(String email, String content) {
        emailService.sendEmail(email, content);
        noticeService.sendNotice(email, content);
    }
}
