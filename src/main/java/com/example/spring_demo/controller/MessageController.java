package com.example.spring_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.spring_demo.service.UserService;
import com.example.spring_demo.service.NoticeInterface;
import com.example.spring_demo.utils.AuthAutils;
import com.example.spring_demo.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;  
import org.springframework.messaging.handler.annotation.SendTo;  
import org.springframework.messaging.simp.SimpMessagingTemplate;
import com.example.spring_demo.model.Message;  


@Controller
public class MessageController {

    @Autowired
    UserService userService;
    
    @Autowired
    AuthAutils authAutils;

    @Autowired
    NoticeInterface noticeInterface;

    private final SimpMessagingTemplate messagingTemplate;  


    public MessageController(SimpMessagingTemplate messagingTemplate) {  
        this.messagingTemplate = messagingTemplate;  
    }  

    @GetMapping(value = "/message")
    public String message(org.springframework.ui.Model model) {
        Long userId = authAutils.getUserId();
        List<User> users = userService.findListUserOther(userId);
        model.addAttribute("users", users);
        noticeInterface.sendNotice("ducan11395@gmail.com", "GO HOME");

        return "message";
    }

    @GetMapping(value = "/message/{id}")
    public String messageDetail(org.springframework.ui.Model model, @PathVariable Long id) {
        User user = userService.findUserById(id);
        if (user == null || id.equals(authAutils.getUserId())) {
            return "redirect:/message";
        }
        model.addAttribute("user", user);

        return "messageDetail";
    }

    @MessageMapping("/send/{userId}")
    @SendTo("/topic/messages")
    public void sendMessage(Message message) { 
        messagingTemplate.convertAndSend("/topic/messages", message);  
    }  
}
