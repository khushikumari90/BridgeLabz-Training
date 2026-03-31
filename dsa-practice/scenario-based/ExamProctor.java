package scenario_based;
import java.util.*;

public class ExamProctor {

    Stack<Integer> navigationStack = new Stack<>();
    HashMap<Integer, String> answers = new HashMap<>();
    HashMap<Integer, String> correctAnswers = new HashMap<>();

    void visitQuestion(int qid) {
        navigationStack.push(qid);
        System.out.println("Visited Question: " + qid);
    }

    void submitAnswer(int qid, String answer) {
        answers.put(qid, answer);
    }

    int evaluateScore() {
        int score = 0;
        for (int qid : answers.keySet()) {
            if (answers.get(qid).equals(correctAnswers.get(qid))) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        ExamProctor exam = new ExamProctor();

        exam.correctAnswers.put(1, "A");
        exam.correctAnswers.put(2, "B");
        exam.correctAnswers.put(3, "C");

        exam.visitQuestion(1);
        exam.submitAnswer(1, "A");

        exam.visitQuestion(2);
        exam.submitAnswer(2, "B");

        exam.visitQuestion(3);
        exam.submitAnswer(3, "D");

        System.out.println("Final Score: " + exam.evaluateScore());
    }
}

