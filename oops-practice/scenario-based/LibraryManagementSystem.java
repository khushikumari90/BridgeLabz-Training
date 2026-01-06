package oopsscenariobased;
public class LibraryManagementSystem {

    static Book[] books = new Book[5];
    static int count = 0;

    static void addBook(String title, String author) {
        books[count++] = new Book(title, author, true);
    }

    static void displayBooks() {
        for (int i = 0; i < count; i++) {
            System.out.println(
                books[i].title + " | " +
                books[i].author + " | " +
                (books[i].isAvailable ? "Available" : "Checked Out")
            );
        }
    }

    static void searchBook(String keyword) {
        System.out.println("\nSearch Result:");
        for (int i = 0; i < count; i++) {
            if (books[i].title.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(books[i].title + " - " + books[i].author);
            }
        }
    }

    static void checkoutBook(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                if (books[i].isAvailable) {
                    books[i].isAvailable = false;
                    System.out.println("Book Checked Out Successfully");
                } else {
                    System.out.println("Book Already Checked Out");
                }
                return;
            }
        }
        System.out.println("Book Not Found");
    }

    public static void main(String[] args) {

        addBook("Java Programming", "James Gosling");
        addBook("Python Basics", "Guido van Rossum");
        addBook("Data Structures", "Mark Allen");

        displayBooks();
        searchBook("java");
        checkoutBook("Java Programming");
        displayBooks();
    }
}
