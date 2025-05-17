package com.openclassrooms.chat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.openclassrooms.chat.entity.Customer;
import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String>{
    Optional<Customer> findByEmail(String email);
}
