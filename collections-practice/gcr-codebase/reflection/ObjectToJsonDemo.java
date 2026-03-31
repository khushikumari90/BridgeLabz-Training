package reflection;
import java.lang.reflect.Field;

class MyStudent {
    private String name;
    private int age;
    private String course;

    public MyStudent(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }
}

public class ObjectToJsonDemo {

    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder("{");

        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                json.append("\"")
                    .append(field.getName())
                    .append("\":");

                // Add quotes if the field type is String
                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }
                json.append(",");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // Remove last comma
        if (json.charAt(json.length() - 1) == ',') {
            json.deleteCharAt(json.length() - 1);
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) {

        MyStudent student = new MyStudent("Khushi", 22, "MCA");

        String jsonOutput = toJson(student);
        System.out.println(jsonOutput);
    }
}
