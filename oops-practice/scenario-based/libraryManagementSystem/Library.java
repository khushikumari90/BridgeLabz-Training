package libraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

    // CRUD: Add Book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    // CRUD: Register Member
    public void registerMember(Member member) {
        members.add(member);
        System.out.println("Member registered: " + member.getName());
    }

    // Issue Book
    public void issueBook(int bookId, Member member, String date)
            throws BookNotAvailableException {

        for (Book b : books) {
            if (b.getBookId() == bookId && b.isAvailable()) {
                b.setAvailable(false);
                Transaction t = new Transaction(b, member, date);
                transactions.add(t);
                t.displayTransaction();
                return;
            }
        }
        throw new BookNotAvailableException("Book not available!");
    }

    // Return Book
    public void returnBook(int bookId, int lateDays) {
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                b.setAvailable(true);

                FineCalculator fineCalculator;
                if (lateDays > 0) {
                    fineCalculator = lateDays > 0 ?
                            new StudentFine() : new StaffFine();
                    System.out.println("Late Fine: ₹"
                            + fineCalculator.calculateFine(lateDays));
                }
                System.out.println("Book returned: " + b.getTitle());
                return;
            }
        }
    }

    public void showTransactions() {
        System.out.println("\n Transaction History:");
        for (Transaction t : transactions) {
            t.displayTransaction();
        }
    }
}
