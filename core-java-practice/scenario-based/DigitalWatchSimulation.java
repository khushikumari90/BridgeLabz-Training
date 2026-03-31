package scenariobased;
public class DigitalWatchSimulation {

	public static void main(String[] args) {
		// Outer loop for hours
        for (int hour = 0; hour < 24; hour++) {

            // Inner loop for minutes
            for (int minute = 0; minute < 60; minute++) {

                // Stop at 13:00 due to power cut
                if (hour == 13 && minute == 0) {
                    System.out.println("Power cut at 13:00!");
                    return; // Exit program
                }

                // Print time in HH:MM format
                System.out.printf("%02d:%02d\n", hour, minute);
            }
        }

	}

}
