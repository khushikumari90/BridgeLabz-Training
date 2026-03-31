package inventoryManagementSystem;

public class StockAlertService implements AlertService {

    @Override
    public void sendLowStockAlert(Product product) {
        System.out.println("⚠ ALERT: Low stock for product -> "
                + product.getName() + " (Qty: " + product.getQuantity() + ")");
    }
}

