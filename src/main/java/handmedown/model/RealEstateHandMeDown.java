package handmedown.model;

import java.math.BigDecimal;

public class RealEstateHandMeDown extends HandMeDown {
    private double squareMeters;
    private OccupancyType occupancyType;
    private Address address;

    private RealEstateHandMeDown(RealEstateHandMeDownBuilder builder) {
        super(builder.user, builder.price, builder.title, builder.description);
        this.squareMeters = builder.squareFootage;
        this.occupancyType = builder.occupancyType;
        this.address = builder.address;
    }

    public double getSquareMeters() {
        return squareMeters;
    }

    public OccupancyType getOccupancyType() {
        return occupancyType;
    }

    public Address getAddress() {
        return address;
    }

    public static class RealEstateHandMeDownBuilder {
        private User user;
        private BigDecimal price;
        private String title;
        private String description;

        private double squareFootage;
        private OccupancyType occupancyType;
        private Address address;

        public RealEstateHandMeDownBuilder user(User user) {
            this.user = user;
            return this;
        }

        public RealEstateHandMeDownBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public RealEstateHandMeDownBuilder title(String title) {
            this.title = title;
            return this;
        }

        public RealEstateHandMeDownBuilder description(String description) {
            this.description = description;
            return this;
        }

        public RealEstateHandMeDownBuilder squareFootage(double squareFootage) {
            this.squareFootage = squareFootage;
            return this;
        }

        public RealEstateHandMeDownBuilder occupancyType(OccupancyType occupancyType) {
            this.occupancyType = occupancyType;
            return this;
        }

        public RealEstateHandMeDownBuilder address(Address address) {
            this.address = address;
            return this;
        }

        public RealEstateHandMeDown build() {
            return new RealEstateHandMeDown(this);
        }
    }
}
