package map_interface;
import java.time.LocalDate;
import java.util.*;

class Policy {
    int policyNumber;
    String policyHolderName;
    LocalDate expiryDate;

    Policy(int policyNumber, String policyHolderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
    }

    public String toString() {
        return "PolicyNumber=" + policyNumber +
               ", Holder=" + policyHolderName +
               ", Expiry=" + expiryDate;
    }
}

public class InsurancePolicyManagementSystem {

    // 1. Store policies
    static HashMap<Integer, Policy> policyMap = new HashMap<>();
    static LinkedHashMap<Integer, Policy> insertionOrderMap = new LinkedHashMap<>();
    static TreeMap<LocalDate, List<Policy>> expiryDateMap = new TreeMap<>();

    // Add policy
    static void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        insertionOrderMap.put(policy.policyNumber, policy);

        expiryDateMap.putIfAbsent(policy.expiryDate, new ArrayList<>());
        expiryDateMap.get(policy.expiryDate).add(policy);
    }

    // Retrieve policy by number
    static Policy getPolicy(int policyNumber) {
        return policyMap.get(policyNumber);
    }

    // List policies expiring within next 30 days
    static void listExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        System.out.println("Policies expiring in next 30 days:");
        for (Map.Entry<LocalDate, List<Policy>> entry : expiryDateMap.entrySet()) {
            if (!entry.getKey().isBefore(today) && !entry.getKey().isAfter(limit)) {
                for (Policy p : entry.getValue()) {
                    System.out.println(p);
                }
            }
        }
    }

    // List policies by policyholder name
    static void listByPolicyHolder(String name) {
        System.out.println("Policies for " + name + ":");
        for (Policy p : policyMap.values()) {
            if (p.policyHolderName.equalsIgnoreCase(name)) {
                System.out.println(p);
            }
        }
    }

    // Remove expired policies
    static void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<Integer, Policy>> iterator = policyMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Policy p = iterator.next().getValue();
            if (p.expiryDate.isBefore(today)) {
                iterator.remove();
                insertionOrderMap.remove(p.policyNumber);
                expiryDateMap.get(p.expiryDate).remove(p);
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        addPolicy(new Policy(101, "Alice", LocalDate.now().plusDays(10)));
        addPolicy(new Policy(102, "Bob", LocalDate.now().plusDays(40)));
        addPolicy(new Policy(103, "Alice", LocalDate.now().minusDays(5)));
        addPolicy(new Policy(104, "Carol", LocalDate.now().plusDays(20)));

        // Retrieve policy
        System.out.println("Retrieve Policy 101:");
        System.out.println(getPolicy(101));
        System.out.println();

        // Policies expiring soon
        listExpiringSoon();
        System.out.println();

        // Policies by policyholder
        listByPolicyHolder("Alice");
        System.out.println();

        // Remove expired policies
        removeExpiredPolicies();
        System.out.println("Policies after removing expired:");
        for (Policy p : policyMap.values()) {
            System.out.println(p);
        }
    }
}
