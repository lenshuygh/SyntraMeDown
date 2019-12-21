package handmedown.model;

public class Address {
    private String street;
    // String to allow for 2A and 45B etc.
    private String houseNumber;
    private int boxNumber;
    private int zipCode;
    private String city;

    private Address(AddressBuilder builder) {
        this.street = builder.street;
        this.houseNumber = builder.houseNumber;
        this.boxNumber = builder.boxNumber;
        this.zipCode = builder.zipCode;
        this.city = builder.city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public static class AddressBuilder {
        private String street;
        private String houseNumber;
        private int boxNumber;
        private int zipCode;
        private String city;


        public AddressBuilder street(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder houseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        public AddressBuilder boxNumber(int boxNumber) {
            this.boxNumber = boxNumber;
            return this;
        }

        public AddressBuilder zipCode(int zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public AddressBuilder city(String city) {
            this.city = city;
            return this;
        }

        public Address build() {
            Address address = new Address(this);
            return address;
        }
    }
}
