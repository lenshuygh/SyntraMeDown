package handmedown.model;

import java.util.Objects;

public class User {
    private String name;
    private String familyName;
    private Address address;

    public User(String name, String familyName, Address address) {
        this.name = name;
        this.familyName = familyName;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(familyName, user.familyName) &&
                Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, familyName, address);
    }
}
