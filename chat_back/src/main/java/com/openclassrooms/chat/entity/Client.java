package com.openclassrooms.chat.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "clients")
@Getter
@Setter
public class Client extends User {

    @Id
    private String id;

    public Client(String username, String firstName, String lastName, String email, String password) {
        super(username, firstName, lastName, email, password);
    }

    public String[] getRoles() {
        return new String[]{"ROLE_CLIENT"};
    }
}
