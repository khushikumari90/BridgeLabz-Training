package set_interface;
import java.time.LocalDate;
import java.util.*;

public class InsurancePolicyManagementSystem {

    // Policy class to store policy details
    static class Policy implements Comparable<Policy> {

        String policyNumber;
        String policyHolderName;
        LocalDate expiryDate;
        String coverageType;
        double premiumAmount;

        // Constructor to initialize policy object
        public Policy(String policyNumber, String policyHolderName,
                      LocalDate expiryDate, String coverageType,
                      double premiumAmount) {

            this.policyNumber = policyNumber;
            this.policyHolderName = policyHolderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premiumAmount = premiumAmount;
        }

        // Policies are considered same if policy number is same
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Policy)) return false;
            Policy p = (Policy) o;
            return policyNumber.equals(p.policyNumber);
        }

        // Hash code based on policy number
        @Override
        public int hashCode() {
            return policyNumber.hashCode();
        }

        // Used by TreeSet to sort policies by expiry date
        @Override
        public int compareTo(Policy p) {
            return this.expiryDate.compareTo(p.expiryDate);
        }

        // To print policy details
        @Override
        public String toString() {
            return policyNumber + " | " + policyHolderName + " | "
                    + expiryDate + " | " + coverageType + " | ₹" + premiumAmount;
        }
    }

    public static void main(String[] args) {

        // HashSet for fast searching
        Set<Policy> hashSet = new HashSet<>();

        // LinkedHashSet keeps insertion order
        Set<Policy> linkedHashSet = new LinkedHashSet<>();

        // TreeSet sorts policies by expiry date
        Set<Policy> treeSet = new TreeSet<>();

        // Creating policy objects
        Policy p1 = new Policy("P101", "Amit",
                LocalDate.now().plusDays(20), "Health", 8000);

        Policy p2 = new Policy("P102", "Neha",
                LocalDate.now().plusDays(40), "Auto", 6000);

        Policy p3 = new Policy("P103", "Rahul",
                LocalDate.now().plusDays(10), "Home", 12000);

        // Duplicate policy number
        Policy p4 = new Policy("P101", "Amit Duplicate",
                LocalDate.now().plusDays(20), "Health", 8000);

        // Adding policies to all sets
        addPolicy(hashSet, linkedHashSet, treeSet, p1);
        addPolicy(hashSet, linkedHashSet, treeSet, p2);
        addPolicy(hashSet, linkedHashSet, treeSet, p3);
        addPolicy(hashSet, linkedHashSet, treeSet, p4);

        // Print all unique policies
        System.out.println("\nAll Unique Policies:");
        hashSet.forEach(System.out::println);

        // Print policies expiring within next 30 days
        System.out.println("\nPolicies Expiring Within 30 Days:");
        LocalDate limit = LocalDate.now().plusDays(30);
        for (Policy p : treeSet) {
            if (!p.expiryDate.isAfter(limit)) {
                System.out.println(p);
            }
        }

        // Print policies of Health coverage
        System.out.println("\nHealth Policies:");
        for (Policy p : hashSet) {
            if (p.coverageType.equalsIgnoreCase("Health")) {
                System.out.println(p);
            }
        }

        // Find duplicate policy numbers
        System.out.println("\nDuplicate Policy Numbers:");
        findDuplicates(Arrays.asList(p1, p2, p3, p4));

        // Compare performance of different sets
        performanceTest(hashSet, linkedHashSet, treeSet);
    }

    // Method to add policy to all sets
    static void addPolicy(Set<Policy> h, Set<Policy> lh,
                          Set<Policy> t, Policy p) {
        h.add(p);
        lh.add(p);
        t.add(p);
    }

    // Method to find duplicate policy numbers
    static void findDuplicates(List<Policy> policies) {

        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (Policy p : policies) {
            if (!seen.add(p.policyNumber)) {
                duplicates.add(p.policyNumber);
            }
        }
        System.out.println(duplicates);
    }

    // Method to compare performance of sets
    static void performanceTest(Set<Policy> h,
                                Set<Policy> lh,
                                Set<Policy> t) {

        Policy test = new Policy("TEST1", "Test User",
                LocalDate.now().plusDays(5), "Health", 5000);

        long start, end;

        start = System.nanoTime();
        h.add(test);
        end = System.nanoTime();
        System.out.println("\nHashSet add time: " + (end - start));

        start = System.nanoTime();
        lh.add(test);
        end = System.nanoTime();
        System.out.println("LinkedHashSet add time: " + (end - start));

        start = System.nanoTime();
        t.add(test);
        end = System.nanoTime();
        System.out.println("TreeSet add time: " + (end - start));

        start = System.nanoTime();
        h.contains(test);
        end = System.nanoTime();
        System.out.println("HashSet search time: " + (end - start));

        start = System.nanoTime();
        lh.contains(test);
        end = System.nanoTime();
        System.out.println("LinkedHashSet search time: " + (end - start));

        start = System.nanoTime();
        t.contains(test);
        end = System.nanoTime();
        System.out.println("TreeSet search time: " + (end - start));
    }
}
