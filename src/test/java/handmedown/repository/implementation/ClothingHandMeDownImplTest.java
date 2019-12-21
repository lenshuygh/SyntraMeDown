package handmedown.repository.implementation;

import handmedown.model.ClothingHandMeDown;
import handmedown.model.ClothingSize;
import handmedown.model.HandMeDownStatus;
import handmedown.repository.helpers.ClothingHandMeDownHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClothingHandMeDownImplTest {
    ClothingHandMeDownImpl repository;

    @Test
    void getAll() {
        repositoryHelperCreateFilled();

        int numberOfClothingHandMeDowns = repository.getAll().size();

        assertEquals(2,numberOfClothingHandMeDowns);
    }

    @Test
    void getAllBySearchTermOnlyOneResultFindByDescription(){
        repositoryHelperCreateFilled();
        ClothingHandMeDown clothingToFind = ClothingHandMeDownHelper.createClothingHandMeDown();
        ClothingHandMeDown clothingToNotFind = ClothingHandMeDownHelper.createClothingHandMeDown2();

        boolean foundClothingHandMeDown = repository.getAll("description").contains(clothingToFind);
        boolean clothingHandMeDownNotFound = repository.getAll("description").contains(clothingToNotFind);

        assertTrue(foundClothingHandMeDown);
        assertFalse(clothingHandMeDownNotFound);
    }

    @Test
    void getAllBySearchTermOnlyOneResultFindByTitle(){
        repositoryHelperCreateFilled();
        ClothingHandMeDown clothingToNotFind = ClothingHandMeDownHelper.createClothingHandMeDown();
        ClothingHandMeDown clothingToFind = ClothingHandMeDownHelper.createClothingHandMeDown2();

        boolean foundClothingHandMeDown = repository.getAll("PIECE").contains(clothingToFind);
        boolean foundClothingHandMeNotFound = repository.getAll("PIECE").contains(clothingToNotFind);

        assertTrue(foundClothingHandMeDown);
        assertFalse(foundClothingHandMeNotFound);
    }

    @Test
    void getAllBySearchTermMultipleResults(){
        repositoryHelperCreateFilled();

        int foundClothingHandMeDownsBySearchTerm = repository.getAll("CLOTH").size();

        assertEquals(2,foundClothingHandMeDownsBySearchTerm);
    }

    @Test
    void getAllBySizeOneResult(){
        repositoryHelperCreateFilled();
        ClothingHandMeDown clothingHandMeDownWithSizeM = ClothingHandMeDownHelper.createClothingHandMeDown();
        ClothingHandMeDown clothingHandMeDownWithSizeXl = ClothingHandMeDownHelper.createClothingHandMeDown2();

        boolean resultsContainClothingWithSizeM = repository.getAll(ClothingSize.M).contains(clothingHandMeDownWithSizeM);
        boolean resultsContainClothingWithSizeXl = repository.getAll(ClothingSize.M).contains(clothingHandMeDownWithSizeXl);

        assertTrue(resultsContainClothingWithSizeM);
        assertFalse(resultsContainClothingWithSizeXl);
    }

    @Test
    void getStatusOfClothingHandMeDownWithStatusAvailable(){
        repositoryHelperCreateFilled();
        ClothingHandMeDown clothingHandMeDownToCheckStatusFrom = ClothingHandMeDownHelper.createClothingHandMeDown();

        HandMeDownStatus handMeDownStatusShouldBeAvailable = repository.getStatus(clothingHandMeDownToCheckStatusFrom);

        assertEquals(HandMeDownStatus.AVAILABLE,handMeDownStatusShouldBeAvailable);
    }

    @Test
    void getStatusOfClothingHandMeDownWithStatusUnAvailable(){
        repositoryHelperCreateFilled();
        ClothingHandMeDown clothingHandMeDownToCheckStatusFrom = ClothingHandMeDownHelper.createClothingHandMeDown();

        repository.setStatus(clothingHandMeDownToCheckStatusFrom,HandMeDownStatus.UNAVAILABLE);
        HandMeDownStatus handMeDownStatusShouldBeAvailable = repository.getStatus(clothingHandMeDownToCheckStatusFrom);

        assertEquals(HandMeDownStatus.UNAVAILABLE,handMeDownStatusShouldBeAvailable);
    }

    private void repositoryHelperCreateEmpty() {
        repository = new ClothingHandMeDownImpl();
    }

    private void repositoryHelperCreateFilled(){
        repositoryHelperCreateEmpty();
        repository.add(ClothingHandMeDownHelper.createClothingHandMeDown());
        repository.add(ClothingHandMeDownHelper.createClothingHandMeDown2());
    }
}