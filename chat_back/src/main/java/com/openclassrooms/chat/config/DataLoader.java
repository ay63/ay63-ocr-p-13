package com.openclassrooms.chat.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.openclassrooms.chat.entity.Client;
import com.openclassrooms.chat.repository.ChatRepository;
import com.openclassrooms.chat.repository.ClientRepository;

@Component
public class DataLoader implements ApplicationRunner {

	private ClientRepository clientRepository;
	private ChatRepository chatRepository;

    public DataLoader(ClientRepository clientRepository, ChatRepository chatRepository) {
        this.clientRepository = clientRepository;
        this.chatRepository = chatRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        
        System.out.println("Deleting all clients and chats");
		clientRepository.deleteAll();
		chatRepository.deleteAll();
        System.out.println("End delete all clients and chats");

		System.out.println("Inserting clients ");
		Client client = new Client("john_doe", "John", "Doe", "john.doo@gmail.com","1234");
		clientRepository.save(client);	
		System.out.println("End insert clients");
    }
}
