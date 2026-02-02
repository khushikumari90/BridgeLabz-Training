package reflection;
import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocationDemo {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            MathOperations operations = new MathOperations();

            System.out.print("Enter method name (add / subtract / multiply): ");
            String methodName = scanner.nextLine();

            System.out.print("Enter first number: ");
            int a = scanner.nextInt();

            System.out.print("Enter second number: ");
            int b = scanner.nextInt();

            // Step 1: Get Class object
            Class<?> cls = operations.getClass();

            // Step 2: Get method dynamically
            Method method = cls.getMethod(methodName, int.class, int.class);

            // Step 3: Invoke method dynamically
            Object result = method.invoke(operations, a, b);

            // Step 4: Display result
            System.out.println("Result: " + result);

        } catch (NoSuchMethodException e) {
            System.out.println("Invalid method name!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

