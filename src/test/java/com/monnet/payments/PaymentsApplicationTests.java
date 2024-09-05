package com.monnet.payments;


import factory.CarBehaviorFactory;
import model.Car;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PaymentsApplicationTests {

	@Mock
	private CarBehaviorFactory carBehaviorFactory;

	@Mock
	private Car car;

	private final static String SATURDAY_DAY = "SABADO";

	//TODO
}
