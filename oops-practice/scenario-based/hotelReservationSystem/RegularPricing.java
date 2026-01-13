package hotelReservationSystem;

public class RegularPricing implements PricingStrategy {

    @Override
    public double calculatePrice(double basePrice, int nights) {
        return basePrice * nights;
    }
}
