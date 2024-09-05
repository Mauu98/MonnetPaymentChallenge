package model;

import lombok.Data;
import strategies.CarBehavior;

@Data
public class Car {

    private CarBehavior carBehavior;

    public void drive() {
        this.carBehavior.drive();
    }
}
