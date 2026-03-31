//Cab Booking System:Key Features (CRUD)
package extraoopsscenariobased;
import java.util.*;

//---------- Exception ----------
class NoDriverAvailableException extends Exception {
 public NoDriverAvailableException(String msg) {
     super(msg);
 }
}

//---------- Interface ----------
interface FareCalculator {
 double calculateFare(double distance);
}

//---------- Normal Fare ----------
class NormalFareCalculator implements FareCalculator {
 public double calculateFare(double distance) {
     return distance * 10; // ₹10 per km
 }
}

//---------- Peak Fare ----------
class PeakFareCalculator implements FareCalculator {
 public double calculateFare(double distance) {
     return distance * 15; // ₹15 per km
 }
}

//---------- User ----------
class User {
 int id;
 String name;

 User(int id, String name) {
     this.id = id;
     this.name = name;
 }
}

//---------- Driver ----------
class Driver {
 int id;
 String name;
 boolean available = true;

 Driver(int id, String name) {
     this.id = id;
     this.name = name;
 }
}

//---------- Ride ----------
class Ride {
 User user;
 Driver driver;
 double distance;
 double fare;

 Ride(User user, Driver driver, double distance, double fare) {
     this.user = user;
     this.driver = driver;
     this.distance = distance;
     this.fare = fare;
 }

 void showRide() {
     System.out.println("User: " + user.name +
             ", Driver: " + driver.name +
             ", Distance: " + distance + " km" +
             ", Fare: ₹" + fare);
 }
}

//---------- Ride Service ----------
class RideService {
 List<Driver> drivers = new ArrayList<>();
 List<Ride> rideHistory = new ArrayList<>();

 RideService() {
     drivers.add(new Driver(1, "Amit"));
     drivers.add(new Driver(2, "Rohit"));
 }

 Ride bookRide(User user, double distance, boolean isPeak)
         throws NoDriverAvailableException {

     Driver assigned = null;
     for (Driver d : drivers) {
         if (d.available) {
             assigned = d;
             break;
         }
     }

     if (assigned == null) {
         throw new NoDriverAvailableException("No Driver Available!");
     }

     FareCalculator calculator =
             isPeak ? new PeakFareCalculator() : new NormalFareCalculator();

     double fare = calculator.calculateFare(distance);
     assigned.available = false;

     Ride ride = new Ride(user, assigned, distance, fare);
     rideHistory.add(ride);
     return ride;
 }

 void showHistory() {
     for (Ride r : rideHistory) {
         r.showRide();
     }
 }
}

//---------- Main Class ----------
public class CabBookingSystem {
 public static void main(String[] args) {

     RideService service = new RideService();
     User user = new User(101, "Khushi");

     try {
         Ride r1 = service.bookRide(user, 10, false);
         r1.showRide();

         Ride r2 = service.bookRide(user, 5, true);
         r2.showRide();

     } catch (NoDriverAvailableException e) {
         System.out.println(e.getMessage());
     }

     System.out.println("\nRide History:");
     service.showHistory();
 }
}
