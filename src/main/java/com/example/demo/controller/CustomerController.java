package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
    
    @Autowired private CustomerService customer;

    // save operation
    @PostMapping("/customers")
    public com.example.demo.model.Customer saveCustomer(@RequestBody CustomerService customer) { //Request body is the JSON object that is sent to the server
        return customer.saveCustomer(customer);
    }
    
    // read operation
    @GetMapping("/customers")
    public List<CustomerService> getCustomers() {
        return customer.getCustomer();
    }

    // update operation
    @PostMapping("/customers")
    public com.example.demo.model.Customer updateCustomer(@RequestBody CustomerService customer) {
        return customer.updateCustomer(customer);
    }

    // delete operation
    @PostMapping("/customers")
    public void deleteCustomer(@RequestBody CustomerService customer) {
        customer.deleteCustomer(customer);
    }
}
