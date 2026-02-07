package filtering_expiring_memberships;
import java.time.LocalDate;

class GymMember {
    String name;
    LocalDate expiryDate;

    GymMember(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return name + " - Expires on: " + expiryDate;
    }
}
