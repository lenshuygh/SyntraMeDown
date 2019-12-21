package handmedown.repository.implementation;

import handmedown.model.OccupancyType;
import handmedown.model.RealEstateHandMeDown;

import java.util.Set;
import java.util.stream.Collectors;

public class RealEstateHandMeDownImpl extends HandMeDownRepositoryImpl<RealEstateHandMeDown> {
    Set<RealEstateHandMeDown> getAll(Double minimalSurface) {
        return getAll().stream().filter(r -> r.getSquareMeters() >= minimalSurface).collect(Collectors.toSet());
    }

    Set<RealEstateHandMeDown> getAll(OccupancyType occupancyType) {
        return getAll().stream().filter(r -> r.getOccupancyType().equals(occupancyType)).collect(Collectors.toSet());
    }

    Set<RealEstateHandMeDown> getAll(int zipCode) {
        return getAll().stream().filter(r -> r.getAddress().getZipCode() == zipCode).collect(Collectors.toSet());
    }
}
