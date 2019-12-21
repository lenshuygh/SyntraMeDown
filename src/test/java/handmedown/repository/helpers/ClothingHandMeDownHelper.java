package handmedown.repository.helpers;

import handmedown.model.ClothingHandMeDown;
import handmedown.model.ClothingSize;

import java.math.BigDecimal;

public class ClothingHandMeDownHelper {
    public static ClothingHandMeDown createClothingHandMeDown() {
        return new ClothingHandMeDown.ClothingHandMeDownBuilder()
                .user(UserHelper.createSimpleUser())
                .title("random clothing title")
                .description("random clothing description")
                .clothingSize(ClothingSize.M)
                .price(new BigDecimal(20))
                .build();
    }

    public static ClothingHandMeDown createClothingHandMeDown2() {
        return new ClothingHandMeDown.ClothingHandMeDownBuilder()
                .user(UserHelper.createSimpleUser())
                .title("piece of cloth")
                .description("generic fabric")
                .clothingSize(ClothingSize.XL)
                .price(new BigDecimal(10))
                .build();
    }
}