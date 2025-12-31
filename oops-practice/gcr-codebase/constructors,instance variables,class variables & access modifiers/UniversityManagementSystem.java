//Problem 1: University Management System
package constructor;
public class UniversityManagementSystem {

    // Parent Class
    static class Student {

        public int rollNumber;      // public
        protected String name;      // protected
        private double CGPA;        // private

        // Constructor
        Student(int rollNumber, String name, double CGPA) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.CGPA = CGPA;
        }

        // Getter for CGPA
        public double getCGPA() {
            return CGPA;
        }

        // Setter for CGPA
        public void setCGPA(double CGPA) {
            this.CGPA = CGPA;
        }
    }

    // Child Class
    static class PostgraduateStudent extends Student {

        String specialization;

        PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
            super(rollNumber, name, CGPA);
            this.specialization = specialization;
        }

        void displayDetails() {
            System.out.println("Roll Number: " + rollNumber);   // public
            System.out.println("Name: " + name);                // protected
            System.out.println("Specialization: " + specialization);
            System.out.println("CGPA: " + getCGPA());            // private via method
        }
    }

    // Main Method
    public static void main(String[] args) {

        PostgraduateStudent pgStudent =
                new PostgraduateStudent(101, "Khushi", 8.5, "Computer Science");

        // Modify private CGPA using public method
        pgStudent.setCGPA(9.0);

        // Display all details
        pgStudent.displayDetails();
    }
}
