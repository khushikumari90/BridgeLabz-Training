//Write a program to perform matrix manipulation operations like finding the transpose, determinant, and inverse of a matrix. The program should take random matrices as input and display the result of the operations.
package methods;
public class MatrixManipulation {

	public static void main(String[] args) {
		// 2x2 Matrix
        double[][] matrix2 = createRandomMatrix(2, 2);
        System.out.println("2x2 Matrix:");
        displayMatrix(matrix2);

        System.out.println("\nTranspose:");
        displayMatrix(transpose(matrix2));

        System.out.println("\nDeterminant: " + determinant2x2(matrix2));

        double[][] inv2 = inverse2x2(matrix2);
        if (inv2 != null) {
            System.out.println("\nInverse:");
            displayMatrix(inv2);
        } else {
            System.out.println("\nInverse not possible");
        }

        // 3x3 Matrix
        double[][] matrix3 = createRandomMatrix(3, 3);
        System.out.println("\n3x3 Matrix:");
        displayMatrix(matrix3);

        System.out.println("\nTranspose:");
        displayMatrix(transpose(matrix3));

        System.out.println("\nDeterminant: " + determinant3x3(matrix3));

        double[][] inv3 = inverse3x3(matrix3);
        if (inv3 != null) {
            System.out.println("\nInverse:");
            displayMatrix(inv3);
        } else {
            System.out.println("\nInverse not possible");
        }
	}
    // Method to create a random matrix
    public static double[][] createRandomMatrix(int rows, int cols) {
        double[][] matrix = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 9) + 1; // 1 to 9
            }
        }
        return matrix;
    }

    // Method to find transpose of a matrix
    public static double[][] transpose(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] trans = new double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                trans[j][i] = matrix[i][j];
            }
        }
        return trans;
    }

    // Determinant of 2x2 matrix
    public static double determinant2x2(double[][] m) {
        return (m[0][0] * m[1][1]) - (m[0][1] * m[1][0]);
    }

    // Determinant of 3x3 matrix
    public static double determinant3x3(double[][] m) {
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
             - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
             + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }

    // Inverse of 2x2 matrix
    public static double[][] inverse2x2(double[][] m) {
        double det = determinant2x2(m);
        if (det == 0) return null;

        return new double[][]{
            { m[1][1] / det, -m[0][1] / det },
            { -m[1][0] / det, m[0][0] / det }
        };
    }

    // Inverse of 3x3 matrix
    public static double[][] inverse3x3(double[][] m) {
        double det = determinant3x3(m);
        if (det == 0) return null;

        double[][] inv = new double[3][3];

        inv[0][0] =  (m[1][1]*m[2][2] - m[1][2]*m[2][1]) / det;
        inv[0][1] = -(m[0][1]*m[2][2] - m[0][2]*m[2][1]) / det;
        inv[0][2] =  (m[0][1]*m[1][2] - m[0][2]*m[1][1]) / det;

        inv[1][0] = -(m[1][0]*m[2][2] - m[1][2]*m[2][0]) / det;
        inv[1][1] =  (m[0][0]*m[2][2] - m[0][2]*m[2][0]) / det;
        inv[1][2] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]) / det;

        inv[2][0] =  (m[1][0]*m[2][1] - m[1][1]*m[2][0]) / det;
        inv[2][1] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]) / det;
        inv[2][2] =  (m[0][0]*m[1][1] - m[0][1]*m[1][0]) / det;

        return transpose(inv); // adjoint / det
    }

    // Method to display matrix
    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.printf("%.2f\t", val);
            }
            System.out.println();
        }
    }


}
