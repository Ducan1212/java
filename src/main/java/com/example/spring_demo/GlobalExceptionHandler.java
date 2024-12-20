package com.example.spring_demo;

import org.springframework.http.HttpStatus;  
import org.springframework.web.bind.annotation.ControllerAdvice;  
import org.springframework.web.bind.annotation.ExceptionHandler;  
import org.springframework.web.bind.annotation.ResponseStatus;  
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.ui.Model; 
  
@ControllerAdvice  
public class GlobalExceptionHandler {  
  
    @ExceptionHandler(NoHandlerFoundException.class)  
    @ResponseStatus(HttpStatus.NOT_FOUND)  
    public String handleNotFoundError(Model model) {  
        model.addAttribute("message", "404 Not Found");  

        return "error";
    }  
}  
