package handmedown.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClothingHandMeDownTest {
    @Test
    public void testClothingHandMeDownGetter(){
        ClothingHandMeDown clothingHandMeDown = new ClothingHandMeDown.ClothingHandMeDownBuilder()
                .user(new User("Thor","Huygh",null))
                .title("Jacket with hood")
                .description("waterproof lined with fleece")
                .price(new BigDecimal(25))
                .clothingSize(ClothingSize.XL)
                .build();
        assertEquals(ClothingSize.XL,clothingHandMeDown.getClothingSize());
    }
}