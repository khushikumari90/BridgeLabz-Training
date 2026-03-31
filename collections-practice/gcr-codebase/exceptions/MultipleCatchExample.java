package exceptions;
public class MultipleCatchExample {

    public static void main(String[] args) {

        try {
            // You can change this to null to test NullPointerException
            int[] arr = {10, 20, 30, 40, 50};

            int index = 3;   // change index to test out of range

            int value = arr[index];
            System.out.println("Value at index " + index + ": " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");

        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}
