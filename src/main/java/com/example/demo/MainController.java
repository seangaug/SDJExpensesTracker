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
    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String email, @RequestParam String username) {
        User n = new User();
        n.setEmail(email);
        n.setUsername(username);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path="/user/{id}")
    public @ResponseBody User getUserById(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new RuntimeException("User not found");
        }
    }

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
    @PostMapping(path="/expense/add")
    public @ResponseBody String addNewExpense(@RequestParam double amount, @RequestParam String description, @RequestParam String category, @RequestParam String status) {
        Expense expense = new Expense();
        expense.setAmount(amount);
        expense.setDescription(description);
        expense.setCategory(category);
        expense.setStatus(status);
        expenseRepository.save(expense);
        return "Saved";
    }

    @GetMapping(path="/expense/all")
    public @ResponseBody Iterable<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @GetMapping(path="/expense/{id}")
    public @ResponseBody Expense getExpenseById(@PathVariable Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            throw new RuntimeException("Expense not found");
        }
    }

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
    @GetMapping(path="/expense/category/{category}")
    public @ResponseBody List<Expense> getExpensesByCategory(@PathVariable String category) {
        return expenseRepository.findByCategory(category);
    }
}




