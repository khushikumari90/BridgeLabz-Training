package hotelReservationSystem;

public class HotelApp {

    public static void main(String[] args) {

        Hotel hotel = new Hotel();

        hotel.addRoom(new StandardRoom(101));
        hotel.addRoom(new DeluxeRoom(201));

        Guest guest1 = new Guest(1, "Rahul");

        try {
            hotel.bookRoom(guest1, 3, new SeasonalPricing());
        } catch (RoomNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
