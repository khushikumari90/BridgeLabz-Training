//Program 5:University Student Management
package keyword;
public class Student {

    static String universityName = "Global University";
    static int totalStudents = 0;

    private final int rollNumber;
    private String name;
    private String grade;

    Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    void updateGrade(String newGrade) {
        this.grade = newGrade;
        System.out.println("Grade updated to: " + newGrade);
    }

    void displayStudent(Object obj) {
        if (obj instanceof Student) {
            System.out.println("University Name: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(101, "Hemashree", "A");
        Student s2 = new Student(102, "Sharmila", "B");

        Student.displayTotalStudents();
        s1.displayStudent(s1);
        s2.displayStudent(s2);

        s2.updateGrade("A");
        s2.displayStudent(s2);
    }
}

