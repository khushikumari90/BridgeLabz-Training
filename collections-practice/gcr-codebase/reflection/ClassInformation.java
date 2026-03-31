package reflection;
import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInformation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter full class name: ");
        String className = scanner.nextLine();

        try {
            Class<?> cls = Class.forName(className);

            System.out.println("\n📌 Class Name: " + cls.getName());

            // Display Constructors
            System.out.println("\n🔹 Constructors:");
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> c : constructors) {
                System.out.println(c);
            }

            // Display Fields
            System.out.println("\n🔹 Fields:");
            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields) {
                System.out.println(f);
            }

            // Display Methods
            System.out.println("\n🔹 Methods:");
            Method[] methods = cls.getDeclaredMethods();
            for (Method m : methods) {
                System.out.println(m);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        }
        
        scanner.close();
    }
}
