//Problem number 509
package leetcodeOOPS;
public class fibonacciNumber {

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int a = 0;
        int b = 1;
        int c = 0;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci of " + n + " is: " + fib(n));
    }
}

