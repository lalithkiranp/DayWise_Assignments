package cases;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderProcessing {
	    static class Order {
	        String customer;
	        String category;
	        double amount;

	        Order(String customer, String category, double amount) {
	            this.customer = customer;
	            this.category = category;
	            this.amount = amount;
	        }

	        public String toString() {
	            return customer + " - " + category + " - $" + amount;
	        }
	    }

	    public static void main(String[] args) {
	        List<Order> orders = Arrays.asList(
	            new Order("Alice", "Electronics", 300),
	            new Order("Bob", "Books", 50),
	            new Order("Alice", "Books", 150),
	            new Order("Charlie", "Electronics", 400)
	        );

	        // Filter orders > 100
	        orders.stream()
	            .filter(o -> o.amount > 100)
	            .forEach(System.out::println);

	        // Count total orders per customer
	        Map<String, Long> orderCount = orders.stream()
	            .collect(Collectors.groupingBy(o -> o.customer, Collectors.counting()));
	        System.out.println(orderCount);

	        // Group by category
	        Map<String, List<Order>> grouped = orders.stream()
	            .collect(Collectors.groupingBy(o -> o.category));
	        System.out.println(grouped);
	    }
	}

