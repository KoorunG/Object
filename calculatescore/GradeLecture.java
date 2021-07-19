package calculatescore;

import java.util.List;
import static java.util.stream.Collectors.*;

public class GradeLecture extends Lecture {

    private List<Grade> grades;

    public GradeLecture(String title, int pass, List<Grade> grades, List<Integer> scores) {
        super(title, pass, scores);
        this.grades = grades;
    }

    @Override
    public String evaluate() {
        return super.evaluate() + ", " + gradeStatistics();
    }

    private String gradeStatistics() {
        return grades.stream().map(grade -> format(grade)).collect(joining(" "));
    }

    private String format(Grade grade) {
        return String.format("%s:%d", grade.getName(),gradeCount(grade));
    }

    private long gradeCount(Grade grade) {
        return getScores().stream().filter(grade::include).count();
    }

    public double average(String gradeName){    // 등급별 성적을 구현하는 메소드 추가
                                                // Lecture에 정의된 average와 메소드 이름은 같으나, 시그니처가 다르다 => 오버로딩
        return grades.stream().filter(each -> each.isName(gradeName)).findFirst().map(this::gradeAverage).orElse(0d);
    }

    private double gradeAverage(Grade grade){
        return getScores().stream().filter(grade::include).mapToInt(Integer::intValue).average().orElse(0);
    }

}
