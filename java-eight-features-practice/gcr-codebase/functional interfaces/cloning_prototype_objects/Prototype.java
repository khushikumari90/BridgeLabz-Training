package cloning_prototype_objects;
class VehiclePrototype implements Cloneable {

    String model;
    int maxSpeed;

    VehiclePrototype(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    // Overriding clone() method
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();   // shallow copy
    }
}
