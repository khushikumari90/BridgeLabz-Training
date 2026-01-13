package courseRegistrationSystem;

public class MainApp {
    public static void main(String[] args) {

        Student student = new Student(101, "Khushi");
        RegistrationService service = new RegistrationServiceImpl();

        Course c1 = new Course("C101", "Java");
        Course c2 = new Course("C102", "DBMS");
        Course c3 = new Course("C103", "Operating Systems");
        Course c4 = new Course("C104", "Computer Networks");

        try {
            service.registerCourse(student, c1);
            service.registerCourse(student, c2);
            service.registerCourse(student, c3);
            service.registerCourse(student, c4); // Exception
        } catch (CourseLimitExceededException e) {
            System.out.println("Error: " + e.getMessage());
        }

        service.assignGrade(student, "C101", "A");
        service.assignGrade(student, "C102", "B+");

        service.viewGrades(student);

        service.dropCourse(student, "C102");
    }
}

