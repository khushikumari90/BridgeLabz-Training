package hotelReservationSystem;

public class Guest {
    private int guestId;
    private String name;

    public Guest(int guestId, String name) {
        this.guestId = guestId;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
