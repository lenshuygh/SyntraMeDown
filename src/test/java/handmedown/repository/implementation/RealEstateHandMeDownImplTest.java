package handmedown.repository.implementation;

import handmedown.model.HandMeDownStatus;
import handmedown.model.OccupancyType;
import handmedown.model.RealEstateHandMeDown;
import handmedown.repository.helpers.RealEstateHandMeDownHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RealEstateHandMeDownImplTest {
    RealEstateHandMeDownImpl repository;

    @Test
    void getAll() {
        repositoryHelperCreateFilled();

        int numberOfAllRealEstateHandMeDowns = repository.getAll().size();

        assertEquals(2,numberOfAllRealEstateHandMeDowns);
    }

    @Test
    void testGetAllBySearchTermInTitle() {
        repositoryHelperCreateFilled();
        RealEstateHandMeDown realEstateHandMeDownWithSyntraInTitle = RealEstateHandMeDownHelper.createRealEstateHandMeDown();

        boolean foundSyntraRealEstate = repository.getAll("syntra").contains(realEstateHandMeDownWithSyntraInTitle);

        assertTrue(foundSyntraRealEstate);
    }

    @Test
    void getAllBySearchTermInDescription(){
        repositoryHelperCreateFilled();
        RealEstateHandMeDown realEstateHandMeDownWithRuralInDescription = RealEstateHandMeDownHelper.createRealEstateHandMeDown2();

        boolean containsHandMeDownWithRuralInDescription = repository.getAll("RuRaL").contains(realEstateHandMeDownWithRuralInDescription);

        assertTrue(containsHandMeDownWithRuralInDescription);

    }

    @Test
    void testGetAllByZipCode() {
        repositoryHelperCreateFilled();
        RealEstateHandMeDown realEstateHandMeDownWithZipCode3590 = RealEstateHandMeDownHelper.createRealEstateHandMeDown2();

        boolean containsARealEstateHandMeDownWithZip3590 = repository.getAll(3590).contains(realEstateHandMeDownWithZipCode3590);

        assertTrue(containsARealEstateHandMeDownWithZip3590);
    }

    @Test
    void getAllBySurfaceAreaThatIsBiggerThan1000(){
        repositoryHelperCreateFilled();
        RealEstateHandMeDown realEstateHandMeDownWithHugeSurfaceArea = RealEstateHandMeDownHelper.createRealEstateHandMeDown();
        RealEstateHandMeDown realEstateHandMeDownWithNormalSurfaceArea = RealEstateHandMeDownHelper.createRealEstateHandMeDown2();

        boolean containsRealEstateThatHasHugeSurfaceArea = repository.getAll(1000d).contains(realEstateHandMeDownWithHugeSurfaceArea);
        boolean containsNormalRealEstateHandMeDown = repository.getAll(1000d).contains(realEstateHandMeDownWithNormalSurfaceArea);

        assertTrue(containsRealEstateThatHasHugeSurfaceArea);
        assertFalse(containsNormalRealEstateHandMeDown);
    }

    @Test
    void getAllByOccupancyTypeONlyForRenting(){
        repositoryHelperCreateFilled();
        RealEstateHandMeDown realEstateHandMeDownForRenting = RealEstateHandMeDownHelper.createRealEstateHandMeDown2();
        RealEstateHandMeDown realEstateHandMeDownForSale = RealEstateHandMeDownHelper.createRealEstateHandMeDown();

        boolean containsForRentRealEstate = repository.getAll(OccupancyType.FOR_RENT).contains(realEstateHandMeDownForRenting);
        boolean containsForSaleRealEstate = repository.getAll(OccupancyType.FOR_RENT).contains(realEstateHandMeDownForSale);

        assertTrue(containsForRentRealEstate);
        assertFalse(containsForSaleRealEstate);
    }

    @Test
    void GetAllToUnavailableAndCountGetAllResults(){
        repositoryHelperCreateFilled();
        while(repository.getAll().iterator().hasNext()){
            repository.setStatus(repository.getAll().iterator().next(), HandMeDownStatus.UNAVAILABLE);
        }

        int countAllAvailableRealEstateHandMeDowns = repository.getAll().size();

        assertEquals(0,countAllAvailableRealEstateHandMeDowns);
    }

    private void repositoryHelperCreateEmpty() {
        repository = new RealEstateHandMeDownImpl();
    }

    private void repositoryHelperCreateFilled(){
        repositoryHelperCreateEmpty();
        repository.add(RealEstateHandMeDownHelper.createRealEstateHandMeDown());
        repository.add(RealEstateHandMeDownHelper.createRealEstateHandMeDown2());
    }
}