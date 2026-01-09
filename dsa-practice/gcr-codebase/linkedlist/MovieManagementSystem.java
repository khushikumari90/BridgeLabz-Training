package linkedlist;
//Movie Management System using Doubly Linked List

class Movie {
 String title;
 String director;
 int year;
 double rating;
 Movie next;
 Movie prev;

 public Movie(String title, String director, int year, double rating) {
     this.title = title;
     this.director = director;
     this.year = year;
     this.rating = rating;
     this.next = null;
     this.prev = null;
 }
}

class MovieDoublyLinkedList {
 private Movie head;
 private Movie tail;

 // Add at beginning
 public void addAtBeginning(String title, String director, int year, double rating) {
     Movie newMovie = new Movie(title, director, year, rating);
     if (head == null) {
         head = tail = newMovie;
     } else {
         newMovie.next = head;
         head.prev = newMovie;
         head = newMovie;
     }
 }

 // Add at end
 public void addAtEnd(String title, String director, int year, double rating) {
     Movie newMovie = new Movie(title, director, year, rating);
     if (tail == null) {
         head = tail = newMovie;
     } else {
         tail.next = newMovie;
         newMovie.prev = tail;
         tail = newMovie;
     }
 }

 // Add at specific position (1-based index)
 public void addAtPosition(int position, String title, String director, int year, double rating) {
     if (position <= 0) {
         System.out.println("Invalid position!");
         return;
     }
     Movie newMovie = new Movie(title, director, year, rating);
     if (position == 1) {
         addAtBeginning(title, director, year, rating);
         return;
     }
     Movie temp = head;
     for (int i = 1; temp != null && i < position - 1; i++) {
         temp = temp.next;
     }
     if (temp == null || temp.next == null) {
         addAtEnd(title, director, year, rating);
     } else {
         newMovie.next = temp.next;
         newMovie.prev = temp;
         temp.next.prev = newMovie;
         temp.next = newMovie;
     }
 }

 // Remove by Movie Title
 public void removeByTitle(String title) {
     if (head == null) {
         System.out.println("List is empty!");
         return;
     }
     Movie temp = head;
     while (temp != null && !temp.title.equalsIgnoreCase(title)) {
         temp = temp.next;
     }
     if (temp == null) {
         System.out.println("Movie not found!");
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
     System.out.println("Movie removed successfully.");
 }

 // Search by Director
 public void searchByDirector(String director) {
     Movie temp = head;
     boolean found = false;
     while (temp != null) {
         if (temp.director.equalsIgnoreCase(director)) {
             System.out.println("Found: " + temp.title + " (" + temp.year + "), Rating: " + temp.rating);
             found = true;
         }
         temp = temp.next;
     }
     if (!found) System.out.println("No movies found for director: " + director);
 }

 // Search by Rating
 public void searchByRating(double rating) {
     Movie temp = head;
     boolean found = false;
     while (temp != null) {
         if (temp.rating == rating) {
             System.out.println("Found: " + temp.title + " (" + temp.year + "), Director: " + temp.director);
             found = true;
         }
         temp = temp.next;
     }
     if (!found) System.out.println("No movies found with rating: " + rating);
 }

 // Update Rating by Title
 public void updateRating(String title, double newRating) {
     Movie temp = head;
     while (temp != null) {
         if (temp.title.equalsIgnoreCase(title)) {
             temp.rating = newRating;
             System.out.println("Rating updated successfully.");
             return;
         }
         temp = temp.next;
     }
     System.out.println("Movie not found!");
 }

 // Display forward
 public void displayForward() {
     if (head == null) {
         System.out.println("No movies to display.");
         return;
     }
     System.out.println("Movies (Forward):");
     Movie temp = head;
     while (temp != null) {
         System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
         temp = temp.next;
     }
 }

 // Display reverse
 public void displayReverse() {
     if (tail == null) {
         System.out.println("No movies to display.");
         return;
     }
     System.out.println("Movies (Reverse):");
     Movie temp = tail;
     while (temp != null) {
         System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
         temp = temp.prev;
     }
 }
}

public class MovieManagementSystem {
 public static void main(String[] args) {
     MovieDoublyLinkedList list = new MovieDoublyLinkedList();

     // Adding movies
     list.addAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
     list.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
     list.addAtPosition(2, "The Dark Knight", "Christopher Nolan", 2008, 9.0);

     // Display movies
     list.displayForward();
     list.displayReverse();

     // Search
     list.searchByDirector("Christopher Nolan");
     list.searchByRating(8.6);

     // Update rating
     list.updateRating("Inception", 9.1);

     // Remove movie
     list.removeByTitle("Interstellar");

     // Display after removal
     list.displayForward();
 }
}