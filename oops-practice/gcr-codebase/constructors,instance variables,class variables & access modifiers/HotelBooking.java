//Hotel Booking System: Create a HotelBooking class with attributes guestName, roomType, and nights. Use default, parameterized, and copy constructors to initialize bookings.
package constructor;
public class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    // 1️⃣ Default constructor
    HotelBooking() {
        guestName = "Guest";
        roomType = "Standard";
        nights = 1;
    }

    // 2️⃣ Parameterized constructor
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // 3️⃣ Copy constructor
    HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    // Method to display booking details
    void displayBooking() {
        System.out.println("Guest Name : " + guestName);
        System.out.println("Room Type  : " + roomType);
        System.out.println("Nights     : " + nights);
    }

    public static void main(String[] args) {

        // Using default constructor
        HotelBooking booking1 = new HotelBooking();

        // Using parameterized constructor
        HotelBooking booking2 =
                new HotelBooking("Amit Sharma", "Deluxe", 3);

        // Using copy constructor
        HotelBooking booking3 =
                new HotelBooking(booking2);

        System.out.println("Default Booking:");
        booking1.displayBooking();

        System.out.println("\nParameterized Booking:");
        booking2.displayBooking();

        System.out.println("\nCopied Booking:");
        booking3.displayBooking();
    }
}
