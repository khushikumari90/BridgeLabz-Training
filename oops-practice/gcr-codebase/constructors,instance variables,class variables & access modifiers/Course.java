//Problem 2: Online Course Management
package constructor;
public class Course {

    // Instance variables (unique for each course)
    String courseName;
    int duration;        // duration in months
    double fee;

    // Class variable (common for all courses)
    static String instituteName = "ABC Institute";

    // Parameterized constructor
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    void displayCourseDetails() {
        System.out.println("Course Name    : " + courseName);
        System.out.println("Duration       : " + duration + " months");
        System.out.println("Fee            : ₹" + fee);
        System.out.println("Institute Name : " + instituteName);
        System.out.println("--------------------------------");
    }

    // Class (static) method to update institute name
    static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }

    // Main method to test the class
    public static void main(String[] args) {

        Course c1 = new Course("Java Full Stack", 6, 45000);
        Course c2 = new Course("Data Science", 8, 65000);

        c1.displayCourseDetails();
        c2.displayCourseDetails();

        // Update institute name for all courses
        Course.updateInstituteName("XYZ Technology Academy");

        System.out.println("\nAfter Updating Institute Name:\n");

        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}

