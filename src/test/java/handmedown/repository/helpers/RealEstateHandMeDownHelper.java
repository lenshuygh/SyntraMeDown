package handmedown.repository.helpers;

import handmedown.model.HandMeDown;
import handmedown.model.OccupancyType;
import handmedown.model.RealEstateHandMeDown;

import java.math.BigDecimal;

public class RealEstateHandMeDownHelper {
    public static RealEstateHandMeDown createRealEstateHandMeDown() {
        return new RealEstateHandMeDown.RealEstateHandMeDownBuilder()
                .user(UserHelper.createSimpleUser())
                .title("Syntra Genk")
                .description("Prime educational real estate")
                .occupancyType(OccupancyType.FOR_SALE)
                .squareFootage(80000d)
                .price(new BigDecimal(800000))
                .address(AddressHelper.createSimpleAddress())
                .build();
    }

    public static RealEstateHandMeDown createRealEstateHandMeDown2() {
        return new RealEstateHandMeDown.RealEstateHandMeDownBuilder()
                .user(UserHelper.createSimpleUser())
                .title("My house")
                .description("House in a rural area")
                .occupancyType(OccupancyType.FOR_RENT)
                .squareFootage(250d)
                .price(new BigDecimal(1100))
                .address(AddressHelper.createSimpleAddress2())
                .build();
    }
}