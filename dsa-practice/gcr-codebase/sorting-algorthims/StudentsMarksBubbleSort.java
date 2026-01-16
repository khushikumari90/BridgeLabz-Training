package sorting_algorithms;
import java.util.*;
public class StudentsMarksBubbleSort {
    public static void main(String args[]) {
    	int marks[]= {91,76,89,55,72};
        bubblesort(marks);
        System.out.println(Arrays.toString(marks));

    }
    public static void bubblesort(int marks[]) {
    	int n=marks.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swap marks[j] and marks [j+1]
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
