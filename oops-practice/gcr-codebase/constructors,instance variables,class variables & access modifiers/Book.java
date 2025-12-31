//Create a Book class with attributes title, author, and price. Provide both default and parameterized constructors.
package constructor;
public class Book {

    // Instance variables (attributes)
    String title;
    String author;
    double price;

    // Default Constructor
    public Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    // Parameterized Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price  : ₹" + price);
    }

    // Main method to test the class
    public static void main(String[] args) {

        // Using default constructor
        Book book1 = new Book();
        book1.displayBookDetails();

        System.out.println("---------------------");

        // Using parameterized constructor
        Book book2 = new Book("Java Programming", "James Gosling", 499.99);
        book2.displayBookDetails();
    }
}

