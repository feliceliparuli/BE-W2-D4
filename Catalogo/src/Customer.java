import java.util.Objects;

public class Customer {
    private int id;
    private String name;
    private int tier;

    public Customer(int id, String name, int tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTier() {
        return tier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return id == customer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}