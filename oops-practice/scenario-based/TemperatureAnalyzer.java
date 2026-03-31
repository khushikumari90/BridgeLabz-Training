//1. Scenario: You're analyzing a week’s worth of hourly temperature data stored in a 2D array (float[7][24]).
package oopsscenariobased;
public class TemperatureAnalyzer {

    private float[][] temperatures;

    // Constructor
    public TemperatureAnalyzer(float[][] temperatures) {
        this.temperatures = temperatures;
    }

    // Calculate average temperature per day
    public float[] calculateDailyAverage() {
        float[] avg = new float[7];

        for (int day = 0; day < 7; day++) {
            float sum = 0;
            for (int hour = 0; hour < 24; hour++) {
                sum += temperatures[day][hour];
            }
            avg[day] = sum / 24;
            System.out.println("Day " + (day + 1) + " Average Temperature: " + avg[day]);
        }
        return avg;
    }

    // Find hottest and coldest day
    public void findHottestAndColdestDay() {
        float[] avg = calculateDailyAverage();

        float hottest = avg[0];
        float coldest = avg[0];
        int hottestDay = 1;
        int coldestDay = 1;

        for (int i = 1; i < avg.length; i++) {
            if (avg[i] > hottest) {
                hottest = avg[i];
                hottestDay = i + 1;
            }
            if (avg[i] < coldest) {
                coldest = avg[i];
                coldestDay = i + 1;
            }
        }

        System.out.println("\nHottest Day: Day " + hottestDay + " (" + hottest + ")");
        System.out.println("Coldest Day: Day " + coldestDay + " (" + coldest + ")");
    }

    // Main method
    public static void main(String[] args) {

        float[][] weekData = new float[7][24];

        // Sample temperature data
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 24; j++) {
                weekData[i][j] = 20 + (float)(Math.random() * 10);
            }
        }

        TemperatureAnalyzer analyzer = new TemperatureAnalyzer(weekData);
        analyzer.findHottestAndColdestDay();
    }
}
