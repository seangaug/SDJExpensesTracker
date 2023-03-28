package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@SpringBootApplication
public class ExpensesTrackingApp {

	@Autowired
	CustomerRepository customerRepository;

	// Main method. This is the entry point of the application and how the application is started.
	public static void main(String[] args) {
		SpringApplication.run(ExpensesTrackingApp.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		return args -> {
			Customer customer1 = new Customer("John", "John@mail.com");
			customerRepository.save(customer1);
	};
	}
}
