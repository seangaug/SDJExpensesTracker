package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@Repository // manages database interactions

// the customer repository extends the CrudRepository interface. This interface provides inbuiit methods for saving, deleting, and finding Customer objects.
public interface CustomerRepository extends CrudRepository<Customer, String> {

    Customer save(CustomerService customer); //String is primary key of Customer class
}
