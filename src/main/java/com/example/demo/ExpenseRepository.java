package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
    List<Expense> findByCategory(String category);
}

