package reflection;
import java.lang.reflect.Method;

class Calculator {

    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethodDemo {

    public static void main(String[] args) throws Exception {

        Calculator calculator = new Calculator();

        // Step 1: Get Class object
        Class<?> cls = calculator.getClass();

        // Step 2: Access private method
        Method method = cls.getDeclaredMethod("multiply", int.class, int.class);
        method.setAccessible(true); // allow access to private method

        // Step 3: Invoke private method
        int result = (int) method.invoke(calculator, 5, 4);

        // Step 4: Display result
        System.out.println("Result of multiplication: " + result);
    }
}
