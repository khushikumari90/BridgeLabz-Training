package oopsscenariobased;
import java.util.*;

class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String msg) {
        super(msg);
    }
}

class QuizProcessor {

    public static int calculateScore(String[] correct, String[] user)
            throws InvalidQuizSubmissionException {

        if (correct.length != user.length) {
            throw new InvalidQuizSubmissionException("Answer length mismatch");
        }

        int score = 0;
        for (int i = 0; i < correct.length; i++) {
            if (correct[i].equalsIgnoreCase(user[i])) {
                score++;
            }
        }
        return score;
    }

    public static String grade(int score, int total) {
        double percent = (score * 100.0) / total;
        if (percent >= 80) return "A";
        if (percent >= 60) return "B";
        if (percent >= 40) return "C";
        return "Fail";
    }
}

public class OnlineQuizPlatform {
    public static void main(String[] args) throws Exception {
        String[] correct = {"A", "B", "C", "D"};
        String[] user = {"A", "B", "A", "D"};

        List<Integer> scores = new ArrayList<>();

        int score = QuizProcessor.calculateScore(correct, user);
        scores.add(score);

        System.out.println("Score: " + score);
        System.out.println("Grade: " + QuizProcessor.grade(score, correct.length));
    }
}
