
// ---------- Abstraction ----------
interface IPayable {
    double calculateBill();
}

// ---------- Base Class ----------
abstract class Patient implements IPayable {
    private int id;
    private String name;
    private int age;

    // Encapsulation
    public Patient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    // Polymorphism
    public abstract void displayInfo();
}

// ---------- Inheritance ----------
class InPatient extends Patient {
    private int days;
    private double dailyCharge;

    public InPatient(int id, String name, int age, int days, double dailyCharge) {
        super(id, name, age);
        this.days = days;
        this.dailyCharge = dailyCharge;
    }

    public double calculateBill() {
        return days * dailyCharge;
    }

    public void displayInfo() {
        System.out.println("InPatient | Name: " + getName() +
                " | Days: " + days +
                " | Bill: " + calculateBill());
    }
}

// ---------- Inheritance ----------
class OutPatient extends Patient {
    private double consultationFee;

    public OutPatient(int id, String name, int age, double consultationFee) {
        super(id, name, age);
        this.consultationFee = consultationFee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void displayInfo() {
        System.out.println("OutPatient | Name: " + getName() +
                " | Bill: " + calculateBill());
    }
}

// ---------- Doctor Class ----------
class Doctor {
    private int doctorId;
    private String doctorName;
    private String specialization;

    public Doctor(int doctorId, String doctorName, String specialization) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.specialization = specialization;
    }

    public void displayDoctor() {
        System.out.println("Doctor: " + doctorName +
                " | Specialization: " + specialization);
    }
}

// ---------- Bill Class ----------
class Bill {
    public static void generateBill(Patient patient) {
        System.out.println("Final Bill Amount: " + patient.calculateBill());
    }
}

// ---------- Main Class ----------
public class HospitalManagementSystem {
    public static void main(String[] args) {

        Doctor doctor = new Doctor(101, "Dr. Sharma", "Cardiology");
        doctor.displayDoctor();

        Patient p1 = new InPatient(1, "Ravi", 45, 4, 2000);
        Patient p2 = new OutPatient(2, "Anita", 30, 600);

        System.out.println("\nPatient Details:");
        p1.displayInfo();
        p2.displayInfo();

        System.out.println("\nBilling:");
        Bill.generateBill(p1);
        Bill.generateBill(p2);
    }
}
