package onlineExaminationSystem;

import java.util.HashMap;
import java.util.Map;

public class OnlineExamApp {

    public static void main(String[] args) {

        Exam exam = new Exam("Java Basics Test");

        exam.addQuestion(new Question("What is JVM?", "Java Virtual Machine"));
        exam.addQuestion(new Question("Keyword to inherit class?", "extends"));

        Student s1 = new Student(1, "Amit");

        Map<Question, String> answers = new HashMap<>();
        answers.put(exam.getQuestions().get(0), "Java Virtual Machine");
        answers.put(exam.getQuestions().get(1), "extends");

        ExamService service = new ExamService();

        try {
            service.submitAnswers(exam, s1, answers, new ObjectiveEvaluation());
        } catch (ExamTimeExpiredException e) {
            System.out.println("Error: " + e.getMessage());
        }

        exam.endExam();
        service.generateResult(s1);
    }
}
