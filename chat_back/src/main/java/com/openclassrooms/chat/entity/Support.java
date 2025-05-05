package com.openclassrooms.chat.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "supports")
@Getter
@Setter
public class Support extends User {

    @Id
    private String id;

    public Support(String username, String firstName, String lastName, String email, String password) {
        super(username, firstName, lastName, email, password);
    }

    public String[] getRoles() {
        return new String[]{"ROLE_SUPPORT"};
    }
}
