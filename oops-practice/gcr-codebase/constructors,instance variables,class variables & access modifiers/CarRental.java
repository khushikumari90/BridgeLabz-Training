//Car Rental System: Create a CarRental class with attributes customerName, carModel, and rentalDays. Add constructors to initialize the rental details and calculate total cost.
package constructor;
public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double totalCost;

    // Cost per day (can vary by model in real systems)
    static final double COST_PER_DAY = 1500.0;

    // 1️ Default constructor
    CarRental() {
        customerName = "Customer";
        carModel = "Hatchback";
        rentalDays = 1;
        calculateTotalCost();
    }

    // 2️ Parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        calculateTotalCost();
    }

    // Method to calculate total rental cost
    void calculateTotalCost() {
        totalCost = rentalDays * COST_PER_DAY;
    }

    // Method to display rental details
    void displayRentalDetails() {
        System.out.println("Customer Name : " + customerName);
        System.out.println("Car Model     : " + carModel);
        System.out.println("Rental Days   : " + rentalDays);
        System.out.println("Total Cost    : ₹" + totalCost);
    }

    public static void main(String[] args) {

        // Using default constructor
        CarRental rental1 = new CarRental();

        // Using parameterized constructor
        CarRental rental2 =
                new CarRental("Neha Verma", "SUV", 5);

        System.out.println("Default Rental:");
        rental1.displayRentalDetails();

        System.out.println("\nParameterized Rental:");
        rental2.displayRentalDetails();
    }
}

