package onlineExaminationSystem;

import java.util.HashMap;
import java.util.Map;

public class ExamService {

    private Map<Student, Integer> results = new HashMap<>();

    public void submitAnswers(Exam exam, Student student,
                              Map<Question, String> answers,
                              EvaluationStrategy strategy)
            throws ExamTimeExpiredException {

        if (!exam.isActive()) {
            throw new ExamTimeExpiredException("Exam time expired!");
        }

        int score = 0;
        for (Map.Entry<Question, String> entry : answers.entrySet()) {
            score += strategy.evaluate(entry.getKey(), entry.getValue());
        }

        results.put(student, score);
        System.out.println("Answers submitted for " + student.getName());
    }

    public void generateResult(Student student) {
        System.out.println("Result for " + student.getName()
                + ": Score = " + results.get(student));
    }
}

