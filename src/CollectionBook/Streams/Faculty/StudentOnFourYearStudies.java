package CollectionBook.Streams.Faculty;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class StudentOnFourYearStudies extends Student{
    public StudentOnFourYearStudies(String id) {
        super(id);
        IntStream.range(1,9).forEach(i->getGradesByTerm().putIfAbsent(i,new ArrayList<>()));
    }

    @Override
    public boolean addGrade(int term, String courseName, int grade) throws OperationNotAllowedException {
        validate(term);
        getGradesByTerm().get(term).add(grade);
        getCourses().add(courseName);
        return countOfCoursesPassed() == 24;
    }

    @Override
    public String getGraduationLog() {
        return super.getGraduationLog()+ " in 4 years.";
    }
}
