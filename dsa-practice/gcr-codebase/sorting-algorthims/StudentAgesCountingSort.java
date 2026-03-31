package sorting_algorithms;
public class StudentAgesCountingSort {

    public static void main(String[] args) {
        int[] ages = {12, 15, 10, 18, 14, 12, 16};
        int minAge = 10;
        int maxAge = 18;

        int[] count = new int[maxAge - minAge + 1];

        for (int age : ages) {
            count[age - minAge]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                ages[index++] = i + minAge;
                count[i]--;
            }
        }

        System.out.println("Sorted Student Ages:");
        for (int a : ages)
            System.out.print(a + " ");
    }
}
