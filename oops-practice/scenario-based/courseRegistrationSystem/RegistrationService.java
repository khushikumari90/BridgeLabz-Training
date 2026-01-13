package courseRegistrationSystem;

public interface RegistrationService {
    void registerCourse(Student student, Course course) throws CourseLimitExceededException;
    void dropCourse(Student student, String courseId);
    void assignGrade(Student student, String courseId, String grade);
    void viewGrades(Student student);
}

