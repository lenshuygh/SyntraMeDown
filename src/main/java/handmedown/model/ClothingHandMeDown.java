package handmedown.model;

import java.math.BigDecimal;

public class ClothingHandMeDown extends HandMeDown {
    private ClothingSize clothingSize;

    private ClothingHandMeDown(ClothingHandMeDownBuilder builder) {
        super(builder.user, builder.price, builder.title, builder.description);
        clothingSize = builder.clothingSize;
    }

    public ClothingSize getClothingSize() {
        return clothingSize;
    }

    public static class ClothingHandMeDownBuilder {
        private User user;
        private BigDecimal price;
        private String title;
        private String description;
        private ClothingSize clothingSize;

        public ClothingHandMeDownBuilder user(User user) {
            this.user = user;
            return this;
        }

        public ClothingHandMeDownBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ClothingHandMeDownBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ClothingHandMeDownBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ClothingHandMeDownBuilder clothingSize(ClothingSize clothingSize) {
            this.clothingSize = clothingSize;
            return this;
        }

        public ClothingHandMeDown build() {
            return new ClothingHandMeDown(this);
        }
    }
}
