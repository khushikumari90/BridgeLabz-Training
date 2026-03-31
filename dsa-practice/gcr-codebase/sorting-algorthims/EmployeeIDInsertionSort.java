package sorting_algorithms;
import java.util.*;
public class EmployeeIDInsertionSort {
	public static void main(String args[]) {
		int id[]= {32,12,19,21,35};
		insertionsort(id);
		System.out.print(Arrays.toString(id));
	}
	public static void insertionsort(int id[]) {
		int n=id.length;
		for(int i=1;i<n;i++) {
			int key=id[i];
			int j=i-1;
			while(j>=0 && id[j]>key) {
				id[j+1]=id[j];
				j--;
			}
			id[j+1]=key;
		}
	}
}
