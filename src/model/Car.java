package model;

import strategies.CarBehavior;

public class Car {

    private CarBehavior carBehavior;

    public void setCarBehavior(CarBehavior carBehavior) {
        this.carBehavior = carBehavior;
    }

    public void drive() {
        this.carBehavior.drive();
    }
}
