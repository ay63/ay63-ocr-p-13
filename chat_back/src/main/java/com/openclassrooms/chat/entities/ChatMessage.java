package com.openclassrooms.chat.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    private String content; 
    private String sender;
    private String receiver;
    private Date date;
}
