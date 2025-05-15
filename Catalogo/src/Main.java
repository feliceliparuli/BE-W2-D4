import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> warehouse = List.of(
                new Product(1, "Book A", "Books", 120.0),
                new Product(2, "Book B", "Books", 80.0),
                new Product(3, "Toy Car", "Boys", 25.0),
                new Product(4, "Baby Doll", "Baby", 30.0),
                new Product(5, "Toy Robot", "Boys", 90.0),
                new Product(6, "Milk", "Baby", 10.0)
        );

        Customer c1 = new Customer(1, "Alice", 1);
        Customer c2 = new Customer(2, "Bob", 2);
        Customer c3 = new Customer(3, "Charlie", 2);

        List<Order> orders = List.of(
                new Order(101, "2023-05-01", "2023-05-03", c1, List.of(warehouse.get(0), warehouse.get(1))),
                new Order(102, "2023-05-02", "2023-05-05", c2, List.of(warehouse.get(3), warehouse.get(5))),
                new Order(103, "2023-05-10", "2023-05-12", c3, List.of(warehouse.get(2), warehouse.get(4))),
                new Order(104, "2023-05-15", "2023-05-16", c2, List.of(warehouse.get(0), warehouse.get(4)))
        );

        System.out.println("Esercizio 1 - Ordini per cliente:");
        Map<Customer, List<Order>> ordiniPerCliente = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));
        ordiniPerCliente.forEach((cliente, listaOrdini) -> {
            System.out.println(cliente.getName() + ": " + listaOrdini.stream().map(Order::getId).toList());
        });

        System.out.println("\nEsercizio 2 - Totale vendite per cliente:");
        Map<Customer, Double> totalePerCliente = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer,
                        Collectors.summingDouble(o -> o.getProducts().stream().mapToDouble(Product::getPrice).sum())));
        totalePerCliente.forEach((cliente, totale) -> {
            System.out.println(cliente.getName() + ": " + totale);
        });

        System.out.println("\nEsercizio 3 - Prodotti più costosi:");
        warehouse.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(3)
                .forEach(System.out::println);

        System.out.println("\nEsercizio 4 - Media importi ordini:");
        double media = orders.stream()
                .mapToDouble(o -> o.getProducts().stream().mapToDouble(Product::getPrice).sum())
                .average().orElse(0);
        System.out.println("Media: " + media);

        System.out.println("\nEsercizio 5 - Totale importi per categoria:");
        Map<String, Double> sommaPerCategoria = warehouse.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.summingDouble(Product::getPrice)));
        sommaPerCategoria.forEach((categoria, somma) -> {
            System.out.println(categoria + ": " + somma);
        });
    }
}