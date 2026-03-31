package annotations;
import java.lang.annotation.*;
import java.lang.reflect.Field;

// Step 1: Create @MaxLength Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

// Step 2: User Class with Validation
class User {

    @MaxLength(10)
    private String username;

    public User(String username) {
        validateMaxLength(username);
        this.username = username;
    }

    private void validateMaxLength(String value) {
        try {
            Field field = this.getClass().getDeclaredField("username");

            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);

                if (value.length() > maxLength.value()) {
                    throw new IllegalArgumentException(
                        "Username length must not exceed " + maxLength.value()
                    );
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}

// Step 3: Test Class
public class MaxLengthValidationDemo {
    public static void main(String[] args) {

        User user1 = new User("Khushi");   // Valid
        System.out.println("User created: " + user1.getUsername());

        User user2 = new User("VeryLongUsername"); // Exception
        System.out.println("User created: " + user2.getUsername());
    }
}
