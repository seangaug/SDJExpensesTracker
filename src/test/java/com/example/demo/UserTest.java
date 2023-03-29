package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class UserTest { // junit added as dependency in pom.xml   

    // User's email is set correctly:
    @Test
    void testSetEmail() {
        User user = new User();
        user.setEmail("test@example.com");
        assertEquals("test@example.com", user.getEmail());
    }
    
    // User's username is set correctly:
    @Test
    void testSetUsername() {
        User user = new User();
        user.setUsername("testuser");
        assertEquals("testuser", user.getUsername());
    }

    // User's ID is set correctly:
    @Test
    void testSetId() {
        User user = new User();
        user.setId(12345L);
        assertEquals(12345L, user.getId());
    }

    // Constructor sets email and username correctly:
    @Test  
    void testConstructor() {
        User user3 = new User("JohnSmith@mail.com","JohnSmith");
        assertEquals("JohnSmith", user3.getUsername());
        assertEquals("JohnSmith@mail.com", user3.getEmail());
    }

    // getExpenses() returns a list of expenses. Requires Expense class to be complete.
    @Test
    void testGetExpenses() {
        User user = new User();
        Expense expense1 = new Expense();
        Expense expense2 = new Expense();
        List<Expense> expenses = new ArrayList<>();
        expenses.add(expense1);
        expenses.add(expense2);
        user.setExpenses(expenses);
        assertEquals(expenses, user.getExpenses());
    }
}
