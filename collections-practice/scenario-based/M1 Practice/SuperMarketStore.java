package m1_questions;
import java.util.*;

abstract class Product {
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    abstract String display();

    double totalValue() {
        return price * quantity;
    }
}

class Electronics extends Product {
    int warranty;

    Electronics(String name, double price, int quantity, int warranty) {
        super(name, price, quantity);
        this.warranty = warranty;
    }

    String display() {
        return name + " - Price: " + price + ", Quantity: " + quantity + ", Warranty: " + warranty + " months";
    }
}

class Clothing extends Product {
    String size;

    Clothing(String name, double price, int quantity, String size) {
        super(name, price, quantity);
        this.size = size;
    }

    String display() {
        return name + " - Price: " + price + ", Quantity: " + quantity + ", Size: " + size;
    }
}

public class SuperMarketStore{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] input = new String[n];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextLine();
        }

        List<Product> list = new ArrayList<>();
        List<String> output = new ArrayList<>();

        for (String line : input) {
            if (line.trim().isEmpty()) continue;

            String[] p = line.split(",\\s*");
            String type = p[0];

            if (type.equals("Electronics")) {
                Product e = new Electronics(p[1], Double.parseDouble(p[2]), Integer.parseInt(p[3]), Integer.parseInt(p[4]));
                list.add(e);
                output.add("Product added to inventory: " + p[1]);
            } else if (type.equals("Clothing")) {
                Product c = new Clothing(p[1], Double.parseDouble(p[2]), Integer.parseInt(p[3]), p[4]);
                list.add(c);
                output.add("Product added to inventory: " + p[1]);
            }
        }

        output.add("Inventory:");
        for (Product p : list) {
            output.add(p.display());
        }

        double total = 0;
        for (Product p : list) {
            total += p.totalValue();
        }

        output.add(String.format("Total value of the inventory: %.2f", total));

        for (String s : output) {
            System.out.println(s);
        }

        sc.close();
    }
}