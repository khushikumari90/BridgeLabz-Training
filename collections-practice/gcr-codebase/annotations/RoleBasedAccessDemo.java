package annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Create RoleAllowed Annotation (Class-Level)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface RoleAllowed {
    String value();
}

// Step 2: Secure Class
@RoleAllowed("ADMIN")
class AdminService {

    public void createUser() {
        System.out.println("User created successfully.");
    }

    public void deleteUser() {
        System.out.println("User deleted successfully.");
    }
}

// Step 3: Role Validation and Method Invocation
public class RoleBasedAccessDemo {

    // Simulated current user role
    private static String currentUserRole = "USER"; // change to ADMIN

    public static void main(String[] args) throws Exception {

        AdminService service = new AdminService();
        Class<?> cls = service.getClass();

        // Check if class has RoleAllowed annotation
        if (cls.isAnnotationPresent(RoleAllowed.class)) {

            RoleAllowed roleAllowed = cls.getAnnotation(RoleAllowed.class);

            if (!currentUserRole.equals(roleAllowed.value())) {
                System.out.println("Access Denied!");
                return;
            }
        }

        // Access granted → invoke methods
        for (Method method : cls.getDeclaredMethods()) {
            method.invoke(service);
        }
    }
}
