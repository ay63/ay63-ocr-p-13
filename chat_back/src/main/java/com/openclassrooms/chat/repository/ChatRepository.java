package com.openclassrooms.chat.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.openclassrooms.chat.entity.Chat;

public interface ChatRepository extends MongoRepository<Chat, String> {

    Optional<Chat> findById(String id);

}
