import decorator.CamouflageCarDecorator;
import decorator.FireGunsCarDecorator;
import factory.CarBehaviorFactory;
import model.Car;
import model.DaysEnum;
import strategies.CarBehavior;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        CarBehaviorFactory carBehaviorFactory = new CarBehaviorFactory();

        Arrays.stream(DaysEnum.values())
                .forEach(day -> { //Aca itero para mostrar todos los comportamientos dependiendo del dia
                    Car car = new Car();
                    CarBehavior behavior = carBehaviorFactory.getBehaviorForDay(day);
                    car.setCarBehavior(behavior);

                    if (day == DaysEnum.VIERNES) {
                        CarBehavior decoratedBehavior = new CamouflageCarDecorator(new FireGunsCarDecorator(behavior));
                        car.setCarBehavior(decoratedBehavior);
                    }

                    car.drive();
                });
    }
}