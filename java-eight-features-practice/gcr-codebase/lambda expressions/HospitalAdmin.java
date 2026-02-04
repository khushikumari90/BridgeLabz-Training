package lambda_expressions;
import java.util.Arrays;
import java.util.List;

class Patient {
    int patientId;

    Patient(int patientId) {
        this.patientId = patientId;
    }

    int getPatientId() {
        return patientId;
    }
}

public class HospitalAdmin {
    public static void main(String[] args) {

        List<Patient> patients = Arrays.asList(
                new Patient(201),
                new Patient(202),
                new Patient(203)
        );

        // Method Reference used instead of lambda
        patients.stream()
                .map(Patient::getPatientId)
                .forEach(System.out::println);
    }
}
