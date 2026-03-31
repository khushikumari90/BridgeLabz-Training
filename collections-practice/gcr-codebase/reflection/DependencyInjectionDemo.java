package reflection;
import java.lang.annotation.*;
import java.lang.reflect.Field;

// Step 1: Define @Inject Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {
}

// Step 2: Dependency Classes
class Engine {
    public void start() {
        System.out.println("Engine started...");
    }
}

class Tires {
    public void inflate() {
        System.out.println("Tires inflated...");
    }
}

// Step 3: Consumer Class with Dependencies
class Car {

    @Inject
    private Engine engine;

    @Inject
    private Tires tires;

    public void drive() {
        engine.start();
        tires.inflate();
        System.out.println("Car is ready to drive!");
    }
}

// Step 4: Simple DI Container
class SimpleDIContainer {

    public static <T> T initialize(Class<T> clazz) {

        try {
            // Create instance of class
            T instance = clazz.getDeclaredConstructor().newInstance();

            // Iterate over fields
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {

                    // Create instance of dependency
                    Object dependency = field.getType().getDeclaredConstructor().newInstance();

                    field.setAccessible(true);
                    field.set(instance, dependency);
                }
            }

            return instance;

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize DI container", e);
        }
    }
}

// Step 5: Test Class
public class DependencyInjectionDemo {

    public static void main(String[] args) {

        Car car = SimpleDIContainer.initialize(Car.class);
        car.drive();
    }
}
