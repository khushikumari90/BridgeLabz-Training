package onlineExaminationSystem;

public class DescriptiveEvaluation implements EvaluationStrategy {

    @Override
    public int evaluate(Question question, String answer) {
        return answer.length() > 10 ? 1 : 0; // simple descriptive check
    }
}
