package onlineExaminationSystem;

public class ObjectiveEvaluation implements EvaluationStrategy {

    @Override
    public int evaluate(Question question, String answer) {
        return question.getCorrectAnswer().equalsIgnoreCase(answer) ? 1 : 0;
    }
}
