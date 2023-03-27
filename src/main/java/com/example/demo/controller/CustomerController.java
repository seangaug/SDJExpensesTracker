package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.Customer;

@RestController
public class CustomerController {
    
    @Autowired private Customer customer;

    // save operation
    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customer.saveCustomer(customer);
    }
    
    // read operation
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customer.getCustomer();
    }

}
