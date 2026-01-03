//School System with Different Roles
package inheritance;
//Superclass
class Person {
 String name;
 int age;

 Person(String name, int age) {
     this.name = name;
     this.age = age;
 }

 void displayInfo() {
     System.out.println("Name: " + name);
     System.out.println("Age: " + age);
 }
}

//Subclass 1
class Teacher extends Person {
 String subject;

 Teacher(String name, int age, String subject) {
     super(name, age);
     this.subject = subject;
 }

 void displayRole() {
     System.out.println("Role: Teacher");
     System.out.println("Subject: " + subject);
 }
}

//Subclass 2
class Student extends Person {
 String grade;

 Student(String name, int age, String grade) {
     super(name, age);
     this.grade = grade;
 }

 void displayRole() {
     System.out.println("Role: Student");
     System.out.println("Grade: " + grade);
 }
}

//Subclass 3
class Staff extends Person {
 String department;

 Staff(String name, int age, String department) {
     super(name, age);
     this.department = department;
 }

 void displayRole() {
     System.out.println("Role: Staff");
     System.out.println("Department: " + department);
 }
}

//Main class
public class SchoolSystemTest {
 public static void main(String[] args) {

     Teacher t = new Teacher("Anita", 35, "Mathematics");
     t.displayInfo();
     t.displayRole();

     System.out.println();

     Student s = new Student("Rahul", 16, "10th Grade");
     s.displayInfo();
     s.displayRole();

     System.out.println();

     Staff st = new Staff("Ramesh", 40, "Administration");
     st.displayInfo();
     st.displayRole();
 }
}

