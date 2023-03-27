package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

@Repository // manages database interactions

// the customer repository extends the CrudRepository interface. This interface provides inbuiit methods for saving, deleting, and finding Customer objects.
public interface CustomerRepository extends CrudRepository<Customer, String> {

    com.example.demo.service.Customer save(com.example.demo.service.Customer customer);

}
