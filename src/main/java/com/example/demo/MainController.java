package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    //User methods
    // method for creating a new user
    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String email, @RequestParam String username) {
        User n = new User();
        n.setEmail(email);
        n.setUsername(username);
        userRepository.save(n);
        return "Saved";
    }

    //method for retrieving all users
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }


    //method for retrieving user by ID
    @GetMapping(path="/user/{id}")
    public @ResponseBody User getUserById(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new RuntimeException("User not found");
        }
    }

    //method for updating a user
    @PostMapping(path="/update")
    public @ResponseBody String updateUser(@RequestParam Long id, @RequestParam String email, @RequestParam String username) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setEmail(email);
            user.setUsername(username);
            userRepository.save(user);
            return "Updated";
        } else {
            return "User not found";
        }
    }

    //method for deleting a user (just need ID)
    @PostMapping(path="/delete")
    public @ResponseBody String deleteUser(@RequestParam Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.delete(optionalUser.get());
            return "Deleted";
        } else {
            return "User not found";
        }
    }

    //Expense methods
//    @PostMapping(path="/expense/add")
//    public @ResponseBody String addNewExpense(@RequestParam double amount, @RequestParam String description, @RequestParam String category, @RequestParam String status, @RequestParam String userEmail) {
//        Expense expense = new Expense();
//        expense.setAmount(amount);
//        expense.setDescription(description);
//        expense.setCategory(category);
//        expense.setStatus(status);
//
//        User user = userRepository.findByEmail(userEmail);
//        if (user == null) {
//            // handle the case when the user with the specified email is not found
//        } else {
//            user.addExpense(expense); // associate the expense with the user
//            userRepository.save(user); // save the user to persist the expense association
//        }
//
//        return "Saved";
//    }


    //method for retrieving all expenses
    @GetMapping(path="/expense/all")
    public @ResponseBody Iterable<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    //method for retrieving expenses by ID
    @GetMapping(path="/expense/{id}")
    public @ResponseBody Expense getExpenseById(@PathVariable Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            throw new RuntimeException("Expense not found");
        }
    }

    //method for updating an expense
    @PostMapping(path="/expense/update")
    public @ResponseBody String updateExpense(@RequestParam Long id, @RequestParam double amount, @RequestParam String description, @RequestParam String category, @RequestParam String status) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            Expense expense = optionalExpense.get();
            expense.setAmount(amount);
            expense.setDescription(description);
            expense.setCategory(category);
            expense.setStatus(status);
            expenseRepository.save(expense);
            return "Updated";
        } else {
            return "Expense not found";
        }
    }

    //method for deleting an expense
    @PostMapping(path="/expense/delete")
    public @ResponseBody String deleteExpense(@RequestParam Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            expenseRepository.delete(optionalExpense.get());
            return "Deleted";
        } else {
            return "Expense not found";
        }
    }
    //method for retrieving expenses by category
    @GetMapping(path="/expense/category/{category}")
    public @ResponseBody List<Expense> getExpensesByCategory(@PathVariable String category) {
        return expenseRepository.findByCategory(category);
    }

//    @GetMapping(path="/user/{email}/expenses")
//    public @ResponseBody List<Expense> getExpensesByUserEmail(@PathVariable String email) {
//        return expenseRepository.findByUserEmail(email);
//    }

}




