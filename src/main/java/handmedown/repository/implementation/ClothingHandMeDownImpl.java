package handmedown.repository.implementation;

import handmedown.model.ClothingHandMeDown;
import handmedown.model.ClothingSize;

import java.util.Set;
import java.util.stream.Collectors;

public class ClothingHandMeDownImpl extends HandMeDownRepositoryImpl<ClothingHandMeDown> {
    Set<ClothingHandMeDown> getAll(ClothingSize clothingSize){
        return getAll().stream().filter(c -> c.getClothingSize().equals(clothingSize)).collect(Collectors.toSet());
    }
}
