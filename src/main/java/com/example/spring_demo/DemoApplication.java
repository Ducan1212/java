package com.example.spring_demo;  
  
import org.springframework.beans.factory.annotation.Value;  
import org.springframework.boot.ApplicationArguments;  
import org.springframework.boot.ApplicationRunner;  
import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;  
import org.springframework.context.ApplicationContext;  
import org.springframework.context.annotation.Bean;  
import org.springframework.http.HttpStatus;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.ResponseStatus;  
import org.springframework.web.bind.annotation.RestController;  
import org.springframework.web.client.RestTemplate;  
  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
  
// @RestController  
@SpringBootApplication  
public class DemoApplication implements ApplicationRunner {  
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);  
  
	@Value("${spring.application.name}")  
	private String appName;  
  
	public static void main(String[] args) {  
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);  
	} 
  
	@Override  
	public void run(ApplicationArguments arg0) throws Exception {  
		System.out.println("Hello World from Application Runner");  
	}  
  
	@ResponseStatus(HttpStatus.NOT_FOUND)    
	public static class ProductNotFoundException extends RuntimeException {    
		public ProductNotFoundException(String message) {    
			super(message);    
		}    
	}  
  
	@Bean  
	RestTemplate restTemplate() {  
		return new RestTemplate();  
	}   
}  
