package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Expense {

    @Id //Id will be Primary Key in database and will be randomly generated
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private String description;
    private String category;
    private Boolean isPaid;

    // Constructor for Expense class:
    public Expense(double amount, String description, String category, Boolean isPaid, User user) {
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.isPaid = isPaid;
        this.user = user;
    }    

    @ManyToOne //an expense belongs to 1 user, 1 user can have many expenses
    @JoinColumn(name = "user_email") //this foreign key in Expense table matches PK in User table to establish connection
    private User user;
}