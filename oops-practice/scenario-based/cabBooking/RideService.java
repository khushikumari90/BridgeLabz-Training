package cabBooking;
import java.util.ArrayList;
import java.util.List;

public class RideService {
    private List<Driver> drivers = new ArrayList<>();
    private List<Ride> rideHistory = new ArrayList<>();

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public void bookRide(User user, double distance, FareCalculator fareCalculator)
            throws NoDriverAvailableException {

        for (Driver d : drivers) {
            if (d.isAvailable()) {
                d.setAvailable(false);
                Ride ride = new Ride(user, d, distance, fareCalculator);
                rideHistory.add(ride);
                ride.displayRide();
                return;
            }
        }
        throw new NoDriverAvailableException("No drivers available right now!");
    }

    public void showRideHistory() {
        System.out.println("\n  Ride History:");
        for (Ride r : rideHistory) {
            r.displayRide();
        }
    }
}
