package reflection;
import java.lang.reflect.Constructor;

class Student {

    private String name;
    private int age;

    public Student() {
        this.name = "Default";
        this.age = 18;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class DynamicObjectCreationDemo {

    public static void main(String[] args) throws Exception {

        // Step 1: Load class dynamically
        Class<?> cls = Class.forName("Student");

        // Step 2: Get default constructor
        Constructor<?> constructor = cls.getDeclaredConstructor();

        // Step 3: Create object without using new keyword
        Object obj = constructor.newInstance();

        // Step 4: Type cast and use object
        Student student = (Student) obj;
        student.display();
    }
}
