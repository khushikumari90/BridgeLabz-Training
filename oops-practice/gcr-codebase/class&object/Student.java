package oop;

public class Student {

    // Attributes
    String name;
    String rollNumber;
    double mark1, mark2, mark3;

    // Method to calculate grade
    char calculateGrade() {
        double average = (mark1 + mark2 + mark3) / 3;

        if (average >= 75) {
            return 'A';
        } else if (average >= 60) {
            return 'B';
        } else {
            return 'C';
        }
    }

    // Method to display student details and grade
    void displayReport() {
        System.out.println("Student Name: " + name);
        System.out.println("Student RollNumber: " + rollNumber);
        System.out.println("Student Marks:");
        System.out.println("Mark1: " + mark1);
        System.out.println("Mark2: " + mark2);
        System.out.println("Mark3: " + mark3);
        System.out.println("Grade " + calculateGrade());
    }

    public static void main(String[] args) {
        // First Student
        Student s1 = new Student();
        s1.name = "Thamarai";
        s1.rollNumber = "ECE001";
        s1.mark1 = 80.0;
        s1.mark2 = 70.0;
        s1.mark3 = 75.0;

        // Second Student
        Student s2 = new Student();
        s2.name = "Kannan";
        s2.rollNumber = "CSC002";
        s2.mark1 = 60.0;
        s2.mark2 = 65.0;
        s2.mark3 = 50.0;

        // Display reports
        s1.displayReport();
        s2.displayReport();
    }


}
