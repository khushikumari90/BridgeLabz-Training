package cabBooking;
public class PeakFare implements FareCalculator {

    @Override
    public double calculateFare(double distance) {
        return distance * 15; // ₹15 per km (peak pricing)
    }
}

