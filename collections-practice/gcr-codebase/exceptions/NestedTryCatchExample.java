package exceptions;
public class NestedTryCatchExample {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40};
        int index = 2;    // change to test invalid index
        int divisor = 0;  // change to test division by zero

        try {
            // Outer try block: array access
            try {
                int value = arr[index];

                // Inner try block: division
                try {
                    int result = value / divisor;
                    System.out.println("Result: " + result);

                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }

        } catch (Exception e) {
            // Optional general catch (not mandatory)
        }
    }
}
