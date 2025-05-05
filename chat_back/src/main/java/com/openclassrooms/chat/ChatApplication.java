package com.openclassrooms.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.openclassrooms.chat.entity.Client;
import com.openclassrooms.chat.entity.Support;
import com.openclassrooms.chat.repository.ChannelRepository;
import com.openclassrooms.chat.repository.ClientRepository;
import com.openclassrooms.chat.repository.SupportRepository;

@SpringBootApplication
public class ChatApplication implements CommandLineRunner {

	@Autowired 
	private ClientRepository clientRepository;

	@Autowired
	private ChannelRepository channelRepository;

	@Autowired
	private SupportRepository supportRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {

		clientRepository.deleteAll();
		channelRepository.deleteAll();
		supportRepository.deleteAll();

		System.out.println("Inserting clients and supports");
		Client client = new Client("john_doe", "John", "Doe", "john.doo@gmail.com","1234");
		Support support = new Support("jane_doe", "Jane", "Doe", "jane_doe@gmail.com","1234");
		Client client2 = new Client("alex_doe", "Alex", "Doe", "alex.doe@gmail.com"	,"1234");

		clientRepository.save(client);	
		clientRepository.save(client2);
		supportRepository.save(support);
		System.out.println("Client: " + client.getId());
		
		System.out.println("End insert clients and supports");
	}
}
