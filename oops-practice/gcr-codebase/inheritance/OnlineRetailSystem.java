//Online Retail Order Management
package inheritance;
//Base class
class Order {
 int orderId;
 String orderDate;

 Order(int orderId, String orderDate) {
     this.orderId = orderId;
     this.orderDate = orderDate;
 }

 String getOrderStatus() {
     return "Order Placed";
 }
}

//Subclass
class ShippedOrder extends Order {
 String trackingNumber;

 ShippedOrder(int orderId, String orderDate, String trackingNumber) {
     super(orderId, orderDate);
     this.trackingNumber = trackingNumber;
 }

 String getOrderStatus() {
     return "Order Shipped";
 }
}

//Subclass of ShippedOrder
class DeliveredOrder extends ShippedOrder {
 String deliveryDate;

 DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
     super(orderId, orderDate, trackingNumber);
     this.deliveryDate = deliveryDate;
 }

 String getOrderStatus() {
     return "Order Delivered";
 }
}

//Main class
public class OnlineRetailSystem {
 public static void main(String[] args) {

     DeliveredOrder order = new DeliveredOrder(
             101,
             "01-01-2026",
             "TRK789",
             "05-01-2026"
     );

     System.out.println("Order ID: " + order.orderId);
     System.out.println("Order Date: " + order.orderDate);
     System.out.println("Tracking Number: " + order.trackingNumber);
     System.out.println("Delivery Date: " + order.deliveryDate);
     System.out.println("Status: " + order.getOrderStatus());
 }
}
