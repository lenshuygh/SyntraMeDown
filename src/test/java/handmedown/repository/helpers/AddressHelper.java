package handmedown.repository.helpers;

import handmedown.model.Address;

public class AddressHelper {
    public static Address createSimpleAddress(){
        return new Address.AddressBuilder()
                .city("Genk")
                .zipCode(3600)
                .houseNumber("8040")
                .street("Thor Park")
                .build();
    }

    public static Address createSimpleAddress2(){
        return new Address.AddressBuilder()
                .city("Diepenbeek")
                .zipCode(3590)
                .houseNumber("85")
                .street("Ganzestraat")
                .build();
    }
}
