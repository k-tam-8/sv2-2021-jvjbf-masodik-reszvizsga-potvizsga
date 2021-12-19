package exams;

public class MultipleChoiceExam extends Exam {

    public MultipleChoiceExam(long studentId, String topic, int maxPoints) {
        super(studentId, topic, maxPoints);
    }

    public MultipleChoiceExam(long studentId, String topic) {
        super(studentId, topic, 100);
    }

    @Override
    public void calculateExamResult(int actualPoints) {
        pointValidate(actualPoints);
        double percent = actualPoints * 100 / getMaxPoints();
        if (percent >= 51) {
            super.setExamResult(ExamResult.PASSED);
        } else super.setExamResult(ExamResult.NOT_PASSED);
    }

    private void pointValidate(int actualPoints) {
        if (actualPoints < 0 || actualPoints > getMaxPoints()) {
            throw new IllegalArgumentException("Nem megfelelő pontszám!");
        }
    }
}
