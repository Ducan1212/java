package com.example.spring_demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;  
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;  
import org.springframework.security.web.SecurityFilterChain;

import com.example.spring_demo.service.UserAuthenticationService;
  
@Configuration  
@EnableWebSecurity
public class WebSecurityConfig {  
    
    @Autowired 
    private UserAuthenticationService authenticationProvider;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    @Bean  
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {  
        http  
            .authorizeHttpRequests(authorize -> authorize  
                  .requestMatchers("/static/**").permitAll()
                  .anyRequest().authenticated()
            )
            .formLogin(formLogin -> formLogin
                  .loginPage("/login")
                  .loginProcessingUrl("/login")
                  .usernameParameter("username")
                  .passwordParameter("password")
                  .defaultSuccessUrl("/message", true)
                  .successHandler(customAuthenticationSuccessHandler)
                  .failureUrl("/login?error=true")
                  .permitAll()
            );
  
        return http.build();
    }

    @Bean  
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {  
        AuthenticationManagerBuilder authenticationManagerBuilder =   
            http.getSharedObject(AuthenticationManagerBuilder.class);  
        authenticationManagerBuilder.authenticationProvider(authenticationProvider);  
        return authenticationManagerBuilder.build();  
    }  
} 
