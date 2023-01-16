package com.rost.microservice.customer.domain;

import com.rost.microservice.order.enums.HealthStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Health {
    private HealthStatus status;
}
