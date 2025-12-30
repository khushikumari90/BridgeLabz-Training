package oop;

public class Item {
	// Attributes
    String itemCode;
    String itemName;
    double itemPrice;

    // Method to display item details
    void displayItem() {
        System.out.println("itemCode : " + itemCode);
        System.out.println("itemPrice : " + itemPrice);
        System.out.println("itemName : " + itemName);
        System.out.println("----------------------------");
    }

    // Method to calculate total cost
    double calculateTotalCost(int quantity) {
        return itemPrice * quantity;
    }

    public static void main(String[] args) {
        // First Item
        Item i1 = new Item();
        i1.itemCode = "01AA";
        i1.itemName = "Water bottle";
        i1.itemPrice = 500.0;

        // Second Item
        Item i2 = new Item();
        i2.itemCode = "01BB";
        i2.itemName = "Rice";
        i2.itemPrice = 700.0;

        // Third Item
        Item i3 = new Item();
        i3.itemCode = "02AA";
        i3.itemName = "blackboard";
        i3.itemPrice = 400.0;

        // Display item details
        i1.displayItem();
        i2.displayItem();
        i3.displayItem();

        // Example: total cost calculation
        // System.out.println("Total cost for 3 items: " + i1.calculateTotalCost(3));
    }

}
