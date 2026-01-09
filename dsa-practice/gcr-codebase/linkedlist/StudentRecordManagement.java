package linkedlist;
//Student Record Management using Singly Linked List

class Student {
 int rollNo;
 String name;
 int age;
 String grade;
 Student next;

 public Student(int rollNo, String name, int age, String grade) {
     this.rollNo = rollNo;
     this.name = name;
     this.age = age;
     this.grade = grade;
     this.next = null;
 }
}

class StudentLinkedList {
 private Student head;

 // Add at beginning
 public void addAtBeginning(int rollNo, String name, int age, String grade) {
     Student newStudent = new Student(rollNo, name, age, grade);
     newStudent.next = head;
     head = newStudent;
 }

 // Add at end
 public void addAtEnd(int rollNo, String name, int age, String grade) {
     Student newStudent = new Student(rollNo, name, age, grade);
     if (head == null) {
         head = newStudent;
         return;
     }
     Student temp = head;
     while (temp.next != null) {
         temp = temp.next;
     }
     temp.next = newStudent;
 }

 // Add at specific position (1-based index)
 public void addAtPosition(int position, int rollNo, String name, int age, String grade) {
     if (position <= 0) {
         System.out.println("Invalid position!");
         return;
     }
     Student newStudent = new Student(rollNo, name, age, grade);
     if (position == 1) {
         newStudent.next = head;
         head = newStudent;
         return;
     }
     Student temp = head;
     for (int i = 1; temp != null && i < position - 1; i++) {
         temp = temp.next;
     }
     if (temp == null) {
         System.out.println("Position out of range!");
         return;
     }
     newStudent.next = temp.next;
     temp.next = newStudent;
 }

 // Delete by Roll Number
 public void deleteByRollNo(int rollNo) {
     if (head == null) {
         System.out.println("List is empty!");
         return;
     }
     if (head.rollNo == rollNo) {
         head = head.next;
         System.out.println("Record deleted.");
         return;
     }
     Student temp = head;
     while (temp.next != null && temp.next.rollNo != rollNo) {
         temp = temp.next;
     }
     if (temp.next == null) {
         System.out.println("Record not found!");
     } else {
         temp.next = temp.next.next;
         System.out.println("Record deleted.");
     }
 }

 // Search by Roll Number
 public void searchByRollNo(int rollNo) {
     Student temp = head;
     while (temp != null) {
         if (temp.rollNo == rollNo) {
             System.out.println("Found: RollNo=" + temp.rollNo + ", Name=" + temp.name +
                     ", Age=" + temp.age + ", Grade=" + temp.grade);
             return;
         }
         temp = temp.next;
     }
     System.out.println("Record not found!");
 }

 // Update grade by Roll Number
 public void updateGrade(int rollNo, String newGrade) {
     Student temp = head;
     while (temp != null) {
         if (temp.rollNo == rollNo) {
             temp.grade = newGrade;
             System.out.println("Grade updated successfully.");
             return;
         }
         temp = temp.next;
     }
     System.out.println("Record not found!");
 }

 // Display all records
 public void displayRecords() {
     if (head == null) {
         System.out.println("No records to display.");
         return;
     }
     Student temp = head;
     System.out.println("Student Records:");
     while (temp != null) {
         System.out.println("RollNo=" + temp.rollNo + ", Name=" + temp.name +
                 ", Age=" + temp.age + ", Grade=" + temp.grade);
         temp = temp.next;
     }
 }
}

public class StudentRecordManagement {
 public static void main(String[] args) {
     StudentLinkedList list = new StudentLinkedList();

     // Adding records
     list.addAtBeginning(101, "Alice", 20, "A");
     list.addAtEnd(102, "Bob", 21, "B");
     list.addAtPosition(2, 103, "Charlie", 22, "C");

     // Display records
     list.displayRecords();

     // Search record
     list.searchByRollNo(102);

     // Update grade
     list.updateGrade(103, "A+");

     // Delete record
     list.deleteByRollNo(101);

     // Display after deletion
     list.displayRecords();
 }
}