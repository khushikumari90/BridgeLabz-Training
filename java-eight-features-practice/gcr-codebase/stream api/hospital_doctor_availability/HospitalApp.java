package hospital_doctor_availability;
import java.util.*;

public class HospitalApp {
    public static void main(String[] args) {

        List<Doctor> doctors = Arrays.asList(
            new Doctor("Dr. Sharma", "Cardiology", true),
            new Doctor("Dr. Mehta", "Orthopedics", false),
            new Doctor("Dr. Khan", "Dermatology", true),
            new Doctor("Dr. Iyer", "Neurology", true),
            new Doctor("Dr. Singh", "Pediatrics", false)
        );

        doctors.stream()

            // filter doctors available on weekends
            .filter(d -> d.availableOnWeekend)

            // sort by specialty (A → Z)
            .sorted(Comparator.comparing(d -> d.specialty))

            .forEach(System.out::println);
    }
}
