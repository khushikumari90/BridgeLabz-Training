package reflection;
import java.lang.reflect.Field;

class Configuration {

    private static String API_KEY = "DEFAULT_KEY";

    public static void showKey() {
        System.out.println("API_KEY: " + API_KEY);
    }
}

public class ModifyStaticFieldDemo {

    public static void main(String[] args) throws Exception {

        // Before modification
        Configuration.showKey();

        // Step 1: Get Class object
        Class<?> cls = Configuration.class;

        // Step 2: Access private static field
        Field field = cls.getDeclaredField("API_KEY");
        field.setAccessible(true); // allow access

        // Step 3: Modify static field value (object reference is null)
        field.set(null, "UPDATED_SECRET_KEY");

        // Step 4: Retrieve static field value
        String updatedKey = (String) field.get(null);

        System.out.println("Updated API_KEY (via Reflection): " + updatedKey);

        // After modification
        Configuration.showKey();
    }
}
