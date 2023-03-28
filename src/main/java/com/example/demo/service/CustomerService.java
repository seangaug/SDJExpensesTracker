package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    
    //get customer records:
    public List<com.example.demo.model.Customer> getCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }    

    //save customer record:
    public com.example.demo.model.Customer saveCustomer(CustomerService customer) {
        return customerRepository.save(customer);
    }

    //delete customer record:
    public void deleteCustomer(com.example.demo.model.Customer customer) {
        customerRepository.delete(customer);
    }

    //update customer record:
    public com.example.demo.model.Customer updateCustomer(com.example.demo.model.Customer customer) {
        return customerRepository.save(customer);
    }

    public List<CustomerService> getCustomer() {
        return null;
    }

    public Customer updateCustomer(CustomerService customer) {
        return null;
    }

    public void deleteCustomer(CustomerService customer) {
    }
}
