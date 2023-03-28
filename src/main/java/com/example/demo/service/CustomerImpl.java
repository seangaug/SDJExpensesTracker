// package com.example.demo.service;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.repository.CustomerRepository;

// @Service
// public class CustomerImpl implements Customer {

//     @Autowired // injects the CustomerRepository into the CustomerImpl class
//     CustomerRepository customerRepository;

//     // save/post operation
//     @Override
//     public Customer saveCustomer(Customer customer) {
//         return customerRepository.save(customer);
//     }

//     // // read operation. Get all customers. Won't currently allow List as a return type.
//     // public Iterable<com.example.demo.model.Customer> getAllCustomers() {
//     //     return customerRepository.findAll();
//     // }

//     // read operation - not yet coded properly
//     // @Override
//     // public Customer getCustomer(String email) {
//     //     // TODO Auto-generated method stub
//     //     throw new UnsupportedOperationException("Unimplemented method 'getCustomer'");
//     // }

//     // update operation - not yet coded properly
//     @Override
//     public Customer updateCustomer(Customer customer) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'updateCustomer'");
//     }

//     // delete operation
//     @Override
//     public void deleteCustomer(Customer customer) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'deleteCustomer'");
//     }

//     // read operation
//     @Override
//     public List<Customer> getCustomer() {
//         List<Customer> customers = new ArrayList<>();
//         customerRepository.findAll().forEach(arg0 -> customers.add((Customer) arg0));
//         return customers;
//     }
// }

