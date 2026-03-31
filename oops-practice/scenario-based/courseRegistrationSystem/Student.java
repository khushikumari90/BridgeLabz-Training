package courseRegistrationSystem;

import java.util.*;

public class Student extends Person {
    private List<Course> enrolledCourses;
    private Map<String, String> grades;

    public Student(int id, String name) {
        super(id, name);
        enrolledCourses = new ArrayList<>();
        grades = new HashMap<>();
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public Map<String, String> getGrades() {
        return grades;
    }

    public void addCourse(Course course) {
        enrolledCourses.add(course);
    }

    public void removeCourse(String courseId) {
        enrolledCourses.removeIf(c -> c.getCourseId().equals(courseId));
    }

    public void addGrade(String courseId, String grade) {
        grades.put(courseId, grade);
    }
}

