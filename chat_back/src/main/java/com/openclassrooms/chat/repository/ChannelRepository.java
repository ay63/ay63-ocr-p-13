package com.openclassrooms.chat.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.openclassrooms.chat.entity.Channel;

public interface ChannelRepository extends MongoRepository<Channel, Long> {

    Optional<Channel> findById(Long id);
    Channel findByUserId(Long userId);

}
