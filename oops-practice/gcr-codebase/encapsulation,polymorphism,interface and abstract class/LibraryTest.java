package Encapsulation;
//Interface
interface Reservable {
 void reserveItem();
 boolean checkAvailability();
}

//Abstract class
abstract class LibraryItem {
 protected int itemId;
 protected String title;
 protected String author;
 private boolean available = true; // encapsulation

 public LibraryItem(int itemId, String title, String author) {
     this.itemId = itemId;
     this.title = title;
     this.author = author;
 }

 abstract int getLoanDuration();

 public void getItemDetails() {
     System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
 }

 protected boolean isAvailable() {
     return available;
 }

 protected void setAvailable(boolean status) {
     available = status;
 }
}

//Subclasses
class Book extends LibraryItem implements Reservable {
 public Book(int id, String title, String author) {
     super(id, title, author);
 }

 public int getLoanDuration() {
     return 14;
 }

 public void reserveItem() {
     setAvailable(false);
 }

 public boolean checkAvailability() {
     return isAvailable();
 }
}

class Magazine extends LibraryItem {
 public Magazine(int id, String title, String author) {
     super(id, title, author);
 }

 public int getLoanDuration() {
     return 7;
 }
}

class DVD extends LibraryItem {
 public DVD(int id, String title, String author) {
     super(id, title, author);
 }

 public int getLoanDuration() {
     return 3;
 }
}

//Test
public class LibraryTest {
 public static void main(String[] args) {
     LibraryItem item = new Book(101, "Java Basics", "James");
     item.getItemDetails();
     System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
 }
}

