package oop;

public class Book {
	  // Attributes
    String title;
    String author;
    double price;

    // Method to display book details
    void displayDetails() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
    }

    public static void main(String[] args) {
        // First Book
        Book b1 = new Book();
        b1.title = "2States";
        b1.author = "Chetan Bhagat";
        b1.price = 500.0;

        // Second Book
        Book b2 = new Book();
        b2.title = "Wings Of Fire";
        b2.author = "Abdul kalam.A.P.J";
        b2.price = 500.0;

        // Display details
        b1.displayDetails();
        b2.displayDetails();
    }
}
