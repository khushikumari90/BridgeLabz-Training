//Library Book System: Create a Book class with attributes title, author, price, and availability. Implement a method to borrow a book
package constructor;
public class Book1 {
    String title;
    String author;
    double price;
    boolean available;

    // Parameterized constructor
    Book1(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true; // book is available initially
    }

    // Method to borrow the book
    void borrowBook() {
        if (available) {
            available = false;
            System.out.println("You have successfully borrowed: " + title);
        } else {
            System.out.println("Sorry, the book is already borrowed.");
        }
    }

    // Method to display book details
    void displayDetails() {
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);
        System.out.println("Price       : ₹" + price);
        System.out.println("Availability: " + (available ? "Available" : "Not Available"));
    }

    public static void main(String[] args) {
        Book1 b1 = new Book1("Clean Code", "Robert C. Martin", 550);

        b1.displayDetails();
        System.out.println();

        // Borrow the book
        b1.borrowBook();

        System.out.println();
        b1.displayDetails();

        System.out.println();
        // Try borrowing again
        b1.borrowBook();
    }
}


