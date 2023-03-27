// Demonstrates the use of the @Service annotation

package com.example.demo.service;

import java.util.List;

public interface Customer {

    // Save operation
    Customer saveCustomer(Customer customer);

    // Read operation
    List<Customer> getCustomer();
    // Iterable<com.example.demo.model.Customer> getAllCustomers();

    // Update operation
    Customer updateCustomer(Customer customer);

    // Delete operation
    void deleteCustomer(Customer customer);

    
}
