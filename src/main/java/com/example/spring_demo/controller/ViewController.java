package com.example.spring_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping(value = "/locale")
    public String locale() {
        return "locale";
    }
}
