package com.openclassrooms.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.openclassrooms.chat.entity.ChatMessage;


@Controller
public class SupportChatController {

    @MessageMapping("/chat/support")
    @SendTo("/support/{channelId}")
    public ChatMessage sendMessageToSupport(String channelId, @Payload ChatMessage message) throws Exception {
        return message; 
    }

}
