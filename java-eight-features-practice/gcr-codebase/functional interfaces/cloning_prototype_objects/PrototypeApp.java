package cloning_prototype_objects;
public class PrototypeApp {
    public static void main(String[] args) {

        try {
            VehiclePrototype original =
                    new VehiclePrototype("Electric Sedan", 160);

            VehiclePrototype cloned =
                    (VehiclePrototype) original.clone();

            System.out.println("Original Model: " + original.model);
            System.out.println("Cloned Model: " + cloned.model);

            System.out.println("Are objects same? " + (original == cloned));

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
