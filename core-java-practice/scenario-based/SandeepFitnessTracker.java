package scenariobased;
public class SandeepFitnessTracker {

	public static void main(String[] args) {
		 // Push-ups completed each day (0 indicates rest day)
        int[] pushUpsPerDay = {30, 0, 40, 50, 0, 60, 45};

        int totalPushUps = 0;
        int workoutDays = 0;

        // for-each loop to calculate total and average
        for (int pushUps : pushUpsPerDay) {

            // Skip rest days
            if (pushUps == 0) {
                continue;
            }

            totalPushUps += pushUps;
            workoutDays++;
        }

        double average = (double) totalPushUps / workoutDays;

        System.out.println("Total Push-ups in the week: " + totalPushUps);
        System.out.println("Average Push-ups per workout day: " + average);

	}

}
