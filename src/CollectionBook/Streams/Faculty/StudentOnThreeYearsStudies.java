package CollectionBook.Streams.Faculty;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class StudentOnThreeYearsStudies extends Student{
    public StudentOnThreeYearsStudies(String id) {
        super(id);
        IntStream.range(1,7).forEach(i->getGradesByTerm().putIfAbsent(i,new ArrayList<>()));
    }

    @Override
    public boolean addGrade(int term, String courseName, int grade) throws OperationNotAllowedException {
        validate(term);
        getGradesByTerm().get(term).add(grade);
        getCourses().add(courseName);
        return countOfCoursesPassed() == 18;
    }

    @Override
    public String getGraduationLog() {
        return super.getGraduationLog()+ " in 3 years.";
    }
}
