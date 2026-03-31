package hotelReservationSystem;

public class Reservation {
    private Room room;
    private Guest guest;
    private int nights;
    private double totalAmount;

    public Reservation(Room room, Guest guest, int nights,
                       PricingStrategy pricingStrategy) {
        this.room = room;
        this.guest = guest;
        this.nights = nights;
        this.totalAmount =
                pricingStrategy.calculatePrice(room.getBasePrice(), nights);
    }

    public void generateInvoice() {
        System.out.println("Invoice");
        System.out.println("Guest: " + guest.getName());
        System.out.println("Room No: " + room.roomNumber);
        System.out.println("Nights: " + nights);
        System.out.println("Total Amount: ₹" + totalAmount);
    }
}
