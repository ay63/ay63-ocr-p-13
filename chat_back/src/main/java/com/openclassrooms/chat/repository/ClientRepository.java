package com.openclassrooms.chat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.openclassrooms.chat.entity.Client;


public interface ClientRepository extends MongoRepository<Client, String>{

    Client findByUsername(String username);
    Client findByEmail(String email);
    Client findByFirstName(String firstName);
    Client findByLastName(String lastName);
}
