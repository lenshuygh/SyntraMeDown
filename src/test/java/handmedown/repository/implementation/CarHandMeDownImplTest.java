package handmedown.repository.implementation;

import handmedown.model.CarHandMeDown;
import handmedown.model.Color;
import handmedown.model.FuelType;
import handmedown.model.HandMeDownStatus;
import handmedown.repository.helpers.CarHandMeDownHelper;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class CarHandMeDownImplTest {
    CarHandMeDownImpl repository;

    @Test
    void getAll() {
        repositoryHelperCreateFilled();

        int foundCarHandMeDowns = repository.getAll().size();

        assertEquals(2,foundCarHandMeDowns);
    }

    @Test
    void getAllBySearchTerm() {
        repositoryHelperCreateFilled();
        CarHandMeDown carHandMeDownWithSkodaBrand = CarHandMeDownHelper.createCarHandMeDown2();
        CarHandMeDown carHandMeDownWithVolkswagenBrand = CarHandMeDownHelper.createCarHandMeDown();

        boolean foudTheSkoda = repository.getAll("sKODA").contains(carHandMeDownWithSkodaBrand);
        boolean foundTheVolkswagen = repository.getAll("SKODA").contains(carHandMeDownWithVolkswagenBrand);

        assertTrue(foudTheSkoda);
        assertFalse(foundTheVolkswagen);
    }

    @Test
    void testGetAllByColor() {
        repositoryHelperCreateFilled();
        CarHandMeDown theBlackCar = CarHandMeDownHelper.createCarHandMeDown();
        CarHandMeDown theGreyCar = CarHandMeDownHelper.createCarHandMeDown2();

        boolean foundTheGreyCar = repository.getAll(Color.GREY).contains(theGreyCar);
        boolean foundTheBlackCar = repository.getAll(Color.GREY).contains(theBlackCar);

        assertTrue(foundTheGreyCar);
        assertFalse(foundTheBlackCar);
    }

    @Test
    void getAllByFuelType(){
        repositoryHelperCreateFilled();

        int allCarsThatUseGasoline = repository.getAll(FuelType.GASOLINE).size();
        int allCarsThatAreElectric = repository.getAll(FuelType.ELECTRIC).size();

        assertEquals(2,allCarsThatUseGasoline);
        assertEquals(0,allCarsThatAreElectric);
    }


    @Test
    void getAllByMaxKilometers(){
        repositoryHelperCreateFilled();
        CarHandMeDown carWith500KmDriven = CarHandMeDownHelper.createCarHandMeDown2();
        CarHandMeDown carWith65000KmDriven = CarHandMeDownHelper.createCarHandMeDown();

        boolean lowKilometerCarFound = repository.getAll(501).contains(carWith500KmDriven);
        boolean highKilometerCarFound = repository.getAll(501).contains(carWith65000KmDriven);

        assertTrue(lowKilometerCarFound);
        assertFalse(highKilometerCarFound);
    }

    @Test
    void CannotGetAnyCarsThatHaveZeroKilometersDriven(){
        repositoryHelperCreateFilled();

        int carsWithLessThan1KilometersDriven = repository.getAll(1).size();

        assertEquals(0,carsWithLessThan1KilometersDriven);
    }

    @Test
    void canGetCarsOnlyIfAvailable(){
        repositoryHelperCreateFilled();
        while(repository.getAll().iterator().hasNext()){
            repository.setStatus(repository.getAll().iterator().next(),HandMeDownStatus.UNAVAILABLE);
        }

        int allCarsThatAreAvailable = repository.getAll().size();

        assertEquals(0,allCarsThatAreAvailable);
    }

    private void repositoryHelperCreateEmpty() {
        repository = new CarHandMeDownImpl();
    }

    private void repositoryHelperCreateFilled(){
        repositoryHelperCreateEmpty();
        repository.add(CarHandMeDownHelper.createCarHandMeDown());
        repository.add(CarHandMeDownHelper.createCarHandMeDown2());
    }
}