package annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Container annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// Step 2: Repeatable annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

// Step 3: Use repeatable annotation
class Software {

    @BugReport(description = "NullPointerException on login")
    @BugReport(description = "UI crash on submit button")
    public void process() {
        System.out.println("Processing software task...");
    }
}

// Step 4: Read annotations using Reflection
public class RepeatableAnnotationMain {
    public static void main(String[] args) throws Exception {

        Method method = Software.class.getMethod("process");

        BugReport[] reports = method.getAnnotationsByType(BugReport.class);

        for (BugReport report : reports) {
            System.out.println("Bug: " + report.description());
        }
    }
}
