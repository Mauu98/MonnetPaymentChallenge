package decorator;

import strategies.CarBehavior;

public class CamouflageCarDecorator extends CarDecorator {

    public CamouflageCarDecorator(CarBehavior decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public void drive() {
        super.drive();
        activateCamouflage();
    }

    public void activateCamouflage() {
        System.out.println("Camuflaje activado! 🕵️‍♂️");
    }
}
