package handmedown.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarHandMeDownTest {

    @Test
    public void testCarHandMeDownGetters(){
        CarHandMeDown carHandMeDown = new CarHandMeDown.CarHandMeDownBuilder()
                .user(new User("lens","huygh",null))
                .title("Golf IV")
                .description("7 y old in good shape")
                .price(new BigDecimal(10000))
                .color(Color.BLACK)
                .fuelType(FuelType.GASOLINE)
                .kilometersDriven(65000)
                .build();
        assertEquals(65000,carHandMeDown.getKilometersDriven());
        assertEquals(Color.BLACK,carHandMeDown.getColor());
        assertEquals(FuelType.GASOLINE,carHandMeDown.getFuelType());
    }
}