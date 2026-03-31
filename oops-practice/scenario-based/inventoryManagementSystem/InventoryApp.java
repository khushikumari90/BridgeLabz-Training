package inventoryManagementSystem;

public class InventoryApp {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Product p1 = new Product(101, "Keyboard", 10);
        Product p2 = new Product(102, "Mouse", 4);

        inventory.addProduct(p1);
        inventory.addProduct(p2);

        inventory.displayInventory();

        try {
            inventory.updateStock(102, 3);
            inventory.updateStock(101, 0);
        } catch (OutOfStockException e) {
            System.out.println("Error: " + e.getMessage());
        }

        inventory.displayInventory();
    }
}
