package com.example.spring_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {
    @GetMapping(value = "/message")
    public String message() {
        return "message";
    }
}
