package libraryManagementSystem;

public class Transaction {
    private Book book;
    private Member member;
    private String issueDate;

    public Transaction(Book book, Member member, String issueDate) {
        this.book = book;
        this.member = member;
        this.issueDate = issueDate;
    }

    public void displayTransaction() {
        System.out.println("Book: " + book.getTitle()
                + " | Issued to: " + member.getName()
                + " | Date: " + issueDate);
    }
}
