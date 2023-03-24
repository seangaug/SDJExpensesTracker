package com.example.demo.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

// @Entity is a JPA annotation that tells Spring that this class is an entity that should be persisted in the database.
// @Getter and @Setter are Lombok annotations that automatically generate getters and setters for the class.
@Entity
@Getter
@Setter
public class User {

    // Properties of the user class:
    private String username;
    private String email;

    // constructor for the user class:
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}