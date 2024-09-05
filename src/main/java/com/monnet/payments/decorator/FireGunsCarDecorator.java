package com.monnet.payments.decorator;

import com.monnet.payments.strategies.CarBehavior;

public class FireGunsCarDecorator extends CarDecorator {

    public FireGunsCarDecorator(CarBehavior decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public void drive() {
        super.drive();
        activateFireGuns();
    }

    private void activateFireGuns() {
        System.out.println("Armas de fuego activadas! 🔫");
    }
}
