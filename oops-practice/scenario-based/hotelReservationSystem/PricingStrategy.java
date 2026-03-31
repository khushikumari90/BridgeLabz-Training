package hotelReservationSystem;

public interface PricingStrategy {
    double calculatePrice(double basePrice, int nights);
}
