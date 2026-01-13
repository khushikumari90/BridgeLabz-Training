package inventoryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products = new ArrayList<>();
    private AlertService alertService = new StockAlertService();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.getName());
    }

    public void updateStock(int productId, int newQty) throws OutOfStockException {
        for (Product p : products) {
            if (p.getProductId() == productId) {
                if (newQty < 0) {
                    throw new OutOfStockException("Stock cannot be negative!");
                }
                p.setQuantity(newQty);

                if (newQty <= 5) {
                    alertService.sendLowStockAlert(p);
                }
                return;
            }
        }
        System.out.println("Product not found!");
    }

    public void displayInventory() {
        System.out.println("\n📋 Inventory List:");
        for (Product p : products) {
            System.out.println(p.getProductId() + " | " + p.getName()
                    + " | Qty: " + p.getQuantity());
        }
    }
}

