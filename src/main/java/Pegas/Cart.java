package Pegas;

public class Cart {
    private String name;
    private String quantity;

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
