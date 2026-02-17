package com.pokie.pokichat.controllers;

import com.pokie.pokichat.model.Message;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chat")
@CrossOrigin
public class Controller {

    List<Message> chatMessages = new ArrayList<Message>();

    @GetMapping("")
    List<Message> GetMessages() {
        return chatMessages;
    }

    @PostMapping("")
    void SendMessage(@RequestBody Message content) {
        System.out.println(content);
        chatMessages.add(content);
    }

}
