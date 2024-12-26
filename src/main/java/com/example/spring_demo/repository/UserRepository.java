package com.example.spring_demo.repository;  
  
import com.example.spring_demo.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.data.jpa.repository.Query;  
import org.springframework.data.repository.query.Param;  
import com.example.spring_demo.repository.UserRepositoryCustom;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom { 
    String column = "id, username, password, email, phone, address, role, status, created_at, updated_at";
     
    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")    
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Query("SELECT u FROM User u WHERE u.id <> :id")    
    List<User> findListUserOther(@Param("id") Long id); 

    @Query("SELECT u FROM User u WHERE u.id = :id")
    User findUserById(@Param("id") Long id);
}
