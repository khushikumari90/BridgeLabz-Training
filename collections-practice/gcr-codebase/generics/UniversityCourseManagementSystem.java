package generics;
import java.util.ArrayList;
import java.util.List;

/* ---------- Abstract Course Type ---------- */
abstract class CourseType {
    protected String evaluationType;

    public abstract String getEvaluationType();
}

/* ---------- Course Type Implementations ---------- */
class ExamCourse extends CourseType {
    public String getEvaluationType() {
        return "Exam Based Evaluation";
    }
}

class AssignmentCourse extends CourseType {
    public String getEvaluationType() {
        return "Assignment Based Evaluation";
    }
}

class ResearchCourse extends CourseType {
    public String getEvaluationType() {
        return "Research Based Evaluation";
    }
}

/* ---------- Generic Course Class ---------- */
class Course<T extends CourseType> {
    private String courseName;
    private String department;
    private T courseType;

    public Course(String courseName, String department, T courseType) {
        this.courseName = courseName;
        this.department = department;
        this.courseType = courseType;
    }

    public String getDetails() {
        return "Course: " + courseName +
               " | Department: " + department +
               " | Evaluation: " + courseType.getEvaluationType();
    }

    public T getCourseType() {
        return courseType;
    }
}

/* ---------- Utility Class Using Wildcards ---------- */
class UniversityUtil {
    public static void displayCourseTypes(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println("Evaluation Type: " + course.getEvaluationType());
        }
    }
}

/* ---------- Main Class ---------- */
public class UniversityCourseManagementSystem {
    public static void main(String[] args) {

        Course<ExamCourse> math =
                new Course<>("Mathematics", "Science", new ExamCourse());

        Course<AssignmentCourse> cs =
                new Course<>("Data Structures", "Computer Science", new AssignmentCourse());

        Course<ResearchCourse> phd =
                new Course<>("AI Research", "Research Dept", new ResearchCourse());

        System.out.println("---- Course Details ----");
        System.out.println(math.getDetails());
        System.out.println(cs.getDetails());
        System.out.println(phd.getDetails());

        /* Wildcard Usage */
        List<CourseType> courseTypes = new ArrayList<>();
        courseTypes.add(new ExamCourse());
        courseTypes.add(new AssignmentCourse());
        courseTypes.add(new ResearchCourse());

        System.out.println("\n---- Evaluation Types ----");
        UniversityUtil.displayCourseTypes(courseTypes);
    }
}
