package com.pokie.pokichat.controllers;

import com.pokie.pokichat.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chat")
@CrossOrigin
public class ChatController {

    // TODO - Get messages from a database
    List<Message> chatMessages = new ArrayList<Message>();

    @GetMapping("")
    List<Message> GetMessages() {
        return chatMessages;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/chat/public")
    Message SendMessage(@Payload Message content) {
        System.out.println(content);
        chatMessages.add(content);
        return content;
    }

}
