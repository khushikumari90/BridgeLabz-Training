//Problem 2: Book Library System
package constructor;
public class BookLibrarySystem {

    // Parent Class
    static class Book {

        // Access Modifiers
        public String ISBN;        // public
        protected String title;    // protected
        private String author;     // private

        // Constructor
        Book(String ISBN, String title, String author) {
            this.ISBN = ISBN;
            this.title = title;
            this.author = author;
        }

        // Setter method for private author
        public void setAuthor(String author) {
            this.author = author;
        }

        // Getter method for private author
        public String getAuthor() {
            return author;
        }
    }

    // Child Class
    static class EBook extends Book {

        String format;

        EBook(String ISBN, String title, String author, String format) {
            super(ISBN, title, author);
            this.format = format;
        }

        // Method to demonstrate access
        void displayEBookDetails() {
            System.out.println("ISBN: " + ISBN);          // public
            System.out.println("Title: " + title);        // protected
            System.out.println("Author: " + getAuthor()); // private via method
            System.out.println("Format: " + format);
        }
    }

    // Main Method
    public static void main(String[] args) {

        EBook ebook = new EBook(
                "978-0135166307",
                "Core Java",
                "Herbert Schildt",
                "PDF");

        // Modify private author using setter
        ebook.setAuthor("H. Schildt");

        // Display details
        ebook.displayEBookDetails();
    }
}
