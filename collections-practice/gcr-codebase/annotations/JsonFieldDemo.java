package annotations;
import java.lang.annotation.*;
import java.lang.reflect.Field;

// Step 1: Create JsonField Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

// Step 2: User Class
class MyUser {

    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    private String password; // not serialized

    public MyUser(String username, int age, String password) {
        this.username = username;
        this.age = age;
        this.password = password;
    }
}

// Step 3: Custom JSON Serializer
class JsonSerializer {

    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder("{");

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);

                try {
                    json.append("\"")
                        .append(annotation.name())
                        .append("\":\"")
                        .append(field.get(obj))
                        .append("\",");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        // Remove last comma
        if (json.charAt(json.length() - 1) == ',') {
            json.deleteCharAt(json.length() - 1);
        }

        json.append("}");
        return json.toString();
    }
}

// Step 4: Test Class
public class JsonFieldDemo {
    public static void main(String[] args) {

        MyUser user = new MyUser("Khushi", 22, "secret123");

        String jsonOutput = JsonSerializer.toJson(user);
        System.out.println(jsonOutput);
    }
}
