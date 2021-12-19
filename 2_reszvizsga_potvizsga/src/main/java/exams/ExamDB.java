package exams;

import java.util.ArrayList;
import java.util.List;

public class ExamDB {
    private List<Exam> exams = new ArrayList<>();

    public void addExam(Exam exam, int actualPoints) {
        exams.add(exam);
        exam.calculateExamResult(actualPoints);
    }

    public List<Exam> getExams() {
        return new ArrayList<>(exams);
    }

    public int countPassedExams() {
        int passedExams = 0;
        for (Exam e : exams) {
            if (e.getExamResult() != ExamResult.NOT_PASSED) {
                passedExams++;
            }
        }
        return passedExams;
    }

    public List<Exam> findById(long studentId) {
        List<Exam> filteredExamList = new ArrayList<>();
        for (Exam e : exams) {
            if (e.getStudentId() == studentId) {
                filteredExamList.add(e);
            }
        }
        return filteredExamList;
    }

    public List<String> findTopicByPrefix(String prefix) {
        List<String> filteredTopicList = new ArrayList<>();
        for (Exam e : exams) {
            if (e.getTopic().startsWith(prefix) && !filteredTopicList.contains(e.getTopic())) {
                filteredTopicList.add(e.getTopic());
            }
        }
        return filteredTopicList;
    }
}
