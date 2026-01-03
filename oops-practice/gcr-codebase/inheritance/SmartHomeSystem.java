//Smart Home Devices
package inheritance;
//Superclass
class Device {
 String deviceId;
 String status;   // ON / OFF

 // Constructor
 Device(String deviceId, String status) {
     this.deviceId = deviceId;
     this.status = status;
 }

 // Method to display device status
 void displayStatus() {
     System.out.println("Device ID: " + deviceId);
     System.out.println("Status: " + status);
 }
}

//Subclass
class Thermostat extends Device {
 int temperatureSetting;

 // Constructor
 Thermostat(String deviceId, String status, int temperatureSetting) {
     super(deviceId, status); // call parent constructor
     this.temperatureSetting = temperatureSetting;
 }

 // Overriding method
 void displayStatus() {
     super.displayStatus(); // call superclass method
     System.out.println("Temperature Setting: " + temperatureSetting + "°C");
 }
}

//Main class
public class SmartHomeSystem {
 public static void main(String[] args) {

     Thermostat t1 = new Thermostat("TH101", "ON", 24);
     t1.displayStatus();
 }
}

