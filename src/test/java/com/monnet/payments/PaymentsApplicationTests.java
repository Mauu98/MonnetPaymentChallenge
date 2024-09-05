package com.monnet.payments;

import factory.CarBehaviorFactory;
import model.Car;
import model.DaysEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import strategies.CarBehavior;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PaymentsApplicationTests {

	@Mock
	private CarBehaviorFactory carBehaviorFactory = new CarBehaviorFactory();

	@Mock
	private Car car;

	@InjectMocks
	private PaymentsApplicationTests paymentsApplicationTests;

	@Test
	void testInvalidDay() {
		when(carBehaviorFactory.getBehaviorForDay(DaysEnum.SABADO)).thenThrow(new IllegalArgumentException("No behavior defined for SABADO"));

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			paymentsApplicationTests.car.setCarBehavior(paymentsApplicationTests.carBehaviorFactory.getBehaviorForDay(DaysEnum.SABADO));
		});

		assertEquals("No behavior defined for SABADO", exception.getMessage());
	}

	@ParameterizedTest
	@ValueSource(strings = {"LUNES", "MARTES", "MIERCOLES", "JUEVES","VIERNES"})
	public void testBehaviorForDay(String day) {
		CarBehaviorFactory carBehaviorFactory = new CarBehaviorFactory();
		Car car = new Car();

		CarBehavior behavior = carBehaviorFactory.getBehaviorForDay(DaysEnum.valueOf(day));
		car.setCarBehavior(behavior);

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		car.drive();

		System.setOut(System.out);

		assertEquals(expectedMessages.get(DaysEnum.valueOf(day)), outContent.toString().trim());
	}

	private static final Map<DaysEnum, String> expectedMessages = Map.of(
			DaysEnum.LUNES, "Uso de dia LUNES para el trabajo \uD83D\uDCBC",
			DaysEnum.MARTES, "Uso de dia MARTES para correr en circuito \uD83D\uDE97",
			DaysEnum.MIERCOLES, "Uso de dia MIERCOLES para Offroad ⛰",
			DaysEnum.JUEVES, "Uso de dia JUEVES para Offroad ⛰",
			DaysEnum.VIERNES, "Uso de dia VIERNES para ser un agente secreto \uD83D\uDD75\uFE0F\u200D♂\uFE0F"
	);
}
