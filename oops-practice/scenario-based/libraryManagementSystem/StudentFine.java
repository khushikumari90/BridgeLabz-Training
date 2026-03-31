package libraryManagementSystem;

public class StudentFine implements FineCalculator {

    @Override
    public double calculateFine(int lateDays) {
        return lateDays * 2; // ₹2 per day
    }
}
