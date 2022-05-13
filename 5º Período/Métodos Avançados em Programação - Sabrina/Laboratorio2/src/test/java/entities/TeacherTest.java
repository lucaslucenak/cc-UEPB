package entities;

import enumns.ScheduleEnum;
import exceptions.SchedulesDoesntMatchException;
import exceptions.SubjectNotOfferedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TeacherTest {

    private Teacher teacher = new Teacher(1L, "Sabrina", ScheduleEnum.INTEGRAL);
    private Alumn alumn = new Alumn(1L, "Lucas", ScheduleEnum.INTEGRAL);
    private Subject subject = new Subject(1L, "Matematica", teacher, ScheduleEnum.INTEGRAL, true);

    @Test
    public void shouldAddSubject() {
        teacher.addSubject(subject);
        Assertions.assertEquals(subject, teacher.getSubjects().get(0));
        Assertions.assertEquals(1, teacher.getSubjects().size());
        Assertions.assertEquals(subject.getSchedule(), teacher.getSubjects().get(0).getSchedule());
    }

    @Test
    public void shouldAddNOTURNOScheduleSubjectWhenTeacherScheduleIsNOTURNO() {
        teacher.setSchedule(ScheduleEnum.NOTURNO);
        subject.setSchedule(ScheduleEnum.NOTURNO);
        teacher.addSubject(subject);
        Assertions.assertEquals(subject, teacher.getSubjects().get(0));
        Assertions.assertEquals(subject.getSchedule(), teacher.getSubjects().get(0).getSchedule());
    }

    @Test
    public void shouldAddDIURNOScheduleSubjectWhenTeacherScheduleIsDIURNO() {
        teacher.setSchedule(ScheduleEnum.DIURNO);
        subject.setSchedule(ScheduleEnum.DIURNO);
        teacher.addSubject(subject);
        Assertions.assertEquals(subject, teacher.getSubjects().get(0));
        Assertions.assertEquals(subject.getSchedule(), teacher.getSubjects().get(0).getSchedule());
    }

    @Test
    public void shouldAddINTEGRALScheduleSubjectWhenTeacherScheduleIsINTEGRAL() {
        teacher.setSchedule(ScheduleEnum.INTEGRAL);
        subject.setSchedule(ScheduleEnum.INTEGRAL);
        teacher.addSubject(subject);
        Assertions.assertEquals(subject, teacher.getSubjects().get(0));
        Assertions.assertEquals(subject.getSchedule(), teacher.getSubjects().get(0).getSchedule());
    }

    @Test
    public void shouldAddNOTURNOScheduleSubjectWhenTeacherScheduleIsINTEGRAL() {
        subject.setSchedule(ScheduleEnum.NOTURNO);
        teacher.setSchedule(ScheduleEnum.INTEGRAL);
        teacher.addSubject(subject);
        Assertions.assertEquals(subject, teacher.getSubjects().get(0));
        Assertions.assertEquals(subject.getSchedule(), teacher.getSubjects().get(0).getSchedule());
    }

    @Test
    public void shouldAddDIURNOScheduleSubjectWhenTeacherScheduleIsINTEGRAL() {
        subject.setSchedule(ScheduleEnum.DIURNO);
        teacher.setSchedule(ScheduleEnum.INTEGRAL);
        teacher.addSubject(subject);
        Assertions.assertEquals(subject, teacher.getSubjects().get(0));
        Assertions.assertEquals(subject.getSchedule(), teacher.getSubjects().get(0).getSchedule());
    }

    @Test
    public void shouldThrowSchedulesDoesntMatchExceptionWhenTeacherScheduleIsDIURNOAndSubjectScheduleIsNOTURNO() {
        subject.setSchedule(ScheduleEnum.NOTURNO);
        teacher.setSchedule(ScheduleEnum.DIURNO);
        Assertions.assertThrows(SchedulesDoesntMatchException.class, () -> {
            teacher.addSubject(subject);
        });
    }

    @Test
    public void shouldThrowSchedulesDoesntMatchExceptionWhenTeacherScheduleIsNOTURNOAndSubjectScheduleIsDIURNO() {
        subject.setSchedule(ScheduleEnum.DIURNO);
        teacher.setSchedule(ScheduleEnum.NOTURNO);
        Assertions.assertThrows(SchedulesDoesntMatchException.class, () -> {
            teacher.addSubject(subject);
        });
    }

    @Test
    public void shouldThrowSubjectNotOfferedExceptionWhenSubjectIsntOffered() {
        subject.setOffered(false);
        Assertions.assertThrows(SubjectNotOfferedException.class, () -> {
            teacher.addSubject(subject);
        });
    }
}
