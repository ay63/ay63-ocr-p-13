package com.openclassrooms.chat.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.openclassrooms.chat.entity.Client;
import com.openclassrooms.chat.entity.Support;
import com.openclassrooms.chat.repository.ChannelRepository;
import com.openclassrooms.chat.repository.ClientRepository;
import com.openclassrooms.chat.repository.SupportRepository;

@Component
public class DataLoader implements ApplicationRunner {

	private ClientRepository clientRepository;
	private ChannelRepository channelRepository;
	private SupportRepository supportRepository;

    public DataLoader(ClientRepository clientRepository, ChannelRepository channelRepository, SupportRepository supportRepository) {
        this.clientRepository = clientRepository;
        this.channelRepository = channelRepository;
        this.supportRepository = supportRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        
        System.out.println("Deleting all clients and supports");
		clientRepository.deleteAll();
		channelRepository.deleteAll();
		supportRepository.deleteAll();
        System.out.println("End delete all clients and supports");

		System.out.println("Inserting clients and supports");
		Client client = new Client("john_doe", "John", "Doe", "john.doo@gmail.com","1234");
		Support support = new Support("jane_doe", "Jane", "Doe", "jane_doe@gmail.com","1234");

		clientRepository.save(client);	
		supportRepository.save(support);
		
		System.out.println("End insert clients and supports");
    }
}
