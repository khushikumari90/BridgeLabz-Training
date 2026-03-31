//Problem Number 50
package leetcodeOOPS;
public class Power{

    public static double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    public static void main(String[] args) {
        double x = 2.0;
        int n = 10;

        System.out.println("Result: " + myPow(x, n));
    }
}

