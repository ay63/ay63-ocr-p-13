package com.openclassrooms.chat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.openclassrooms.chat.entity.Client;
import java.util.Optional;

public interface ClientRepository extends MongoRepository<Client, String>{

    Optional<Client> findByUsername(String username);
    Optional<Client> findByEmail(String email);
    Optional<Client> findByFirstName(String firstName);
    Optional<Client> findByLastName(String lastName);
}
