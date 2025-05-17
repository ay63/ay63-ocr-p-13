package com.openclassrooms.chat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.chat.entity.Chat;
import com.openclassrooms.chat.entity.Customer;
import com.openclassrooms.chat.entity.Message;
import com.openclassrooms.chat.repository.ChatRepository;
import com.openclassrooms.chat.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RequestMapping("/chat")
public class ChatController {

    private final ChatRepository chatRepository;
    private final CustomerRepository clientRepository;

    public ChatController(ChatRepository chatRepository, CustomerRepository clientRepository) {
        this.chatRepository = chatRepository;
        this.clientRepository = clientRepository;
    }


    @PostMapping
    public Chat createChat() {
        Customer customer = clientRepository.findByEmail("john.doo@gmail.com").orElse(null);
        if (customer == null) {
            customer = new Customer("john_doe", "John", "Doe", "john.doo@gmail.com");
            clientRepository.save(customer);
        }

        Chat chat = new Chat();
        chat.setCustomer(customer);
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