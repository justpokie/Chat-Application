package com.pokie.pokichat.controllers;

import com.pokie.pokichat.model.Channel;
import com.pokie.pokichat.model.Message;
import com.pokie.pokichat.repositories.ChannelRepository;
import com.pokie.pokichat.repositories.MessageRepository;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chat")
@CrossOrigin
public class ChatController {

    // TODO - Get messages from a database

    private final MessageRepository messageRepository;

    private final ChannelRepository channelRepository;

    public ChatController(MessageRepository messageRepository, ChannelRepository channelRepository) {
        this.messageRepository = messageRepository;
        this.channelRepository = channelRepository;
    }

    @GetMapping("/{channel_id}")
    List<Message> GetMessages(@PathVariable Integer channel_id) {
        return messageRepository.getMessagesByChannel(channel_id);
    }

    @GetMapping("/get_channels")
    List<Channel> GetChannels() {
        return channelRepository.findAll();
    }

    @PostMapping("/create_channel/{channel_name}")
    Channel CreateChannel(@PathVariable String channel_name) {
        Channel ch = new Channel();
        ch.setName(channel_name);

        channelRepository.save(ch);
        return ch;
    }

    @MessageMapping("/{channel_id}.sendMessage")
    @SendTo("/chat/{channel_id}")
    Message SendMessage(@Payload Message content, @DestinationVariable Integer channel_id) {
        Channel ch = channelRepository.findById(channel_id).orElse(null);

        if(ch == null) {
            return null;
        }
        content.setChannel(ch);
        messageRepository.save(content);
        return content;
    }

}
