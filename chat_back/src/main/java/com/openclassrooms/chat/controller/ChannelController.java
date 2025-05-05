package com.openclassrooms.chat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openclassrooms.chat.entity.Channel;
import com.openclassrooms.chat.repository.ChannelRepository;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("channel")
public class ChannelController {

    private final ChannelRepository channelRepository;

    public ChannelController(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<String> create(@PathVariable("userId") String userId) {

        channelRepository.save(new Channel(userId));
    
        return ResponseEntity.ok("Channel created successfully");
    }

}