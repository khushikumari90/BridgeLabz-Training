package scenario_based;
import java.util.*;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;
        Book b = (Book) obj;
        return title.equals(b.title) && author.equals(b.author);
    }

    @Override
    public int hashCode() {
        return title.hashCode() + author.hashCode();
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}

public class BookShelf {

    static HashMap<String, LinkedList<Book>> library = new HashMap<>();
    static HashSet<Book> bookSet = new HashSet<>();

    // Return / Add book
    static void addBook(String genre, Book book) {
        if (bookSet.contains(book)) {
            System.out.println("Duplicate book not allowed");
            return;
        }
        library.putIfAbsent(genre, new LinkedList<>());
        library.get(genre).add(book);
        bookSet.add(book);
    }

    // Borrow / Remove book
    static void removeBook(String genre, Book book) {
        if (library.containsKey(genre)) {
            library.get(genre).remove(book);
            bookSet.remove(book);
        }
    }

    static void display() {
        for (String genre : library.keySet()) {
            System.out.println("Genre: " + genre);
            for (Book b : library.get(genre)) {
                System.out.println("  " + b);
            }
        }
    }

    public static void main(String[] args) {
        Book b1 = new Book("Harry Potter", "J.K. Rowling");
        Book b2 = new Book("The Hobbit", "J.R.R. Tolkien");

        addBook("Fantasy", b1);
        addBook("Fantasy", b2);
        addBook("Fantasy", b1); // duplicate

        display();

        removeBook("Fantasy", b1);

        display();
    }
}
