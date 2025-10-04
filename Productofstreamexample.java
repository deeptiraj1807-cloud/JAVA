
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("Product{name='%s', price=%.2f, category='%s'}", name, price, category);
    }
}

public class ProductStreamExample {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1200.00, "Electronics"),
                new Product("Smartphone", 800.00, "Electronics"),
                new Product("TV", 1500.00, "Electronics"),
                new Product("Refrigerator", 1000.00, "Appliances"),
                new Product("Microwave", 300.00, "Appliances"),
                new Product("Blender", 150.00, "Appliances"),
                new Product("Desk Chair", 250.00, "Furniture"),
                new Product("Dining Table", 700.00, "Furniture"),
                new Product("Sofa", 1200.00, "Furniture"));

        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("Products grouped by category:");
        productsByCategory.forEach((category, productList) -> {
            System.out.println(category + ":");
            productList.forEach(System.out::println);
        });

        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));

        System.out.println("\nMost expensive product in each category:");
        mostExpensiveByCategory.forEach((category, productOpt) -> {
            System.out.println(category + ": " + productOpt.orElse(null));
        });

        double averagePrice = products.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));

        System.out.printf("\nAverage price of all products: %.2f\n", averagePrice);
    }
}
