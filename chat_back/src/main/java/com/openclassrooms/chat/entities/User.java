package com.openclassrooms.chat.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {

    private String username;
    private String email;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String roles[]; 

}
