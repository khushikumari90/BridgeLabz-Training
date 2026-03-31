package Encapsulation;
//Interface
interface Discountable {
 void applyDiscount(double percent);
 String getDiscountDetails();
}

//Abstract class
abstract class FoodItem {
 protected String itemName;
 protected double price;
 protected int quantity;
 protected double discount;

 public FoodItem(String itemName, double price, int quantity) {
     this.itemName = itemName;
     this.price = price;
     this.quantity = quantity;
 }

 abstract double calculateTotalPrice();

 public void getItemDetails() {
     System.out.println(itemName + " | Qty: " + quantity + " | Price: " + price);
 }
}

class VegItem extends FoodItem implements Discountable {
 public VegItem(String name, double price, int qty) {
     super(name, price, qty);
 }

 public double calculateTotalPrice() {
     return (price * quantity) - discount;
 }

 public void applyDiscount(double percent) {
     discount = (price * quantity) * percent / 100;
 }

 public String getDiscountDetails() {
     return "Veg Discount: ₹" + discount;
 }
}

class NonVegItem extends FoodItem {
 public NonVegItem(String name, double price, int qty) {
     super(name, price, qty);
 }

 public double calculateTotalPrice() {
     return (price * quantity) + 50; // extra charge
 }
}

//Test
public class FoodDeliveryTest {
 public static void main(String[] args) {
     FoodItem item = new VegItem("Paneer Pizza", 250, 2);
     ((VegItem) item).applyDiscount(10);

     item.getItemDetails();
     System.out.println("Total Price: " + item.calculateTotalPrice());
 }
}

