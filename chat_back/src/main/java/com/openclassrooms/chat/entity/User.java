package com.openclassrooms.chat.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class User {
    protected String username;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    protected String roles[]; 

    public User() {
    }
 
    public User(String username, String firstName, String lastName, String email, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
