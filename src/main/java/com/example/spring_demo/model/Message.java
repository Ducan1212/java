package com.example.spring_demo.model;  
  
public class Message {  
    private String userId;  
    private String userName; // Thêm thuộc tính userName  
    private String content;  
  
    // Constructors, getters, và setters  
    public Message() { }  
  
    public Message(String userId, String userName, String content) {  
        this.userId = userId;  
        this.userName = userName;  
        this.content = content;  
    }  
  
    public String getUserId() {  
        return userId;  
    }  
  
    public void setUserId(String userId) {  
        this.userId = userId;  
    }  
  
    public String getUserName() {  
        return userName;  
    }  
  
    public void setUserName(String userName) {  
        this.userName = userName;  
    }  
  
    public String getContent() {  
        return content;  
    }  
  
    public void setContent(String content) {  
        this.content = content;  
    }  
}  