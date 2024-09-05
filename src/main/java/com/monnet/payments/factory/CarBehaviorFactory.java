package com.monnet.payments.factory;

import com.monnet.payments.model.DaysEnum;
import com.monnet.payments.strategies.CarBehavior;
import com.monnet.payments.strategies.FridayCarBehaviorStrategy;
import com.monnet.payments.strategies.MondayCarBehaviorStrategy;
import com.monnet.payments.strategies.ThursdayCarBehaviorStrategy;
import com.monnet.payments.strategies.TuesdayCarBehaviorStrategy;
import com.monnet.payments.strategies.WednesdayCarBehaviorStrategy;

import java.util.Map;

public class CarBehaviorFactory {

    Map<DaysEnum, CarBehavior> carBehaviorMap = Map.of(
            DaysEnum.LUNES, new MondayCarBehaviorStrategy(),
            DaysEnum.MARTES, new TuesdayCarBehaviorStrategy(),
            DaysEnum.MIERCOLES, new WednesdayCarBehaviorStrategy(),
            DaysEnum.JUEVES, new ThursdayCarBehaviorStrategy(),
            DaysEnum.VIERNES, new FridayCarBehaviorStrategy()
    );

    public CarBehavior getBehaviorForDay(DaysEnum day) {
        if (day == null || carBehaviorMap.get(day) == null) {
            throw new IllegalArgumentException("No behavior defined for " + day);
        }

        return carBehaviorMap.get(day);
    }
}
