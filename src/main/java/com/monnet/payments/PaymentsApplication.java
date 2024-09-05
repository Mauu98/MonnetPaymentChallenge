package com.monnet.payments;

import com.monnet.payments.decorator.CamouflageCarDecorator;
import com.monnet.payments.decorator.FireGunsCarDecorator;
import com.monnet.payments.factory.CarBehaviorFactory;
import com.monnet.payments.model.Car;
import com.monnet.payments.model.DaysEnum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.monnet.payments.strategies.CarBehavior;

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
