import factory.CarBehaviorFactory;
import model.Car;
import model.DaysEnum;
import strategies.CarBehavior;

public class Main {
    public static void main(String[] args) {

        CarBehaviorFactory carBehaviorFactory = new CarBehaviorFactory();
        Car car = new Car();

        for(DaysEnum daysEnum : DaysEnum.values()){
            CarBehavior behavior = carBehaviorFactory.getBehaviorForDay(daysEnum); //Aca itero para mostrar todos los comportamientos dependiendo del dia
            car.setCarBehavior(behavior);
            car.drive();
        }
    }
}