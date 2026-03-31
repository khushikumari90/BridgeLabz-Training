package annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Step 1: Create CacheResult Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

// Step 2: Class with Expensive Method
class Calculator {

    @CacheResult
    public int expensiveCalculation(int number) {
        System.out.println("Performing expensive calculation...");
        int result = 0;

        for (int i = 1; i <= number; i++) {
            result += i;
        }
        return result;
    }
}

// Step 3: Cache Manager
class CacheManager {

    private static final Map<String, Object> cache = new HashMap<>();

    public static Object invokeWithCache(
            Object obj,
            String methodName,
            Object... args
    ) throws Exception {

        Class<?> cls = obj.getClass();
        Method method = cls.getMethod(methodName, int.class);

        String cacheKey = methodName + "_" + args[0];

        // Check if method has @CacheResult
        if (method.isAnnotationPresent(CacheResult.class)) {

            if (cache.containsKey(cacheKey)) {
                System.out.println("Returning cached result...");
                return cache.get(cacheKey);
            }

            Object result = method.invoke(obj, args);
            cache.put(cacheKey, result);
            return result;
        }

        return method.invoke(obj, args);
    }
}

// Step 4: Test Class
public class CacheResultDemo {
    public static void main(String[] args) throws Exception {

        Calculator calculator = new Calculator();

        System.out.println("Result: " +
            CacheManager.invokeWithCache(calculator, "expensiveCalculation", 100));

        System.out.println("Result: " +
            CacheManager.invokeWithCache(calculator, "expensiveCalculation", 100));

        System.out.println("Result: " +
            CacheManager.invokeWithCache(calculator, "expensiveCalculation", 200));
    }
}
