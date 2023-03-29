package com.example.demo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String username;

    //Linking to Expense
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Expense> expenses = new ArrayList<>();

//    public void addExpense(Expense expense) {
//        expenses.add(expense);
//        expense.setUser(this);
//    }
//
//    public void removeExpense(Expense expense) {
//        expenses.remove(expense);
//        expense.setUser(null);
//    }
//
//    public List<Expense> getExpenses() {
//        return expenses;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}






