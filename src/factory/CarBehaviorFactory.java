package factory;

import model.DaysEnum;
import strategies.CarBehavior;
import strategies.FridayCarBehaviorStrategy;
import strategies.MondayCarBehaviorStrategy;
import strategies.ThursdayCarBehaviorStrategy;
import strategies.TuesdayCarBehaviorStrategy;
import strategies.WednesdayCarBehaviorStrategy;

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
