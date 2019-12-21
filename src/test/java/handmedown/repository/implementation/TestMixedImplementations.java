package handmedown.repository.implementation;

import handmedown.repository.helpers.CarHandMeDownHelper;
import handmedown.repository.helpers.ClothingHandMeDownHelper;
import handmedown.repository.helpers.RealEstateHandMeDownHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMixedImplementations {
    CarHandMeDownImpl carRepo = new CarHandMeDownImpl();
    ClothingHandMeDownImpl clothingRepo = new ClothingHandMeDownImpl();
    RealEstateHandMeDownImpl realEstateRepo = new RealEstateHandMeDownImpl();

    @Test
    void mixedReposTests(){
        carRepo.add(CarHandMeDownHelper.createCarHandMeDown());
        carRepo.add(CarHandMeDownHelper.createCarHandMeDown2());
        clothingRepo.add(ClothingHandMeDownHelper.createClothingHandMeDown());
        clothingRepo.add(ClothingHandMeDownHelper.createClothingHandMeDown2());
        realEstateRepo.add(RealEstateHandMeDownHelper.createRealEstateHandMeDown());
        realEstateRepo.add(RealEstateHandMeDownHelper.createRealEstateHandMeDown2());

        //check sizes
        assertEquals(2,carRepo.getAll().size());
        assertEquals(2,clothingRepo.getAll().size());
        assertEquals(2,realEstateRepo.getAll().size());
    }
}
