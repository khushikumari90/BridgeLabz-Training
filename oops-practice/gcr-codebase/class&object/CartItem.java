package oop;

public class CartItem {
    // Attributes
    String itemName;
    double price;
    int quantity;

    // Constructor
    CartItem(String name, double price, int qty) {
        this.itemName = name;
        this.price = price;
        this.quantity = qty;
    }

    // Method to add items to the cart
    void addItem(int qty) {
        quantity += qty;
        System.out.println("Added " + qty + " of " + itemName + " to the cart.");
    }

    // Method to remove items from the cart
    void removeItem(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
            System.out.println("Removed " + qty + " of " + itemName + " from the cart.");
        } else {
            System.out.println("Cannot remove more than available quantity.");
        }
    }

    // Method to display total cost
    void displayTotalCost() {
        double total = price * quantity;
        System.out.println("Total cost: $" + total);
    }

    // Method to display item details
    void displayItem() {
        System.out.println("Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity);
    }

    public static void main(String[] args) {
        // Create cart item
        CartItem item = new CartItem("Laptop", 999.99, 1);

        // Display initial item
        item.displayItem();

        // Add 2 more laptops
        item.addItem(2);

        // Remove 1 laptop
        item.removeItem(1);

        // Display total cost
        item.displayTotalCost();
    }

}
