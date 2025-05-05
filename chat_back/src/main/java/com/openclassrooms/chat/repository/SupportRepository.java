package com.openclassrooms.chat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.openclassrooms.chat.entity.Support;

public interface SupportRepository extends MongoRepository<Support, String> {
 
    
}
