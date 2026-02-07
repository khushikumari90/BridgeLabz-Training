package password_strength_validator;
public class PasswordValidatorTest {
    public static void main(String[] args) {

        String password = "Secure@123";

        if (SecurityUtils.isStrongPassword(password)) {
            System.out.println("Password is strong ");
        } else {
            System.out.println("Password is weak ");
        }
    }
}
