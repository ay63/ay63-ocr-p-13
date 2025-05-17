package com.openclassrooms.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import com.openclassrooms.chat.entity.Chat;
import com.openclassrooms.chat.entity.Message;
import com.openclassrooms.chat.repository.ChatRepository;

@Controller
public class ChatWebSocketController {

    private final ChatRepository chatRepository;

    public ChatWebSocketController(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @MessageMapping("/support/{chatId}")
    @SendTo("/support/{chatId}")
    public Message sendMessageToSupport(@PathVariable String chatId, @Payload Message message) throws Exception {
        Chat chat = chatRepository.findById(chatId).orElse(null);
        if (chat != null) {
            chat.getMessages().add(message);
            chatRepository.save(chat);
        }
        return message;
    }
}
