package libraryManagementSystem;

public class StaffFine implements FineCalculator {

    @Override
    public double calculateFine(int lateDays) {
        return lateDays * 1; // ₹1 per day
    }
}
