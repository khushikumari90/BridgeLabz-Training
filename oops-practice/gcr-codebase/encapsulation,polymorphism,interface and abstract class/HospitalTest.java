package Encapsulation;
//Interface
interface MedicalRecord {
 void addRecord(String record);
 void viewRecords();
}

//Abstract class
abstract class Patient {
 protected int patientId;
 protected String name;
 protected int age;
 private String medicalHistory; // encapsulation

 public Patient(int id, String name, int age) {
     this.patientId = id;
     this.name = name;
     this.age = age;
 }

 abstract double calculateBill();

 public void getPatientDetails() {
     System.out.println("ID: " + patientId + ", Name: " + name + ", Age: " + age);
 }

 protected void setMedicalHistory(String history) {
     medicalHistory = history;
 }

 protected String getMedicalHistory() {
     return medicalHistory;
 }
}

class InPatient extends Patient implements MedicalRecord {
 public InPatient(int id, String name, int age) {
     super(id, name, age);
 }

 public double calculateBill() {
     return 5000;
 }

 public void addRecord(String record) {
     setMedicalHistory(record);
 }

 public void viewRecords() {
     System.out.println("Medical History: " + getMedicalHistory());
 }
}

class OutPatient extends Patient {
 public OutPatient(int id, String name, int age) {
     super(id, name, age);
 }

 public double calculateBill() {
     return 800;
 }
}

//Test
public class HospitalTest {
 public static void main(String[] args) {
     Patient p = new InPatient(1, "Rahul", 30);
     p.getPatientDetails();
     System.out.println("Bill: ₹" + p.calculateBill());
 }
}
