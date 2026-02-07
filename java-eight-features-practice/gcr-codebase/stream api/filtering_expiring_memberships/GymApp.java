package filtering_expiring_memberships;
import java.time.LocalDate;
import java.util.*;

public class GymApp {
    public static void main(String[] args) {

        List<GymMember> members = Arrays.asList(
            new GymMember("Amit", LocalDate.now().plusDays(10)),
            new GymMember("Neha", LocalDate.now().plusDays(40)),
            new GymMember("Rahul", LocalDate.now().plusDays(25)),
            new GymMember("Sneha", LocalDate.now().minusDays(5))
        );

        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        members.stream()
               .filter(m ->
                   !m.expiryDate.isBefore(today) &&
                    m.expiryDate.isBefore(next30Days)
               )
               .forEach(System.out::println);
    }
}
