package handmedown.repository.implementation;

import handmedown.model.CarHandMeDown;
import handmedown.model.Color;
import handmedown.model.FuelType;

import java.util.Set;
import java.util.stream.Collectors;

public class CarHandMeDownImpl extends HandMeDownRepositoryImpl<CarHandMeDown> {
    Set<CarHandMeDown> getAll(Color color){
        return getAll().stream().filter(c -> c.getColor().equals(color)).collect(Collectors.toSet());
    }

    Set<CarHandMeDown> getAll(FuelType fuelType){
        return getAll().stream().filter(c -> c.getFuelType().equals(fuelType)).collect(Collectors.toSet());
    }

    Set<CarHandMeDown> getAll(int maxKilometersDriven){
        return getAll().stream().filter(c -> c.getKilometersDriven() <= maxKilometersDriven).collect(Collectors.toSet());
    }
}
