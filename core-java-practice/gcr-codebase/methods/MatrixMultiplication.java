//Write a program to perform matrix manipulation operations like addition, subtraction, and multiplication. The program should take random matrices as input and display the result of the operations.
package methods;
import java.util.Scanner;
public class MatrixMultiplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows for Matrix A: ");
        int r1 = sc.nextInt();
        System.out.print("Enter columns for Matrix A: ");
        int c1 = sc.nextInt();

        System.out.print("Enter rows for Matrix B: ");
        int r2 = sc.nextInt();
        System.out.print("Enter columns for Matrix B: ");
        int c2 = sc.nextInt();

        int[][] A = createRandomMatrix(r1, c1);
        int[][] B = createRandomMatrix(r2, c2);

        System.out.println("\nMatrix A:");
        displayMatrix(A);

        System.out.println("\nMatrix B:");
        displayMatrix(B);

        // Addition & Subtraction possible only if same size
        if (r1 == r2 && c1 == c2) {
            System.out.println("\nAddition (A + B):");
            displayMatrix(addMatrices(A, B));

            System.out.println("\nSubtraction (A - B):");
            displayMatrix(subtractMatrices(A, B));
        } else {
            System.out.println("\nAddition and Subtraction not possible (different dimensions)");
        }

        // Multiplication possible if columns of A == rows of B
        if (c1 == r2) {
            System.out.println("\nMultiplication (A x B):");
            displayMatrix(multiplyMatrices(A, B));
        } else {
            System.out.println("\nMultiplication not possible (columns of A != rows of B)");
        }

        sc.close();
	}

    // Method to create a random matrix
    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 10); // 0 to 9
            }
        }
        return matrix;
    }

    // Method to add two matrices
    public static int[][] addMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    // Method to subtract two matrices
    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    // Method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    // Method to display a matrix
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }


}
