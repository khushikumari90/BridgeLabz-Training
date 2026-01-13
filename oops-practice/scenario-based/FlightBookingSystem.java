import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Flight {
    int flightId;
    String source;
    String destination;
    double price;

    Flight(int flightId, String source, String destination, double price) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    void display() {
        System.out.println(flightId + " | " + source + " -> " + destination + " | ₹" + price);
    }
}

class Booking {
    String passengerName;
    Flight flight;

    Booking(String passengerName, Flight flight) {
        this.passengerName = passengerName;
        this.flight = flight;
    }

    void displayBooking() {
        System.out.println("Passenger: " + passengerName);
        flight.display();
        System.out.println("------------------------");
    }
}

public class FlightBookingSystem {

    // Array to store available flights
    static Flight[] flights = {
            new Flight(101, "Delhi", "Mumbai", 5500),
            new Flight(102, "Delhi", "Bangalore", 6500),
            new Flight(103, "Mumbai", "Chennai", 6000),
            new Flight(104, "Delhi", "Kolkata", 5000)
    };

    // List to store bookings
    static List<Booking> bookings = new ArrayList<>();

    // Search flights (case-insensitive)
    static void searchFlights(String source, String destination) {
        boolean found = false;
        for (Flight f : flights) {
            if (f.source.equalsIgnoreCase(source) &&
                f.destination.equalsIgnoreCase(destination)) {
                f.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No flights found!");
        }
    }

    // Book flight
    static void bookFlight(int flightId, String passengerName) {
        for (Flight f : flights) {
            if (f.flightId == flightId) {
                bookings.add(new Booking(passengerName, f));
                System.out.println("Flight booked successfully!");
                return;
            }
        }
        System.out.println("Invalid Flight ID!");
    }

    // View bookings
    static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }
        for (Booking b : bookings) {
            b.displayBooking();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Flight Booking System ---");
            System.out.println("1. Search Flights");
            System.out.println("2. Book Flight");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Source: ");
                    String source = sc.nextLine();
                    System.out.print("Enter Destination: ");
                    String dest = sc.nextLine();
                    searchFlights(source, dest);
                    break;

                case 2:
                    System.out.print("Enter Passenger Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Flight ID: ");
                    int id = sc.nextInt();
                    bookFlight(id, name);
                    break;

                case 3:
                    viewBookings();
                    break;

                case 4:
                    System.out.println("Thank you for using Flight Booking System!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        sc.close();
    }
}
