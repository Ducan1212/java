package com.example.spring_demo.repository;

import com.example.spring_demo.model.File;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.data.jpa.repository.Query;  


public interface FileRepository extends JpaRepository<File, Long> {  
    @Query("SELECT u FROM File u") 
    List<File> getListFile(); 
}