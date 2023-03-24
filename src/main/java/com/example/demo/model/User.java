package com.example.demo.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

// @Entity is used to show it is a JPA entitiy. Instances of this class will be mapped to the database.
// @Getter and @Setter are Lombok annotations that automatically generate getters and setters for the class.
@Entity
@Getter
@Setter
public class User {

    @Id //makes email the primary key
    private String email;
    private String username;

    // constructor for the user class:
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}