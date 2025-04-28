package com.openclassrooms.chat.entities;

import jakarta.persistence.Entity;


@Entity
public class Support extends User {

    public String[] getRoles() {
        return new String[]{"ROLE_SUPPORT"};
    }
}
