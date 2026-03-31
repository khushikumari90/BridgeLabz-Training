package smart_device_control_interface;

class AC implements SmartDevice{
	@Override
	public void turnOn() {
		System.out.println("AC is turned ON.");
	}
	@Override
	public void turnOff() {
		System.out.println("AC is turned OFF.");
	}
}
