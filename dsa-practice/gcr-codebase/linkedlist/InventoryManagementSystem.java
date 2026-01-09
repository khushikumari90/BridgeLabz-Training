package linkedlist;
//Inventory Management System using Singly Linked List

class Item {
 String name;
 int id;
 int quantity;
 double price;
 Item next;

 public Item(int id, String name, int quantity, double price) {
     this.id = id;
     this.name = name;
     this.quantity = quantity;
     this.price = price;
     this.next = null;
 }
}

class InventoryLinkedList {
 private Item head;

 // Add at beginning
 public void addAtBeginning(int id, String name, int quantity, double price) {
     Item newItem = new Item(id, name, quantity, price);
     newItem.next = head;
     head = newItem;
 }

 // Add at end
 public void addAtEnd(int id, String name, int quantity, double price) {
     Item newItem = new Item(id, name, quantity, price);
     if (head == null) {
         head = newItem;
         return;
     }
     Item temp = head;
     while (temp.next != null) {
         temp = temp.next;
     }
     temp.next = newItem;
 }

 // Add at specific position (1-based index)
 public void addAtPosition(int position, int id, String name, int quantity, double price) {
     if (position <= 0) {
         System.out.println("Invalid position!");
         return;
     }
     if (position == 1) {
         addAtBeginning(id, name, quantity, price);
         return;
     }
     Item newItem = new Item(id, name, quantity, price);
     Item temp = head;
     for (int i = 1; temp != null && i < position - 1; i++) {
         temp = temp.next;
     }
     if (temp == null) {
         System.out.println("Position out of range!");
         return;
     }
     newItem.next = temp.next;
     temp.next = newItem;
 }

 // Remove by Item ID
 public void removeById(int id) {
     if (head == null) {
         System.out.println("Inventory is empty!");
         return;
     }
     if (head.id == id) {
         head = head.next;
         System.out.println("Item removed successfully.");
         return;
     }
     Item temp = head;
     while (temp.next != null && temp.next.id != id) {
         temp = temp.next;
     }
     if (temp.next == null) {
         System.out.println("Item not found!");
     } else {
         temp.next = temp.next.next;
         System.out.println("Item removed successfully.");
     }
 }

 // Update quantity by Item ID
 public void updateQuantity(int id, int newQuantity) {
     Item temp = head;
     while (temp != null) {
         if (temp.id == id) {
             temp.quantity = newQuantity;
             System.out.println("Quantity updated successfully.");
             return;
         }
         temp = temp.next;
     }
     System.out.println("Item not found!");
 }

 // Search by Item ID
 public void searchById(int id) {
     Item temp = head;
     while (temp != null) {
         if (temp.id == id) {
             System.out.println("Found: ID=" + temp.id + ", Name=" + temp.name +
                     ", Quantity=" + temp.quantity + ", Price=" + temp.price);
             return;
         }
         temp = temp.next;
     }
     System.out.println("Item not found!");
 }

 // Search by Item Name
 public void searchByName(String name) {
     Item temp = head;
     while (temp != null) {
         if (temp.name.equalsIgnoreCase(name)) {
             System.out.println("Found: ID=" + temp.id + ", Name=" + temp.name +
                     ", Quantity=" + temp.quantity + ", Price=" + temp.price);
             return;
         }
         temp = temp.next;
     }
     System.out.println("Item not found!");
 }

 // Calculate total inventory value
 public void calculateTotalValue() {
     double total = 0;
     Item temp = head;
     while (temp != null) {
         total += temp.price * temp.quantity;
         temp = temp.next;
     }
     System.out.println("Total Inventory Value: " + total);
 }

 // Display all items
 public void displayItems() {
     if (head == null) {
         System.out.println("No items to display.");
         return;
     }
     System.out.println("Inventory Items:");
     Item temp = head;
     while (temp != null) {
         System.out.println("ID=" + temp.id + ", Name=" + temp.name +
                 ", Quantity=" + temp.quantity + ", Price=" + temp.price);
         temp = temp.next;
     }
 }

 // Merge Sort for sorting by Name or Price
 public void sortByName(boolean ascending) {
     head = mergeSort(head, "name", ascending);
 }

 public void sortByPrice(boolean ascending) {
     head = mergeSort(head, "price", ascending);
 }

 private Item mergeSort(Item h, String criteria, boolean ascending) {
     if (h == null || h.next == null) return h;

     Item middle = getMiddle(h);
     Item nextOfMiddle = middle.next;
     middle.next = null;

     Item left = mergeSort(h, criteria, ascending);
     Item right = mergeSort(nextOfMiddle, criteria, ascending);

     return sortedMerge(left, right, criteria, ascending);
 }

 private Item sortedMerge(Item a, Item b, String criteria, boolean ascending) {
     if (a == null) return b;
     if (b == null) return a;

     Item result;
     boolean condition;
     if (criteria.equals("name")) {
         condition = ascending ? a.name.compareToIgnoreCase(b.name) <= 0 : a.name.compareToIgnoreCase(b.name) > 0;
     } else {
         condition = ascending ? a.price <= b.price : a.price > b.price;
     }

     if (condition) {
         result = a;
         result.next = sortedMerge(a.next, b, criteria, ascending);
     } else {
         result = b;
         result.next = sortedMerge(a, b.next, criteria, ascending);
     }
     return result;
 }

 private Item getMiddle(Item h) {
     if (h == null) return h;
     Item slow = h, fast = h.next;
     while (fast != null) {
         fast = fast.next;
         if (fast != null) {
             slow = slow.next;
             fast = fast.next;
         }
     }
     return slow;
 }
}

public class InventoryManagementSystem {
 public static void main(String[] args) {
     InventoryLinkedList inventory = new InventoryLinkedList();

     // Adding items
     inventory.addAtBeginning(101, "Laptop", 5, 50000);
     inventory.addAtEnd(102, "Mouse", 20, 500);
     inventory.addAtPosition(2, 103, "Keyboard", 10, 1500);

     // Display items
     inventory.displayItems();

     // Search
     inventory.searchById(102);
     inventory.searchByName("Laptop");

     // Update quantity
     inventory.updateQuantity(103, 15);

     // Calculate total value
     inventory.calculateTotalValue();

     // Sort by name ascending
     inventory.sortByName(true);
     System.out.println("\nSorted by Name Ascending:");
     inventory.displayItems();

     // Sort by price descending
     inventory.sortByPrice(false);
     System.out.println("\nSorted by Price Descending:");
     inventory.displayItems();

     // Remove item
     inventory.removeById(101);
     System.out.println("\nAfter Removing Item with ID 101:");
     inventory.displayItems();
 }
}