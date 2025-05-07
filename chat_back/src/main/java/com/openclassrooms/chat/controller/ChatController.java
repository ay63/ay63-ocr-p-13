package com.openclassrooms.chat.controller;

import java.util.List;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.chat.entity.Chat;
import com.openclassrooms.chat.entity.Client;
import com.openclassrooms.chat.entity.Message;
import com.openclassrooms.chat.repository.ChatRepository;
import com.openclassrooms.chat.repository.ClientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RequestMapping("/chats")
public class ChatController {

    private final ChatRepository chatRepository;
    private final ClientRepository clientRepository;

    public ChatController(ChatRepository chatRepository, ClientRepository clientRepository) {
        this.chatRepository = chatRepository;
        this.clientRepository = clientRepository;
    }


    @PostMapping
    public Chat createChat() {
        Client client = clientRepository.findByUsername("john_doe").orElse(null);
        if (client == null) {
            client = new Client("john_doe", "John", "Doe", "john.doo@gmail.com","1234");
            clientRepository.save(client);
        }

        Chat chat = new Chat();
        chat.setClient(client);
        chat.setCreatedAt(new java.util.Date());        

        return chatRepository.save(chat);
    }

    @GetMapping("{chatId}")
    public List<Message> getMessages(@PathVariable String chatId) {
        return chatRepository.findById(chatId).map(Chat::getMessages).orElse(List.of());
    }

    @PostMapping("/{chatId}/messages")
    public Chat addMessage(
        @PathVariable String chatId,
        @RequestBody Message message
    ) {
        Chat chat = chatRepository.findById(chatId).orElseThrow();
        chat.getMessages().add(message);
        return chatRepository.save(chat);
    }

    @GetMapping
    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }
        
}