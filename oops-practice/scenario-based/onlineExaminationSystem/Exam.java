package onlineExaminationSystem;

import java.util.ArrayList;
import java.util.List;

public class Exam {
    private String examName;
    private List<Question> questions = new ArrayList<>();
    private boolean active = true;

    public Exam(String examName) {
        this.examName = examName;
    }

    public void addQuestion(Question question) {
        questions.add(question);
        System.out.println("Question added to exam.");
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void endExam() {
        active = false;
    }

    public boolean isActive() {
        return active;
    }

    public String getExamName() {
        return examName;
    }
}
