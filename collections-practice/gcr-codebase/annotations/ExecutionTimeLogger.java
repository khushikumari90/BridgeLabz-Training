package annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Create Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

// Step 2: Class with Methods
class PerformanceTest {

    @LogExecutionTime
    public void fastMethod() {
        for (int i = 0; i < 1_000; i++) {
            Math.sqrt(i);
        }
    }

    @LogExecutionTime
    public void slowMethod() {
        for (int i = 0; i < 5_000; i++) {
            Math.sqrt(i);
        }
    }

    public void normalMethod() {
        System.out.println("Normal method (no logging)");
    }
}

// Step 3: Measure Execution Time Using Reflection
public class ExecutionTimeLogger {
    public static void main(String[] args) throws Exception {

        PerformanceTest test = new PerformanceTest();
        Method[] methods = PerformanceTest.class.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(LogExecutionTime.class)) {

                long startTime = System.nanoTime();
                method.invoke(test);          // execute method
                long endTime = System.nanoTime();

                long executionTime = endTime - startTime;

                System.out.println(
                    "Method: " + method.getName() +
                    " | Execution Time: " + executionTime + " ns"
                );
            }
        }
    }
}
