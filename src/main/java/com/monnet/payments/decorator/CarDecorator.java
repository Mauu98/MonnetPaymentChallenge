package com.monnet.payments.decorator;

import com.monnet.payments.strategies.CarBehavior;

public abstract class CarDecorator implements CarBehavior {

    protected CarBehavior carBehavior;

    public CarDecorator(CarBehavior carBehavior){
        this.carBehavior = carBehavior;
    }

    @Override
    public void drive() {
        this.carBehavior.drive();
    }
}
