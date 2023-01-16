package com.rost.microservice.customer.models;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Order {
    private static final long serialVersionUID = 1L;

    @Id
    @NotBlank
    private String id;

    @NotBlank
    private String customerId;

    @Override
    public String toString() {
        return String.format("Owner ID: %s", customerId);
    }
}