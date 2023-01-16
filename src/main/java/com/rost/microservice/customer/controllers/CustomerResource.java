package com.rost.microservice.customer.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.rost.microservice.customer.models.Customer;
import com.rost.microservice.customer.services.CustomerService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class CustomerResource {
    private static final String ENTITY_NAME = "customer";

    @Value("${spring.application.name}")
    private String applicationName;

    private final CustomerService customerService;

    @Autowired
    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) throws URISyntaxException {
        log.debug("REST request to save Customer: {}", customer);
        if (customer.getId() != null)
            throw new ResponseStatusException(HttpStatus.CONFLICT, "A new customer cannot already have an ID");

        final var result = customerService.save(customer);

        HttpHeaders headers = new HttpHeaders();
        String message = String.format("A new %s is created with identifier %s", ENTITY_NAME, customer.getId());
        headers.add("X-" + applicationName + "-alert", message);
        headers.add("X-" + applicationName + "-params", customer.getId());
        return ResponseEntity.created(new URI("/api/customers/" + result.getId())).headers(headers).body(result);
    }
}
