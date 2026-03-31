//Develop a simplified e-commerce platform
package Encapsulation;
import java.util.ArrayList;

//Interface
interface Taxable {
 double calculateTax();
 String getTaxDetails();
}

//Abstract class
abstract class Product {
 private int productId;
 private String name;
 private double price;

 public Product(int productId, String name, double price) {
     this.productId = productId;
     this.name = name;
     this.price = price;
 }

 // Encapsulation: getters & setters
 public int getProductId() {
     return productId;
 }

 public String getName() {
     return name;
 }

 public double getPrice() {
     return price;
 }

 public void setPrice(double price) {
     this.price = price;
 }

 // Abstract method
 public abstract double calculateDiscount();
}

//Electronics class
class Electronics extends Product implements Taxable {

 public Electronics(int id, String name, double price) {
     super(id, name, price);
 }

 public double calculateDiscount() {
     return getPrice() * 0.10; // 10% discount
 }

 public double calculateTax() {
     return getPrice() * 0.18; // 18% tax
 }

 public String getTaxDetails() {
     return "Electronics Tax: 18%";
 }
}

//Clothing class
class Clothing extends Product implements Taxable {

 public Clothing(int id, String name, double price) {
     super(id, name, price);
 }

 public double calculateDiscount() {
     return getPrice() * 0.20; // 20% discount
 }

 public double calculateTax() {
     return getPrice() * 0.05; // 5% tax
 }

 public String getTaxDetails() {
     return "Clothing Tax: 5%";
 }
}

//Groceries class
class Groceries extends Product {

 public Groceries(int id, String name, double price) {
     super(id, name, price);
 }

 public double calculateDiscount() {
     return getPrice() * 0.05; // 5% discount
 }
}

//Main class
public class ECommercePlatform {

 // Polymorphism method
 public static void printFinalPrice(Product product) {
     double tax = 0;

     if (product instanceof Taxable) {
         tax = ((Taxable) product).calculateTax();
     }

     double discount = product.calculateDiscount();
     double finalPrice = product.getPrice() + tax - discount;

     System.out.println("Product: " + product.getName());
     System.out.println("Final Price: " + finalPrice);
     System.out.println("----------------------");
 }

 public static void main(String[] args) {

     ArrayList<Product> products = new ArrayList<>();

     products.add(new Electronics(101, "Laptop", 60000));
     products.add(new Clothing(102, "Jacket", 3000));
     products.add(new Groceries(103, "Rice Bag", 1200));

     // Polymorphism in action
     for (Product p : products) {
         printFinalPrice(p);
     }
 }
}

