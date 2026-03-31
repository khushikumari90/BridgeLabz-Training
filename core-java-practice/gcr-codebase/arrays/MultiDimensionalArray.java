//Working with Multi-Dimensional Arrays. Write a Java program to create a 2D Array and Copy the 2D Array into a single dimension array
package arrays;
import java.util.Scanner;
public class MultiDimensionalArray {

	public static void main(String[] args) {
		
		  // Create Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Take input for number of rows
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        // Take input for number of columns
        System.out.print("Enter number of columns: ");
        int columns = sc.nextInt();

        // Create a 2D array (Matrix)
        int[][] matrix = new int[rows][columns];

        // Take user input for the 2D array
        System.out.println("\nEnter elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }

        // Create a 1D array of size rows * columns
        int[] array = new int[rows * columns];

        // Index variable for 1D array
        int index = 0;

        // Copy elements from 2D array to 1D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[index] = matrix[i][j];
                index++;
            }
        }

        // Display the 1D array
        System.out.println("\n1D Array after copying elements:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        // Close the scanner
        sc.close();

	}

}
