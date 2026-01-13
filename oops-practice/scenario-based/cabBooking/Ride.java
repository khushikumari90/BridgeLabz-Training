package cabBooking;

public class Ride {
    private User user;
    private Driver driver;
    private double distance;
    private double fare;

    public Ride(User user, Driver driver, double distance, FareCalculator fareCalculator) {
        this.user = user;
        this.driver = driver;
        this.distance = distance;
        this.fare = fareCalculator.calculateFare(distance);
    }

    public void displayRide() {
        System.out.println("User: " + user.getName()
                + " | Driver: " + driver.getName()
                + " | Distance: " + distance + " km"
                + " | Fare: ₹" + fare);
    }
}
