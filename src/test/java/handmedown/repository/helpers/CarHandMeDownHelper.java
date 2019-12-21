package handmedown.repository.helpers;

import handmedown.model.CarHandMeDown;
import handmedown.model.Color;
import handmedown.model.FuelType;

import java.math.BigDecimal;

public class CarHandMeDownHelper {
    public static CarHandMeDown createCarHandMeDown() {
        return new CarHandMeDown.CarHandMeDownBuilder()
                .user(UserHelper.createSimpleUser())
                .title("Volkswagen Golf")
                .description("Black Golf VI lot of options in good condition")
                .color(Color.BLACK)
                .fuelType(FuelType.GASOLINE)
                .mileage(65000)
                .price(new BigDecimal(10000))
                .build();
    }

    public static CarHandMeDown createCarHandMeDown2() {
        return new CarHandMeDown.CarHandMeDownBuilder()
                .user(UserHelper.createSimpleUser())
                .title("Skoda Octavia")
                .description("Quartz Grey Skoda Octavia with low mileage")
                .color(Color.GREY)
                .fuelType(FuelType.GASOLINE)
                .mileage(500)
                .price(new BigDecimal(26000))
                .build();
    }
}