package com.monnet.payments.decorator;

import com.monnet.payments.strategies.CarBehavior;

public class CamouflageCarDecorator extends CarDecorator {

    public CamouflageCarDecorator(CarBehavior decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public void drive() {
        super.drive();
        activateCamouflage();
    }

    private void activateCamouflage() {
        System.out.println("Camuflaje activado! 🕵️‍♂️");
    }
}
