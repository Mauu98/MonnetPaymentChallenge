package decorator;

import model.Car;
import strategies.CarBehavior;

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
