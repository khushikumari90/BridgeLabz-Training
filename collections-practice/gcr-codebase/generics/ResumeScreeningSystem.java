package generics;
import java.util.*;

//Abstract Class
abstract class JobRole {
 String name;

 JobRole(String name) {
     this.name = name;
 }

 abstract void evaluateSkills();
}

//Concrete Job Roles
class SoftwareEngineer extends JobRole {
 SoftwareEngineer(String name) {
     super(name);
 }

 void evaluateSkills() {
     System.out.println(name + " screened for Java, DSA, OOPS");
 }
}

class DataScientist extends JobRole {
 DataScientist(String name) {
     super(name);
 }

 void evaluateSkills() {
     System.out.println(name + " screened for Python, ML, Statistics");
 }
}

class ProductManager extends JobRole {
 ProductManager(String name) {
     super(name);
 }

 void evaluateSkills() {
     System.out.println(name + " screened for Strategy, Communication");
 }
}

//STEP 3: Generic Class with Bounded Type
class Resume<T extends JobRole> {

 T role;

 Resume(T role) {
     this.role = role;
 }

 // Generic method
 void screenResume() {
     System.out.println("AI Screening Resume...");
     role.evaluateSkills();
 }
}

//Wildcard Method
class ScreeningPipeline {

 static void processAll(List<? extends JobRole> roles) {
     for (JobRole r : roles) {
         r.evaluateSkills();
     }
 }
}

//Main Class
public class ResumeScreeningSystem {
 public static void main(String[] args) {

     Resume<SoftwareEngineer> r1 =
             new Resume<>(new SoftwareEngineer("Alice"));

     Resume<DataScientist> r2 =
             new Resume<>(new DataScientist("Bob"));

     Resume<ProductManager> r3 =
             new Resume<>(new ProductManager("Charlie"));

     r1.screenResume();
     r2.screenResume();
     r3.screenResume();

     System.out.println("\nAI Screening Pipeline:");

     List<JobRole> candidates = new ArrayList<>();
     candidates.add(new SoftwareEngineer("David"));
     candidates.add(new DataScientist("Eva"));
     candidates.add(new ProductManager("Frank"));

     ScreeningPipeline.processAll(candidates);
 }
}
