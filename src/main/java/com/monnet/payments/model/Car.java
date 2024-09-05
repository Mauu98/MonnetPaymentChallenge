package com.monnet.payments.model;

import lombok.Data;
import com.monnet.payments.strategies.CarBehavior;

@Data
public class Car {

    private CarBehavior carBehavior;

    public void drive() {
        this.carBehavior.drive();
    }
}
