package library;

public class LibraryApp {
    public static void main(String[] args) {

        // Singleton
        LibraryCatalog catalog = LibraryCatalog.getInstance();

        // Factory
        User student = UserFactory.createUser("student", "Khushi");
        User faculty = UserFactory.createUser("faculty", "Dr. Riya");

        student.showRole();
        faculty.showRole();

        // Observer
        catalog.addObserver(student);
        catalog.addObserver(faculty);

        // Builder
        Book book = new Book.BookBuilder("Data Structures")
                .author("Cormen")
                .edition("3rd")
                .genre("Computer Science")
                .publisher("MIT Press")
                .build();

        // Trigger notification
        catalog.addBook(book);
    }
}
