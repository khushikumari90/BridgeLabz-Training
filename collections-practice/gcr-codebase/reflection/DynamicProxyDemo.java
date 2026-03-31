package reflection;
import java.lang.reflect.*;

//Step 1: Interface
interface Greeting {
 void sayHello(String name);
 void sayGoodbye(String name);
}

//Step 2: Implementation
class GreetingImpl implements Greeting {
 public void sayHello(String name) {
     System.out.println("Hello, " + name + "!");
 }
 public void sayGoodbye(String name) {
     System.out.println("Goodbye, " + name + "!");
 }
}

//Step 3: Logging Proxy Handler
class LoggingHandler implements InvocationHandler {

 private final Object target;

 public LoggingHandler(Object target) {
     this.target = target;
 }

 @Override
 public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

     // Log method name before execution
     System.out.println("[LOG] Method called: " + method.getName());

     // Execute actual method
     return method.invoke(target, args);
 }
}

//Step 4: Test Class
public class DynamicProxyDemo {

 public static void main(String[] args) {

     // Original object
     GreetingImpl original = new GreetingImpl();

     // Create proxy
     Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
             GreetingImpl.class.getClassLoader(),
             new Class[]{Greeting.class},
             new LoggingHandler(original)
     );

     // Method calls via proxy
     proxyInstance.sayHello("Khushi");
     proxyInstance.sayGoodbye("Khushi");
 }
}
