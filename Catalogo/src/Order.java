import java.util.List;

public class Order {
    private int id;
    private String orderDate;
    private String deliveryDate;
    private Customer customer;
    private List<Product> products;

    public Order(int id, String orderDate, String deliveryDate, Customer customer, List<Product> products) {
        this.id = id;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.customer = customer;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }
}