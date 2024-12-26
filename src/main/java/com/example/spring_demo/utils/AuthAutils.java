package com.example.spring_demo.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;  
import org.springframework.security.core.context.SecurityContextHolder;  
import com.example.spring_demo.model.User;

@Configuration
public class AuthAutils {
    @Bean
    public static Long getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();  
        if (authentication != null && authentication.isAuthenticated()) {    
            Object principal = authentication.getPrincipal();  
            if (principal instanceof User) {
                User user = (User) principal;    
                return user.getId();  
            }    
        }    
        return null;
    }
}
