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
    @Column(name = "id") //defines an id column in the database
    private Integer id;

    @Column(name = "amount")
    private float amount;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "isPaid")
    private Boolean isPaid;

    // Constructor for Expense class:
    public Expense(Float amount, String description, String category, Boolean isPaid, Customer customer) {
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.isPaid = isPaid;
        this.customer = customer;
    }    

    @ManyToOne //an expense belongs to 1 user, 1 user can have many expenses
    @JoinColumn(name = "user_email") //this foreign key in Expense table matches PK in User table to establish connection
    private Customer customer;

    // Insert relationship to catagory calss here

    
}