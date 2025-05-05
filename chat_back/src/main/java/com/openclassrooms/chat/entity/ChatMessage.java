package com.openclassrooms.chat.entity;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "messages")
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {

    private String content; 
    private String sender;
    private String receiver;
    private Date date;
}
