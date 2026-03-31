//Educational Course Hierarchy
package inheritance;
//Base class
class Course {
 String courseName;
 int duration; // in weeks

 Course(String courseName, int duration) {
     this.courseName = courseName;
     this.duration = duration;
 }
}

//Subclass
class OnlineCourse extends Course {
 String platform;
 boolean isRecorded;

 OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
     super(courseName, duration);
     this.platform = platform;
     this.isRecorded = isRecorded;
 }
}

//Subclass of OnlineCourse
class PaidOnlineCourse extends OnlineCourse {
 double fee;
 double discount;

 PaidOnlineCourse(String courseName, int duration, String platform,
                  boolean isRecorded, double fee, double discount) {
     super(courseName, duration, platform, isRecorded);
     this.fee = fee;
     this.discount = discount;
 }

 void displayCourseDetails() {
     System.out.println("Course Name: " + courseName);
     System.out.println("Duration: " + duration + " weeks");
     System.out.println("Platform: " + platform);
     System.out.println("Recorded: " + isRecorded);
     System.out.println("Fee: ₹" + fee);
     System.out.println("Discount: " + discount + "%");
 }
}

//Main class
public class CourseSystem {
 public static void main(String[] args) {

     PaidOnlineCourse course = new PaidOnlineCourse(
             "Java Full Stack",
             12,
             "Udemy",
             true,
             5000,
             20
     );

     course.displayCourseDetails();
 }
}
