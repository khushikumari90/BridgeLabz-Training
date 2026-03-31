package restaurant_reservation_system;
public class Reservation {
    private int tableNumber;
    private String customerName;
    private String timeSlot;

    public Reservation(int tableNumber, String customerName, String timeSlot) {
        this.tableNumber = tableNumber;
        this.customerName = customerName;
        this.timeSlot = timeSlot;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    @Override
    public String toString() {
        return "Table " + tableNumber + " reserved by " + customerName + " at " + timeSlot;
    }
}

