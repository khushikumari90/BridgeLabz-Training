//Create a program to find the bonus of 10 employees based on their years of service as well as the total bonus amount the 10-year-old company Zara has to pay as a bonus, along with the old and new salary.
package methods;
public class BonusOfEmployee {

    // Method to generate salary and years of service
    // 2D Array: [employee][0] = salary, [employee][1] = years of service
    public static int[][] generateEmployeeData(int employees) {
        int[][] data = new int[employees][2];

        for (int i = 0; i < employees; i++) {
            // Generate 5-digit salary (10000 to 99999)
            data[i][0] = (int) (Math.random() * 90000) + 10000;

            // Generate years of service (1 to 10)
            data[i][1] = (int) (Math.random() * 10) + 1;
        }
        return data;
    }

    // Method to calculate new salary and bonus
    // Returns 2D array: [employee][0] = bonus, [employee][1] = new salary
    public static double[][] calculateBonus(int[][] data) {
        double[][] result = new double[data.length][2];

        for (int i = 0; i < data.length; i++) {
            int salary = data[i][0];
            int years = data[i][1];

            double bonusRate = (years > 5) ? 0.05 : 0.02;
            double bonus = salary * bonusRate;
            double newSalary = salary + bonus;

            result[i][0] = bonus;
            result[i][1] = newSalary;
        }
        return result;
    }

    // Method to calculate and display totals in tabular format
    public static void displayReport(int[][] oldData, double[][] newData) {

        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.println("---------------------------------------------------------------------");
        System.out.println("Emp\tOld Salary\tYears\tBonus\t\tNew Salary");
        System.out.println("---------------------------------------------------------------------");

        for (int i = 0; i < oldData.length; i++) {
            System.out.printf("%d\t%d\t\t%d\t%.2f\t\t%.2f\n",
                    (i + 1),
                    oldData[i][0],
                    oldData[i][1],
                    newData[i][0],
                    newData[i][1]);

            totalOldSalary += oldData[i][0];
            totalBonus += newData[i][0];
            totalNewSalary += newData[i][1];
        }

        System.out.println("---------------------------------------------------------------------");
        System.out.printf("TOTAL\t%.2f\t\t\t%.2f\t\t%.2f\n",
                totalOldSalary, totalBonus, totalNewSalary);
        System.out.println("---------------------------------------------------------------------");
    }

    // Main Method
    public static void main(String[] args) {

        int employees = 10;

        int[][] employeeData = generateEmployeeData(employees);
        double[][] bonusData = calculateBonus(employeeData);

        displayReport(employeeData, bonusData);
    }

}
