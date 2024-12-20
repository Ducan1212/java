package com.example.spring_demo.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;  
    private String username;
    private String password;

    public String getUsername() {
        return username;  
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
