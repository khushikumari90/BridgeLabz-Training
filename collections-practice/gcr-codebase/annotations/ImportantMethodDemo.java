package annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Create Custom Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";   // optional parameter
}

// Step 2: Use the Annotation
class Service {

    @ImportantMethod
    public void processData() {
        System.out.println("Processing data...");
    }

    @ImportantMethod(level = "LOW")
    public void logActivity() {
        System.out.println("Logging activity...");
    }

    public void helperMethod() {
        System.out.println("Helper method");
    }
}

// Step 3: Use Reflection to Retrieve Annotation
public class ImportantMethodDemo {
    public static void main(String[] args) {

        Class<Service> cls = Service.class;

        for (Method method : cls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {

                ImportantMethod annotation =
                        method.getAnnotation(ImportantMethod.class);

                System.out.println("Method Name: " + method.getName());
                System.out.println("Importance Level: " + annotation.level());
                System.out.println("---------------------------");
            }
        }
    }
}
