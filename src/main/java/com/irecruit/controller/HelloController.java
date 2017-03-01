package com.irecruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irecruit.mongo.repository.CustomerRepository;
import com.irecruit.pojo.Customer;

@RestController
public class HelloController {
	
	@Autowired
	private CustomerRepository repository;
	
    @RequestMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    @RequestMapping("/customers")
    public List<Customer> getCustomer(){
    	//repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
		
		return  repository.findAll();
    }

}