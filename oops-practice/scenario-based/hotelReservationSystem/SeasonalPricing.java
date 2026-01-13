package hotelReservationSystem;

public class SeasonalPricing implements PricingStrategy {

    @Override
    public double calculatePrice(double basePrice, int nights) {
        return basePrice * nights * 1.2; // 20% seasonal hike
    }
}

