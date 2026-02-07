package smart_device_control_interface;

class Lights implements SmartDevice {
	 @Override
     public void turnOn() {
    	 System.out.println("Lights is turned ON.");
     }
	 @Override
	 public void turnOff() {
		 System.out.println("Lights is turned OFF.");
	 }
}
