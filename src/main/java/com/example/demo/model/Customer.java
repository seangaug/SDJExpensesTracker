package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

// @Entity is used to show it is a JPA entitiy. Instances of this class will be mapped to the database.
// @Getter and @Setter are Lombok annotations that automatically generate getters and setters for the class.
@Entity
@Getter
@Setter
public class Customer {

    @Id //makes email the primary key
    @Column(name = "email") //defines an email column in the database
    private String email;

    @Column(name = "username") //defines a username column in the database
    private String username;

    // constructor for the user class:
    public Customer(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // default constructor
    public Customer(){
    }
}