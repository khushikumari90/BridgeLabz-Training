//Library Mangement with Books and Authors
package inheritance;
//Superclass
class Book {
 String title;
 int publicationYear;

 // Constructor
 Book(String title, int publicationYear) {
     this.title = title;
     this.publicationYear = publicationYear;
 }

 // Method to display book info
 void displayInfo() {
     System.out.println("Book Title: " + title);
     System.out.println("Publication Year: " + publicationYear);
 }
}

//Subclass
class Author extends Book {
 String name;
 String bio;

 // Constructor
 Author(String title, int publicationYear, String name, String bio) {
     super(title, publicationYear); // calling parent constructor
     this.name = name;
     this.bio = bio;
 }

 // Overriding method
 void displayInfo() {
     super.displayInfo(); // call parent method
     System.out.println("Author Name: " + name);
     System.out.println("Author Bio: " + bio);
 }
}

//Main class
public class LibraryManagement {
 public static void main(String[] args) {

     Author book1 = new Author(
             "Java Programming",
             2023,
             "James Gosling",
             "Father of Java programming language"
     );

     book1.displayInfo();
 }
}

