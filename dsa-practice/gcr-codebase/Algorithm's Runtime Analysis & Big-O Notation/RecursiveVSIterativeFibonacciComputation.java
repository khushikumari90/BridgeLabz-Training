package algorithms_runtimeanalysis_and_bigOnotation;
public class RecursiveVSIterativeFibonacciComputation {

    // Recursive Fibonacci (O(2^n))
    public static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (O(n))
    public static int fibonacciIterative(int n) {
        if (n <= 1)
            return n;

        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {

        int[] testValues = {10, 30, 50};

        for (int n : testValues) {

            System.out.println("Fibonacci Number: " + n);

            // Recursive Fibonacci (skip very large n)
            if (n <= 30) {
                long start = System.nanoTime();
                int result = fibonacciRecursive(n);
                long end = System.nanoTime();
                System.out.println("Recursive Result: " + result);
                System.out.println("Recursive Time: "
                        + (end - start) / 1_000_000.0 + " ms");
            } else {
                System.out.println("Recursive Time: Unfeasible for large N");
            }

            // Iterative Fibonacci
            long start = System.nanoTime();
            int result = fibonacciIterative(n);
            long end = System.nanoTime();
            System.out.println("Iterative Result: " + result);
            System.out.println("Iterative Time: "
                    + (end - start) / 1_000_000.0 + " ms");

            System.out.println("-------------------------------------");
        }
    }
}
