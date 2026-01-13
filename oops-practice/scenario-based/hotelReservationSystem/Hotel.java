package hotelReservationSystem;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private List<Room> rooms = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    // CRUD: Add Room
    public void addRoom(Room room) {
        rooms.add(room);
        System.out.println("Room added: " + room.roomNumber);
    }

    // Book Room
    public void bookRoom(Guest guest, int nights,
                         PricingStrategy pricingStrategy)
            throws RoomNotAvailableException {

        for (Room r : rooms) {
            if (r.isAvailable()) {
                r.setAvailable(false);
                Reservation res =
                       new Reservation(r, guest, nights, pricingStrategy);
                reservations.add(res);
                System.out.println("Room booked successfully!");
                res.generateInvoice();
                return;
            }
        }
        throw new RoomNotAvailableException("No rooms available!");
    }

    // Check-out
    public void checkout(Room room) {
        room.setAvailable(true);
        System.out.println("Checked out successfully. Room available again.");
    }
}
