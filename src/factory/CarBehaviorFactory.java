package factory;

import model.DaysEnum;
import strategies.CarBehavior;
import strategies.FridayCarBehaviorStrategy;
import strategies.MondayCarBehaviorStrategy;
import strategies.TuesdayCarBehaviorStrategy;
import strategies.WednesdayAndTuesdayCarBehaviorStrategy;

import java.util.Map;

public class CarBehaviorFactory {

    Map<DaysEnum, CarBehavior> carBehaviorMap = Map.of(
            DaysEnum.LUNES, new MondayCarBehaviorStrategy(),
            DaysEnum.MARTES, new TuesdayCarBehaviorStrategy(),
            DaysEnum.MIERCOLES_JUEVES, new WednesdayAndTuesdayCarBehaviorStrategy(),
            DaysEnum.VIERNES, new FridayCarBehaviorStrategy()
    );

    public CarBehavior getBehaviorForDay(DaysEnum day) {
        if (day == null || carBehaviorMap.get(day) == null) {
            throw new IllegalArgumentException("No behavior defined for " + day);
        }

        return carBehaviorMap.get(day);
    }
}
