package com.example.spring_demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.example.spring_demo.model.User;

@Service
public class UserAuthenticationService implements AuthenticationProvider {
    @Autowired
    UserService userSerivce;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        System.out.println("username: " + username + ", password: " + password);
        User user = userSerivce.findByUsernameAndPassword(username, password);
        if (user != null) {
            return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
        } else {
            return null;
        }
    }

    @Override
   public boolean supports(Class<?> tokenType)
   {
      return tokenType.equals(UsernamePasswordAuthenticationToken.class);
   }
}
