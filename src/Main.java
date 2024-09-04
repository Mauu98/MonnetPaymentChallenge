import factory.CarBehaviorFactory;
import model.Car;
import model.DaysEnum;
import strategies.CarBehavior;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        CarBehaviorFactory carBehaviorFactory = new CarBehaviorFactory();
        Car car = new Car();

        Arrays.stream(DaysEnum.values())
                .forEach(day -> { //Aca itero para mostrar todos los comportamientos dependiendo del dia
                    CarBehavior behavior = carBehaviorFactory.getBehaviorForDay(day);
                    car.setCarBehavior(behavior);
                    car.drive();
                });
    }
}