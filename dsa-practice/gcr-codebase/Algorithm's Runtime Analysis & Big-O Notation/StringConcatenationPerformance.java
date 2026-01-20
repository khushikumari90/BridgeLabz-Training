package algorithms_runtimeanalysis_and_bigOnotation;

public class StringConcatenationPerformance {

    public static void main(String[] args) {

        int[] operations = {1000, 10000, 1_000_000};

        for (int n : operations) {

            System.out.println("Operations Count: " + n);

            // 1️⃣ String (Immutable - O(N^2))
            if (n <= 10000) {   // Avoid unusable case
                long start = System.nanoTime();
                String str = "";
                for (int i = 0; i < n; i++) {
                    str = str + "a";
                }
                long end = System.nanoTime();
                System.out.println("String Time: " + (end - start) / 1_000_000.0 + " ms");
            } else {
                System.out.println("String Time: Unusable for large input");
            }

            // 2️⃣ StringBuilder (Mutable - O(N))
            long start = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
            long end = System.nanoTime();
            System.out.println("StringBuilder Time: " + (end - start) / 1_000_000.0 + " ms");

            // 3️⃣ StringBuffer (Thread-safe - O(N))
            start = System.nanoTime();
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < n; i++) {
                sbf.append("a");
            }
            end = System.nanoTime();
            System.out.println("StringBuffer Time: " + (end - start) / 1_000_000.0 + " ms");

            System.out.println("--------------------------------------");
        }
    }
}
