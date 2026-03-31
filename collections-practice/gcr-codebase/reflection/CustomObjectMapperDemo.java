package reflection;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Sample class
class Student1 {

    private String name;
    private int age;
    private String course;

    public void display() {
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Course : " + course);
    }
}

// Object Mapper Utility
class ObjectMapper {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {

        try {
            // Create object dynamically
            T obj = clazz.getDeclaredConstructor().newInstance();

            // Iterate over map entries
            for (Map.Entry<String, Object> entry : properties.entrySet()) {

                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                // Access field
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);

                // Set value to field
                field.set(obj, fieldValue);
            }

            return obj;

        } catch (Exception e) {
            throw new RuntimeException("Error while mapping object", e);
        }
    }
}

// Test Class
public class CustomObjectMapperDemo {

    public static void main(String[] args) {

        Map<String, Object> data = new HashMap<>();
        data.put("name", "Khushi");
        data.put("age", 22);
        data.put("course", "MCA");

        Student1 student = ObjectMapper.toObject(Student1.class, data);
        student.display();
    }
}
