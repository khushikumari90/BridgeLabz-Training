package map_interface;
import java.util.*;

public class ShoppingCart {

    // Store product prices (Product -> Price)
    static HashMap<String, Integer> priceMap = new HashMap<>();

    // Maintain order of items added
    static LinkedHashMap<String, Integer> cartOrderMap = new LinkedHashMap<>();

    // Display items sorted by price (Price -> List of Products)
    static TreeMap<Integer, List<String>> sortedByPriceMap = new TreeMap<>();

    // Add product to cart
    static void addProduct(String product, int price) {

        // HashMap stores product price
        priceMap.put(product, price);

        // LinkedHashMap maintains insertion order
        cartOrderMap.put(product, price);

        // TreeMap sorts by price
        sortedByPriceMap.putIfAbsent(price, new ArrayList<>());
        sortedByPriceMap.get(price).add(product);
    }

    // Display cart in insertion order
    static void displayCartOrder() {
        System.out.println("Cart items in insertion order:");
        for (Map.Entry<String, Integer> entry : cartOrderMap.entrySet()) {
            System.out.println(entry.getKey() + " -> ₹" + entry.getValue());
        }
    }

    // Display cart sorted by price
    static void displaySortedByPrice() {
        System.out.println("Cart items sorted by price:");
        for (Map.Entry<Integer, List<String>> entry : sortedByPriceMap.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + " -> ₹" + entry.getKey());
            }
        }
    }

    // Display price list from HashMap
    static void displayPriceList() {
        System.out.println("Product price list:");
        for (Map.Entry<String, Integer> entry : priceMap.entrySet()) {
            System.out.println(entry.getKey() + " -> ₹" + entry.getValue());
        }
    }

    // Main method
    public static void main(String[] args) {

        addProduct("Laptop", 50000);
        addProduct("Mouse", 500);
        addProduct("Keyboard", 1500);
        addProduct("Monitor", 12000);
        addProduct("Mouse", 500);   // duplicate price example

        System.out.println();

        displayCartOrder();
        System.out.println();

        displaySortedByPrice();
        System.out.println();

        displayPriceList();
    }
}
