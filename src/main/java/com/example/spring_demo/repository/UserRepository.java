package com.example.spring_demo.repository;  
  
import com.example.spring_demo.model.User;  
import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.data.jpa.repository.Query;  
import org.springframework.data.repository.query.Param;  
  
public interface UserRepository extends JpaRepository<User, Long> {  
    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")    
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);    
}
