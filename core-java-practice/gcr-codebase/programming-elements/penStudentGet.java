//Suppose you have to divide 14 pens among 3 students equally. Write a program to find how many pens each student will get if the pens must be divided equally. Also, find the remaining non-distributed pens.
package programmingelements;

public class penStudentGet {

	public static void main(String[] args) {
        // Given values
        int totalPens = 14;
        int totalStudents = 3;

        // Pens per student using division operator
        int pensPerStudent = totalPens / totalStudents;

        // Remaining pens using modulus operator
        int remainingPens = totalPens % totalStudents;

        // Display the result
        System.out.println(
                "The Pen Per Student is " + pensPerStudent + " and the remaining pen not distributed is " + remainingPens
        );

	}
	
}
