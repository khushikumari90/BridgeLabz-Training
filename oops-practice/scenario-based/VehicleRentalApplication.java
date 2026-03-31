
import java.util.*;

// ---------- Interface ----------
interface IRentable {
    double calculateRent(int days);
}

// ---------- Base Class ----------
class Vehicle implements IRentable {
    protected int vehicleId;
    protected String model;
    protected double ratePerDay;

    public Vehicle(int vehicleId, String model, double ratePerDay) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.ratePerDay = ratePerDay;
    }

    public double calculateRent(int days) {
        return days * ratePerDay;
    }

    public void displayVehicle() {
        System.out.println(vehicleId + " | " + model + " | Rate/Day: " + ratePerDay);
    }
}

// ---------- Inheritance ----------
class Bike extends Vehicle {
    public Bike(int id, String model) {
        super(id, model, 300);
    }
}

class Car extends Vehicle {
    public Car(int id, String model) {
        super(id, model, 1000);
    }
}

class Truck extends Vehicle {
    public Truck(int id, String model) {
        super(id, model, 2000);
    }
}

// ---------- Customer Class ----------
class Customer {
    private int customerId;
    private String name;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public void displayCustomer() {
        System.out.println("Customer: " + name);
    }
}

// ---------- Main Class (CRUD Demo) ----------
public class VehicleRentalApplication {
    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();

        // CREATE
        vehicles.add(new Bike(1, "Yamaha"));
        vehicles.add(new Car(2, "Honda City"));
        vehicles.add(new Truck(3, "Tata"));

        Customer customer = new Customer(101, "Khushi");
        customer.displayCustomer();

        // READ
        System.out.println("\nAvailable Vehicles:");
        for (Vehicle v : vehicles) {
            v.displayVehicle();
        }

        // CALCULATE RENT
        System.out.println("\nRental Cost:");
        Vehicle selected = vehicles.get(1); // Car
        int days = 3;
        System.out.println("Rent for " + days + " days: " +
                selected.calculateRent(days));
    }
}

