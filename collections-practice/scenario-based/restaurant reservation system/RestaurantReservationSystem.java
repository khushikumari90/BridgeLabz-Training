package restaurant_reservation_system;
import java.util.*;

public class RestaurantReservationSystem {

    private Map<Integer, Table> tables = new HashMap<>();
    private List<Reservation> reservations = new ArrayList<>();

    public RestaurantReservationSystem() {
        tables.put(1, new Table(1, 2));
        tables.put(2, new Table(2, 4));
        tables.put(3, new Table(3, 6));
    }

    // Reserve Table
    public void reserveTable(int tableNumber, String customerName, String timeSlot)
            throws TableAlreadyReservedException {

        for (Reservation r : reservations) {
            if (r.getTableNumber() == tableNumber &&
                r.getTimeSlot().equalsIgnoreCase(timeSlot)) {
                throw new TableAlreadyReservedException(
                        "Table " + tableNumber + " is already reserved for " + timeSlot);
            }
        }

        reservations.add(new Reservation(tableNumber, customerName, timeSlot));
        System.out.println("✅ Reservation successful!");
    }

    // Cancel Reservation
    public void cancelReservation(int tableNumber, String timeSlot) {
        Iterator<Reservation> iterator = reservations.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Reservation r = iterator.next();
            if (r.getTableNumber() == tableNumber &&
                r.getTimeSlot().equalsIgnoreCase(timeSlot)) {
                iterator.remove();
                found = true;
                System.out.println("❌ Reservation cancelled.");
                break;
            }
        }

        if (!found) {
            System.out.println("⚠️ No reservation found.");
        }
    }

    // Show Available Tables
    public void showAvailableTables(String timeSlot) {
        System.out.println("Available tables for " + timeSlot + ":");

        for (Table table : tables.values()) {
            boolean isReserved = false;

            for (Reservation r : reservations) {
                if (r.getTableNumber() == table.getTableNumber() &&
                    r.getTimeSlot().equalsIgnoreCase(timeSlot)) {
                    isReserved = true;
                    break;
                }
            }

            if (!isReserved) {
                System.out.println(table);
            }
        }
    }

    // Main Method
    public static void main(String[] args) {
        RestaurantReservationSystem system = new RestaurantReservationSystem();

        try {
            system.reserveTable(1, "Khushi", "7PM-8PM");
            system.reserveTable(2, "Aman", "7PM-8PM");

            // Double booking attempt
            system.reserveTable(1, "Rahul", "7PM-8PM");

        } catch (TableAlreadyReservedException e) {
            System.out.println("❗ " + e.getMessage());
        }

        system.showAvailableTables("7PM-8PM");
        system.cancelReservation(1, "7PM-8PM");
        system.showAvailableTables("7PM-8PM");
    }
}
