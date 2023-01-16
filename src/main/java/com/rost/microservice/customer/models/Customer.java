package com.rost.microservice.customer.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Document(collection = "customer")
@Data
public class Customer implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("orders")
    private final Set<Order> orders = new HashSet<>();

    public Customer addOrder(Order order) {
        orders.add(order);
        return this;
    }
}