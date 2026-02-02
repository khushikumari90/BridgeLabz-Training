package annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define custom annotation
@Retention(RetentionPolicy.RUNTIME)   // Needed for reflection
@Target(ElementType.METHOD)            // Can be used on methods
@interface TaskInfo {
    String priority();
    String assignedTo();
}

// Step 2: Use annotation in a class
class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Khushi")
    public void completeTask() {   // ✅ MUST be public for getMethod()
        System.out.println("Task is being completed...");
    }
}

// Step 3: Retrieve annotation using Reflection
public class CustomAnnotationMain {
    public static void main(String[] args) throws Exception {

        TaskManager manager = new TaskManager();

        // getMethod() finds ONLY public methods
        Method method = manager.getClass().getMethod("completeTask");

        // Check if annotation is present
        if (method.isAnnotationPresent(TaskInfo.class)) {

            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

            System.out.println("Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }
    }
}
