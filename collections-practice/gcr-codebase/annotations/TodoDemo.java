package annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define @Todo Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();                  // mandatory
    String assignedTo();             // mandatory
    String priority() default "MEDIUM"; // optional
}

// Step 2: Apply Annotation on Methods
class ProjectTasks {

    @Todo(
        task = "Implement user authentication",
        assignedTo = "Amit",
        priority = "HIGH"
    )
    public void loginFeature() {
    }

    @Todo(
        task = "Add payment gateway integration",
        assignedTo = "Neha"
    )
    public void paymentFeature() {
    }

    @Todo(
        task = "Optimize database queries",
        assignedTo = "Rohit",
        priority = "LOW"
    )
    public void databaseOptimization() {
    }

    public void completedFeature() {
    }
}

// Step 3: Retrieve and Print Todos using Reflection
public class TodoDemo {
    public static void main(String[] args) {

        Class<ProjectTasks> cls = ProjectTasks.class;

        for (Method method : cls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {

                Todo todo = method.getAnnotation(Todo.class);

                System.out.println("Method Name  : " + method.getName());
                System.out.println("Task         : " + todo.task());
                System.out.println("Assigned To  : " + todo.assignedTo());
                System.out.println("Priority     : " + todo.priority());
                System.out.println("------------------------------");
            }
        }
    }
}
