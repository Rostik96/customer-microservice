package com.rost.microservice.customer.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rost.microservice.customer.models.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

}
