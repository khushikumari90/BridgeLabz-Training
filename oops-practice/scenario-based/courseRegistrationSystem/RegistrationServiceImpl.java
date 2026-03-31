package courseRegistrationSystem;

public class RegistrationServiceImpl implements RegistrationService {

    private static final int MAX_COURSES = 3;

    @Override
    public void registerCourse(Student student, Course course) 
            throws CourseLimitExceededException {

        if (student.getEnrolledCourses().size() >= MAX_COURSES) {
            throw new CourseLimitExceededException("Maximum course limit reached!");
        }
        student.addCourse(course);
        System.out.println("Course registered: " + course);
    }

    @Override
    public void dropCourse(Student student, String courseId) {
        student.removeCourse(courseId);
        System.out.println("Course dropped: " + courseId);
    }

    @Override
    public void assignGrade(Student student, String courseId, String grade) {
        student.addGrade(courseId, grade);
        System.out.println("Grade assigned for " + courseId);
    }

    @Override
    public void viewGrades(Student student) {
        System.out.println("\nGrades:");
        student.getGrades().forEach(
            (course, grade) -> System.out.println(course + " : " + grade)
        );
    }
}

