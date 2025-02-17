package handmedown.model;

import java.math.BigDecimal;

public class CarHandMeDown extends HandMeDown {
    private Color color;
    private int kilometersDriven;
    private FuelType fuelType;

    private CarHandMeDown(CarHandMeDownBuilder builder) {
        super(builder.user, builder.price, builder.title, builder.description);
        this.color = builder.color;
        this.kilometersDriven = builder.kilometersDriven;
        this.fuelType = builder.fuelType;
    }

    public Color getColor() {
        return color;
    }

    public int getKilometersDriven() {
        return kilometersDriven;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public static class CarHandMeDownBuilder {
        private User user;
        private BigDecimal price;
        private String title;
        private String description;

        private Color color;
        private int kilometersDriven;
        private FuelType fuelType;

        public CarHandMeDownBuilder user(User user) {
            this.user = user;
            return this;
        }

        public CarHandMeDownBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public CarHandMeDownBuilder title(String title) {
            this.title = title;
            return this;
        }

        public CarHandMeDownBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CarHandMeDownBuilder color(Color color) {
            this.color = color;
            return this;
        }

        public CarHandMeDownBuilder kilometersDriven(int kilometersDriven) {
            this.kilometersDriven = kilometersDriven;
            return this;
        }

        public CarHandMeDownBuilder fuelType(FuelType fuelType) {
            this.fuelType = fuelType;
            return this;
        }

        public CarHandMeDown build() {
            return new CarHandMeDown(this);
        }
    }
}
