package smart_device_control_interface;

public class SmartHomeApp {
    public static void main(String args[]) {
    	SmartDevice light=new Lights();
    	SmartDevice ac=new AC();
    	SmartDevice tv=new TV();
    	light.turnOn();
    	light.turnOff();
    	ac.turnOn();
    	ac.turnOff();
    	tv.turnOn();
    	tv.turnOff();
    }
}
