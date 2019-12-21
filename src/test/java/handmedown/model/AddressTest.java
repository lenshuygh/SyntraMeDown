package handmedown.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressTest {
    @Test
    public void testAddressGetters() {
        Address address = new Address.AddressBuilder()
                .street("Ganzestraat")
                .houseNumber("85")
                .zipCode(3590)
                .city("Diepenbeek")
                .build();

        assertEquals("Diepenbeek",address.getCity());
        assertEquals(3590,address.getZipCode());
    }
}