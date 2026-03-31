package oopsscenariobased;
public class MathUtility {

    // 1. Factorial of a number
    static long factorial(int n) {
        if (n < 0) {
            return -1; // Factorial not defined for negative numbers
        }
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // 2. Check if number is prime
    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 3. GCD of two numbers
    static int gcd(int a, int b) {
        if (a == 0)
            return Math.abs(b);
        if (b == 0)
            return Math.abs(a);

        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 4. Nth Fibonacci number
    static int fibonacci(int n) {
        if (n < 0) {
            return -1; // Invalid input
        }
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int a = 0, b = 1, c;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // Main method for testing
    public static void main(String[] args) {

        // Factorial tests
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Factorial of 0: " + factorial(0));
        System.out.println("Factorial of -3: " + factorial(-3));

        // Prime tests
        System.out.println("Is 7 prime? " + isPrime(7));
        System.out.println("Is 1 prime? " + isPrime(1));
        System.out.println("Is -5 prime? " + isPrime(-5));

        // GCD tests
        System.out.println("GCD of 12 and 18: " + gcd(12, 18));
        System.out.println("GCD of 0 and 5: " + gcd(0, 5));
        System.out.println("GCD of -10 and 20: " + gcd(-10, 20));

        // Fibonacci tests
        System.out.println("Fibonacci of 6: " + fibonacci(6));
        System.out.println("Fibonacci of 0: " + fibonacci(0));
        System.out.println("Fibonacci of -4: " + fibonacci(-4));
    }
}

