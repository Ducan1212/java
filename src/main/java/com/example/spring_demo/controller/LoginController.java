package com.example.spring_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring_demo.service.UserService;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userSerivce;
    
    @GetMapping(value = "/login")
    public String login(@RequestParam(required = false) String error, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {  

            return "redirect:/message";
        }  
        if (error != null) {
            model.addAttribute("error", "Invalid username or password");
        }

        return "login";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();

        return "redirect:/login";
    }
}
