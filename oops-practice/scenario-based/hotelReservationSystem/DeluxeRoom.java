package hotelReservationSystem;

public class DeluxeRoom extends Room {

    public DeluxeRoom(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public double getBasePrice() {
        return 3500;
    }
}
