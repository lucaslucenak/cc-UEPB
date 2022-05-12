package entities;

import enumns.ScheduleEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TeacherTest {

    private Teacher teacher = new Teacher(1L, "Sabrina", ScheduleEnum.INTEGRAL);
    private Alumn alumn = new Alumn(1L, "Lucas", ScheduleEnum.INTEGRAL);
    private Subject subject = new Subject(1L, "Matemática", teacher, ScheduleEnum.INTEGRAL, true);


    @Test
    public void shouldAddSubjectIfSchedulesMatches() {
        teacher.addSubject(subject);
        Assertions.assertEquals(subject, teacher.getSubjects().get(0));
        Assertions.assertEquals(1, teacher.getSubjects().size());
    }
}
