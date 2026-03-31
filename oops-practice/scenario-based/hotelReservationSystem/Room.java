package hotelReservationSystem;

public abstract class Room {
    protected int roomNumber;
    protected boolean available = true;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean status) {
        this.available = status;
    }

    public abstract double getBasePrice();
}
