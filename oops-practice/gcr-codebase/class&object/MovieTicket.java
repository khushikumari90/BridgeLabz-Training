package oop;

public class MovieTicket {
	// Attributes
    String movieName;
    String seatNumber;
    double price;
    boolean isBooked; // true if ticket is booked

    // Constructor
    MovieTicket() {
        isBooked = false;
    }

    // Method to book ticket
    void bookTicket(String movie, String seat, double ticketPrice) {
        if (!isBooked) {
            movieName = movie;
            seatNumber = seat;
            price = ticketPrice;
            isBooked = true;
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
        } else {
            System.out.println("House full!!! sorry..... Ticket already booked");
        }
    }

    // Method to display ticket details
    void displayTicket() {
        if (!isBooked) {
            System.out.println("Ticket have not booked yet....");
        } else {
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        }
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();

        // Initial display
        ticket.displayTicket();
        System.out.println();

        // Attempt to book tickets
        ticket.bookTicket("Dragon", "A10", 120.0);
        ticket.bookTicket("Dragon", "A10", 120.0); // already booked
        ticket.bookTicket("Dragon", "A10", 120.0); // already booked
        System.out.println();

        // Display final ticket details
        ticket.displayTicket();
    }

}
