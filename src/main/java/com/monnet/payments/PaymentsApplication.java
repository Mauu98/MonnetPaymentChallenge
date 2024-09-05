package com.monnet.payments;

import decorator.CamouflageCarDecorator;
import decorator.FireGunsCarDecorator;
import factory.CarBehaviorFactory;
import model.Car;
import model.DaysEnum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import strategies.CarBehavior;

import java.util.Arrays;

@SpringBootApplication
public class PaymentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentsApplication.class, args);
		runDemo();
	}

	public static void runDemo() {
		CarBehaviorFactory carBehaviorFactory = new CarBehaviorFactory();

		Arrays.stream(DaysEnum.values())
				.forEach(drivingDay -> { //Aca itero para mostrar todos los comportamientos dependiendo del dia
					Car car = new Car();
					CarBehavior behavior = carBehaviorFactory.getBehaviorForDay(drivingDay);
					car.setCarBehavior(behavior);

					if (drivingDay == DaysEnum.VIERNES) {
						CarBehavior decoratedBehavior = new CamouflageCarDecorator(new FireGunsCarDecorator(behavior)); //Aplica el decorador de armas de fuego y camuflaje
						car.setCarBehavior(decoratedBehavior);
					}

					car.drive();
				});
	}
}
