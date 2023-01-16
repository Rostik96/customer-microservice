package com.rost.microservice.customer.services;

import org.springframework.stereotype.Service;

import com.rost.microservice.customer.models.Customer;
import com.rost.microservice.customer.repositories.CustomerRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer save(Customer saving) {
        return customerRepository.save(saving);
    }
}
