package hotelReservationSystem;

public class StandardRoom extends Room {

    public StandardRoom(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public double getBasePrice() {
        return 2000;
    }
}
