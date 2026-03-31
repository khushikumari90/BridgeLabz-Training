package hospitalManagementSystem;

public class Doctor extends Person {
    private String specialization;

    public Doctor(int id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }

    @Override
    public double calculateConsultationFee() {
        return 500; // fixed doctor consultation fee
    }

    public String getName() {
        return name;
    }
}
