package com.openclassrooms.chat.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "customers")
@Getter
@Setter
@AllArgsConstructor
public class Customer {

    @Id
    private String id;
    protected String firstName;
    protected String lastName;
    protected String email;

}
