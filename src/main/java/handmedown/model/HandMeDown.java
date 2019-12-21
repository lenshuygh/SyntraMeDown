package handmedown.model;

import java.math.BigDecimal;
import java.util.Objects;

public class HandMeDown {
    private User user;
    private BigDecimal price;
    private String title;
    private String description;

    public HandMeDown(User user, BigDecimal price, String title, String description) {
        this.user = user;
        this.price = price;
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandMeDown that = (HandMeDown) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(price, that.price) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, price, title, description);
    }
}


