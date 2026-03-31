package reflection;
import java.lang.reflect.Method;

//Sample class with methods
class MathOperations1 {

 public void fastOperation() {
     for (int i = 0; i < 1_000; i++) {
         Math.sqrt(i);
     }
 }

 public void slowOperation() {
     for (int i = 0; i < 5_000; i++) {
         Math.sqrt(i);
     }
 }

 public int add(int a, int b) {
     return a + b;
 }
}

//Class to measure execution time
public class MethodTimingReflection {

 public static void main(String[] args) throws Exception {

     MathOperations1 obj = new MathOperations1();
     Class<?> cls = obj.getClass();

     Method[] methods = cls.getDeclaredMethods();

     for (Method method : methods) {

         // Skip methods with parameters (optional)
         if (method.getParameterCount() > 0) continue;

         long startTime = System.nanoTime();
         method.invoke(obj);
         long endTime = System.nanoTime();

         long executionTime = endTime - startTime;

         System.out.println("Method: " + method.getName() +
                 " | Execution time: " + executionTime + " ns");
     }
 }
}
