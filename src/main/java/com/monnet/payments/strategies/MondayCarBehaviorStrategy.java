package com.monnet.payments.strategies;

public class MondayCarBehaviorStrategy implements CarBehavior {

    @Override
    public void drive() {
        System.out.println("Uso de dia LUNES para el trabajo \uD83D\uDCBC");
    }
}
