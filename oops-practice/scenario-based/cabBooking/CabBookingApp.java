package cabBooking;

public class CabBookingApp {

    public static void main(String[] args) {

        RideService service = new RideService();

        service.addDriver(new Driver(1, "Ramesh"));
        service.addDriver(new Driver(2, "Suresh"));

        User user1 = new User(101, "Amit");

        try {
            service.bookRide(user1, 8, new NormalFare());
            service.bookRide(user1, 5, new PeakFare());
        } catch (NoDriverAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }

        service.showRideHistory();
    }
}
