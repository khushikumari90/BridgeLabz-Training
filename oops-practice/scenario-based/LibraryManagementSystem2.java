package oopsscenariobased;
import java.util.*;

class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String msg) {
        super(msg);
    }
}

class Book1 {
    String title;
    String author;
    boolean available;

    Book1(String title, String author, boolean available) {
        this.title = title;
        this.author = author;
        this.available = available;
    }
}

class Library {
    List<Book1> books = new ArrayList<>();

    public void addBooks(Book1[] bookArray) {
        books.addAll(Arrays.asList(bookArray));
    }

    public void searchByTitle(String keyword) {
        for (Book1 b : books) {
            if (b.title.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(b.title + " by " + b.author);
            }
        }
    }

    public void checkoutBook(String title) throws BookNotAvailableException {
        for (Book1 b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                if (!b.available) {
                    throw new BookNotAvailableException("Book is already checked out");
                }
                b.available = false;
                System.out.println("Book checked out successfully");
                return;
            }
        }
        System.out.println("Book not found");
    }
}

public class LibraryManagementSystem2 {
    public static void main(String[] args) throws Exception {
        Library lib = new Library();

        Book1[] bookArray = {
            new Book1("Java Basics", "James", true),
            new Book1("Data Structures", "Mark", true)
        };

        lib.addBooks(bookArray);
        lib.searchByTitle("Java");
        lib.checkoutBook("Java Basics");
    }
}
