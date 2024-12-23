package com.example.spring_demo.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "files")
public class File implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;  
    private String name;
    private String path;
}
