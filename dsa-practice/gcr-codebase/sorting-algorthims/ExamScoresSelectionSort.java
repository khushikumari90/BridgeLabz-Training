package sorting_algorithms;
public class ExamScoresSelectionSort {

    public static void main(String[] args) {
        int[] scores = {78, 45, 89, 60, 72};

        for (int i = 0; i < scores.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < scores.length; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }

        System.out.println("Sorted Exam Scores:");
        for (int s : scores) {
            System.out.print(s + " ");
        }
    }
}
