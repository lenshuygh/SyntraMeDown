package handmedown.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RealEstateHandMeDownTest {
    @Test
    public void TestRealEstateHandMeDownGetters(){
        RealEstateHandMeDown realEstateHandMeDown = new RealEstateHandMeDown.RealEstateHandMeDownBuilder()
                .user(new User("Smiegel","Huygh",null))
                .address(new Address.AddressBuilder()
                .street("Thor Park")
                        .houseNumber("8040")
                        .zipCode(3600)
                        .city("Genk")
                        .build()
                )
                .title("Educational building")
                .description("Large building with lots of glass")
                .price(new BigDecimal(800000))
                .occupancyType(OccupancyType.FOR_SALE)
                .squareFootage(125000)
                .build();
        assertEquals("Genk",realEstateHandMeDown.getAddress().getCity());
        assertEquals(3600,realEstateHandMeDown.getAddress().getZipCode());
        assertEquals(OccupancyType.FOR_SALE,realEstateHandMeDown.getOccupancyType());
    }
}