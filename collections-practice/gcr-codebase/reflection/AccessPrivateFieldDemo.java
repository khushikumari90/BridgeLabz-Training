package reflection;
import java.lang.reflect.Field;

class Person {

    private int age = 20;

    public void showAge() {
        System.out.println("Age: " + age);
    }
}

public class AccessPrivateFieldDemo {

    public static void main(String[] args) throws Exception {

        Person person = new Person();

        // Before modification
        person.showAge();

        // Step 1: Get Class object
        Class<?> cls = person.getClass();

        // Step 2: Access private field
        Field field = cls.getDeclaredField("age");
        field.setAccessible(true); // allow access to private field

        // Step 3: Modify private field value
        field.set(person, 30);

        // Step 4: Retrieve private field value
        int updatedAge = (int) field.get(person);

        System.out.println("Updated Age (via Reflection): " + updatedAge);

        // After modification
        person.showAge();
    }
}
