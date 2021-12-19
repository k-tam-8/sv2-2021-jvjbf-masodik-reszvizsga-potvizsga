package exams;

import java.util.List;

public class PracticeExam extends Exam {
    public PracticeExam(long studentId, String topic, List<Integer> points) {
        super(studentId, topic);
        int maxPoints = 0;
        for (int i : points) {
            maxPoints += i;
        }
        validateMaxPoints(maxPoints);
    }

    public PracticeExam(long studentId, String topic) {
        super(studentId, topic);
    }

    private void validateMaxPoints(int maxPoints) {
        if (maxPoints > 9 && maxPoints < 151) {
            super.setMaxPoints(maxPoints);
        } else throw new IllegalArgumentException("Maximum points should be between 10 and 150! Actual:" + maxPoints);
    }

    @Override
    public void calculateExamResult(int actualPoints) {
        pointValidate(actualPoints);
        double percent = actualPoints * 100 / getMaxPoints();
        if (percent >= 76) {
            super.setExamResult(ExamResult.PERFECT);
        } else if (percent >= 51) {
            super.setExamResult(ExamResult.OK);
        } else super.setExamResult(ExamResult.NOT_PASSED);
    }

    private void pointValidate(int actualPoints) {
        if (actualPoints < 0 || actualPoints > getMaxPoints()) {
            throw new IllegalArgumentException("Nem megfelelő pontszám!");
        }
    }
}
