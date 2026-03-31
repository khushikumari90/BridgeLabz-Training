//Program 2:Library Management System
package keyword;
public class Book {

    // Static variable
    static String libraryName = "Egmore Library";

    // Final variable
    private final String isbn;

    private String title;
    private String author;

    // Constructor using this
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Static method
    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    void displayBookDetails(Object obj) {
        if (obj instanceof Book) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
    }

    public static void main(String[] args) {
        Book book = new Book("Effective Java", "Joshua Bloch", "978-0134685991");

        Book.displayLibraryName();
        book.displayBookDetails(book);
    }
}

