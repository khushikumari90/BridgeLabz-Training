package leetcodecorejava;

public class Sqrt {

    // Method to calculate integer square root
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int i = 1;
        while (i <= x / i) {   // avoids overflow
            i++;
        }
        return i - 1;
    }

    // Main method for testing
    public static void main(String[] args) {
        Sqrt obj = new Sqrt();

        int x1 = 4;
        int x2 = 8;
        int x3 = 0;
        int x4 = 1;
        int x5 = 2147395599;

        System.out.println("Sqrt of " + x1 + " = " + obj.mySqrt(x1)); // 2
        System.out.println("Sqrt of " + x2 + " = " + obj.mySqrt(x2)); // 2
        System.out.println("Sqrt of " + x3 + " = " + obj.mySqrt(x3)); // 0
        System.out.println("Sqrt of " + x4 + " = " + obj.mySqrt(x4)); // 1
        System.out.println("Sqrt of " + x5 + " = " + obj.mySqrt(x5)); // 46339
    }
}

