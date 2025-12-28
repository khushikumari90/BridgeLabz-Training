//Create a program to display a calendar for a given month and year. The program should take the month and year as input from the user and display the calendar for that month.
package strings;
import java.util.Scanner;
public class Calendar {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        displayCalendar(month, year);

        sc.close();


	}
    // Method to get month name
    public static String getMonthName(int month) {
        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return months[month - 1];
    }

    // Method to check leap year
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        return year % 4 == 0;
    }

    // Method to get number of days in a month
    public static int getDaysInMonth(int month, int year) {

        int[] days = {
            31, // Jan
            28, // Feb
            31, // Mar
            30, // Apr
            31, // May
            30, // Jun
            31, // Jul
            31, // Aug
            30, // Sep
            31, // Oct
            30, // Nov
            31  // Dec
        };

        // Check for leap year in February
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }

        return days[month - 1];
    }

    // Method to get first day of the month using Gregorian Calendar Algorithm
    // 0 = Sunday, 1 = Monday, ..., 6 = Saturday
    public static int getFirstDay(int month, int year) {

        int d = 1;   // Day = 1st of the month
        int m = month;
        int y = year;

        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;

        return d0;
    }

    // Method to display calendar
    public static void displayCalendar(int month, int year) {

        String monthName = getMonthName(month);
        int daysInMonth = getDaysInMonth(month, year);
        int firstDay = getFirstDay(month, year);

        // Display header
        System.out.println("\n   " + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // First loop: indentation before first day
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        // Second loop: display days of the month
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);

            // Move to next line after Saturday
            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }

}
