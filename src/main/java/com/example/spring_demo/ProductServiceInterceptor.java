package com.example.spring_demo;  
  
import org.springframework.stereotype.Component;  
import org.springframework.web.servlet.HandlerInterceptor;  
import jakarta.servlet.http.HttpServletRequest;  
import jakarta.servlet.http.HttpServletResponse;  
import org.springframework.web.servlet.ModelAndView;  
  
@Component  
public class ProductServiceInterceptor implements HandlerInterceptor {  
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {  
      // System.out.println("Pre Handle method is Calling");  
      return true;  
   }
   @Override
   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {  
      // System.out.println("Post Handle method is Calling");  
   }
   @Override
   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {  
      // System.out.println("Request and Response is completed");  
   }
}
