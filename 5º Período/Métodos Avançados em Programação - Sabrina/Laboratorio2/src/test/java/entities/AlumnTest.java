package entities;

import enumns.ScheduleEnum;
import exceptions.SchedulesDoesntMatchException;
import exceptions.SubjectNotOfferedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlumnTest {

    private final Teacher teacher = new Teacher(1L, "Sabrina", ScheduleEnum.INTEGRAL);
    private final Alumn alumn = new Alumn(1L, "Lucas", ScheduleEnum.INTEGRAL);
    private final Subject subject = new Subject(1L, "Matemática", teacher, ScheduleEnum.INTEGRAL, true);


    @Test
    public void shouldAddSubject() {
        alumn.addSubject(subject);
        Assertions.assertEquals(subject, alumn.getSubjects().get(0));
        Assertions.assertEquals(1, alumn.getSubjects().size());
        Assertions.assertEquals(subject.getSchedule(), alumn.getSubjects().get(0).getSchedule());
    }

    @Test
    public void shouldAddNOTURNOScheduleWhenAlumnScheduleIsNOTURNO() {
        alumn.setSchedule(ScheduleEnum.NOTURNO);
        subject.setSchedule(ScheduleEnum.NOTURNO);
        alumn.addSubject(subject);
        Assertions.assertEquals(subject, alumn.getSubjects().get(0));
        Assertions.assertEquals(subject.getSchedule(), alumn.getSubjects().get(0).getSchedule());
    }

    @Test
    public void shouldAddDIURNOScheduleWhenAlumnScheduleIsDIURNO() {
        alumn.setSchedule(ScheduleEnum.DIURNO);
        subject.setSchedule(ScheduleEnum.DIURNO);
        alumn.addSubject(subject);
        Assertions.assertEquals(subject, alumn.getSubjects().get(0));
        Assertions.assertEquals(subject.getSchedule(), alumn.getSubjects().get(0).getSchedule());
    }

    @Test
    public void shouldAddINTEGRALScheduleWhenAlumnScheduleIsINTEGRAL() {
        alumn.setSchedule(ScheduleEnum.INTEGRAL);
        subject.setSchedule(ScheduleEnum.INTEGRAL);
        alumn.addSubject(subject);
        Assertions.assertEquals(subject, alumn.getSubjects().get(0));
        Assertions.assertEquals(subject.getSchedule(), alumn.getSubjects().get(0).getSchedule());
    }

    @Test
    public void shouldAddNOTURNOScheduleWhenAlumnScheduleIsINTEGRAL() {
        subject.setSchedule(ScheduleEnum.NOTURNO);
        alumn.setSchedule(ScheduleEnum.INTEGRAL);
        alumn.addSubject(subject);
        Assertions.assertEquals(subject, alumn.getSubjects().get(0));
        Assertions.assertEquals(subject.getSchedule(), alumn.getSubjects().get(0).getSchedule());
    }

    @Test
    public void shouldAddDIURNOScheduleWhenAlumnScheduleIsINTEGRAL() {
        subject.setSchedule(ScheduleEnum.DIURNO);
        alumn.setSchedule(ScheduleEnum.INTEGRAL);
        alumn.addSubject(subject);
        Assertions.assertEquals(subject, alumn.getSubjects().get(0));
        Assertions.assertEquals(subject.getSchedule(), alumn.getSubjects().get(0).getSchedule());
    }

    @Test
    public void shouldThrowSchedulesDoesntMatchExceptionWhenAlumnScheduleIsDIURNOAndSubjectScheduleIsNOTURNO() {
        subject.setSchedule(ScheduleEnum.NOTURNO);
        alumn.setSchedule(ScheduleEnum.DIURNO);
        Assertions.assertThrows(SchedulesDoesntMatchException.class, () -> {
            alumn.addSubject(subject);
        });
    }

    @Test
    public void shouldThrowSchedulesDoesntMatchExceptionWhenAlumnScheduleIsNOTURNOAndSubjectScheduleIsDIURNO() {
        subject.setSchedule(ScheduleEnum.DIURNO);
        alumn.setSchedule(ScheduleEnum.NOTURNO);
        Assertions.assertThrows(SchedulesDoesntMatchException.class, () -> {
            alumn.addSubject(subject);
        });
    }

    @Test
    public void shouldThrowSubjectNotOfferedExceptionWhenSubjectIsntOffered() {
        subject.setOffered(false);
        Assertions.assertThrows(SubjectNotOfferedException.class, () -> {
            alumn.addSubject(subject);
        });
    }
}
