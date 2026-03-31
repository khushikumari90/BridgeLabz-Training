package oopsscenariobased;
public class EduQuizApp {

    public static void main(String[] args) {

        String[] correctAnswers = {
            "A","B","C","D","A","B","C","D","A","B"
        };

        String[] studentAnswers = {
            "A","b","C","A","A","B","D","D","a","B"
        };

        Quiz quiz = new Quiz();
        int score = quiz.calculateScore(correctAnswers, studentAnswers);

        double percentage = (score * 100.0) / correctAnswers.length;

        System.out.println("\nScore: " + score + "/10");
        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 50) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }
    }
}

