package libraryManagementSystem;

public class LibraryApp {

    public static void main(String[] args) {

        Library library = new Library();

        Book b1 = new Book(101, "Java Programming");
        Book b2 = new Book(102, "Data Structures");

        Member m1 = new Member(1, "Amit", "Student");
        Member m2 = new Member(2, "Ravi", "Staff");

        library.addBook(b1);
        library.addBook(b2);

        library.registerMember(m1);
        library.registerMember(m2);

        try {
            library.issueBook(101, m1, "10-Jan-2026");
        } catch (BookNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }

        library.returnBook(101, 5);
        library.showTransactions();
    }
}
