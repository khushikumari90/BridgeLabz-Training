package linkedlist;
//Library Management System using Doubly Linked List

class Book {
 String title;
 String author;
 String genre;
 int bookId;
 boolean isAvailable;
 Book next;
 Book prev;

 public Book(int bookId, String title, String author, String genre, boolean isAvailable) {
     this.bookId = bookId;
     this.title = title;
     this.author = author;
     this.genre = genre;
     this.isAvailable = isAvailable;
     this.next = null;
     this.prev = null;
 }
}

class LibraryDoublyLinkedList {
 private Book head;
 private Book tail;

 // Add at beginning
 public void addAtBeginning(int bookId, String title, String author, String genre, boolean isAvailable) {
     Book newBook = new Book(bookId, title, author, genre, isAvailable);
     if (head == null) {
         head = tail = newBook;
     } else {
         newBook.next = head;
         head.prev = newBook;
         head = newBook;
     }
 }

 // Add at end
 public void addAtEnd(int bookId, String title, String author, String genre, boolean isAvailable) {
     Book newBook = new Book(bookId, title, author, genre, isAvailable);
     if (tail == null) {
         head = tail = newBook;
     } else {
         tail.next = newBook;
         newBook.prev = tail;
         tail = newBook;
     }
 }

 // Add at specific position (1-based index)
 public void addAtPosition(int position, int bookId, String title, String author, String genre, boolean isAvailable) {
     if (position <= 0) {
         System.out.println("Invalid position!");
         return;
     }
     if (position == 1) {
         addAtBeginning(bookId, title, author, genre, isAvailable);
         return;
     }
     Book newBook = new Book(bookId, title, author, genre, isAvailable);
     Book temp = head;
     for (int i = 1; temp != null && i < position - 1; i++) {
         temp = temp.next;
     }
     if (temp == null || temp.next == null) {
         addAtEnd(bookId, title, author, genre, isAvailable);
     } else {
         newBook.next = temp.next;
         newBook.prev = temp;
         temp.next.prev = newBook;
         temp.next = newBook;
     }
 }

 // Remove by Book ID
 public void removeByBookId(int bookId) {
     if (head == null) {
         System.out.println("Library is empty!");
         return;
     }
     Book temp = head;
     while (temp != null && temp.bookId != bookId) {
         temp = temp.next;
     }
     if (temp == null) {
         System.out.println("Book not found!");
         return;
     }
     if (temp == head) {
         head = head.next;
         if (head != null) head.prev = null;
         else tail = null;
     } else if (temp == tail) {
         tail = tail.prev;
         if (tail != null) tail.next = null;
         else head = null;
     } else {
         temp.prev.next = temp.next;
         temp.next.prev = temp.prev;
     }
     System.out.println("Book removed successfully.");
 }

 // Search by Book Title
 public void searchByTitle(String title) {
     Book temp = head;
     boolean found = false;
     while (temp != null) {
         if (temp.title.equalsIgnoreCase(title)) {
             System.out.println("Found: ID=" + temp.bookId + ", Title=" + temp.title +
                     ", Author=" + temp.author + ", Genre=" + temp.genre +
                     ", Available=" + temp.isAvailable);
             found = true;
         }
         temp = temp.next;
     }
     if (!found) System.out.println("No book found with title: " + title);
 }

 // Search by Author
 public void searchByAuthor(String author) {
     Book temp = head;
     boolean found = false;
     while (temp != null) {
         if (temp.author.equalsIgnoreCase(author)) {
             System.out.println("Found: ID=" + temp.bookId + ", Title=" + temp.title +
                     ", Author=" + temp.author + ", Genre=" + temp.genre +
                     ", Available=" + temp.isAvailable);
             found = true;
         }
         temp = temp.next;
     }
     if (!found) System.out.println("No book found by author: " + author);
 }

 // Update Availability Status
 public void updateAvailability(int bookId, boolean newStatus) {
     Book temp = head;
     while (temp != null) {
         if (temp.bookId == bookId) {
             temp.isAvailable = newStatus;
             System.out.println("Availability updated successfully.");
             return;
         }
         temp = temp.next;
     }
     System.out.println("Book not found!");
 }

 // Display forward
 public void displayForward() {
     if (head == null) {
         System.out.println("No books to display.");
         return;
     }
     System.out.println("Books (Forward):");
     Book temp = head;
     while (temp != null) {
         System.out.println("ID=" + temp.bookId + ", Title=" + temp.title +
                 ", Author=" + temp.author + ", Genre=" + temp.genre +
                 ", Available=" + temp.isAvailable);
         temp = temp.next;
     }
 }

 // Display reverse
 public void displayReverse() {
     if (tail == null) {
         System.out.println("No books to display.");
         return;
     }
     System.out.println("Books (Reverse):");
     Book temp = tail;
     while (temp != null) {
         System.out.println("ID=" + temp.bookId + ", Title=" + temp.title +
                 ", Author=" + temp.author + ", Genre=" + temp.genre +
                 ", Available=" + temp.isAvailable);
         temp = temp.prev;
     }
 }

 // Count total books
 public void countBooks() {
     int count = 0;
     Book temp = head;
     while (temp != null) {
         count++;
         temp = temp.next;
     }
     System.out.println("Total number of books: " + count);
 }
}

public class LibraryManagementSystem {
 public static void main(String[] args) {
     LibraryDoublyLinkedList library = new LibraryDoublyLinkedList();

     // Adding books
     library.addAtBeginning(101, "The Hobbit", "J.R.R. Tolkien", "Fantasy", true);
     library.addAtEnd(102, "1984", "George Orwell", "Dystopian", true);
     library.addAtPosition(2, 103, "To Kill a Mockingbird", "Harper Lee", "Classic", false);

     // Display books
     library.displayForward();
     library.displayReverse();

     // Search
     library.searchByTitle("1984");
     library.searchByAuthor("Harper Lee");

     // Update availability
     library.updateAvailability(103, true);

     // Remove book
     library.removeByBookId(101);

     // Display after removal
     library.displayForward();

     // Count books
     library.countBooks();
 }
}
