package entities;

import enumns.ScheduleEnum;
import exceptions.SchedulesDoesntMatchException;
import exceptions.SubjectNotOfferedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubjectTest {

    private Teacher teacher = new Teacher(1L, "Sabrina", ScheduleEnum.INTEGRAL);
    private Alumn alumn = new Alumn(1L, "Lucas", ScheduleEnum.INTEGRAL);
    private Subject subject = new Subject(1L, "Matemática", teacher, ScheduleEnum.INTEGRAL, true);

    @Test
    public void shouldAddAlumn() {
        alumn.addSubject(subject);
        Assertions.assertEquals(subject, alumn.getSubjects().get(0));
        Assertions.assertEquals(1, alumn.getSubjects().size());
        Assertions.assertEquals(subject.getSchedule(), alumn.getSubjects().get(0).getSchedule());
    }

    @Test
    public void shouldAddNOTURNOAlumnWhenSubjectScheduleIsNOTURNO() {
        alumn.setSchedule(ScheduleEnum.NOTURNO);
        subject.setSchedule(ScheduleEnum.NOTURNO);
        subject.addAlumn(alumn);
        Assertions.assertEquals(alumn, subject.getAlumns().get(0));
        Assertions.assertEquals(alumn.getSchedule(), subject.getAlumns().get(0).getSchedule());
    }

    @Test
    public void shouldAddDIURNOAlumnWhenSubjectScheduleIsDIURNO() {
        alumn.setSchedule(ScheduleEnum.DIURNO);
        subject.setSchedule(ScheduleEnum.DIURNO);
        subject.addAlumn(alumn);
        Assertions.assertEquals(alumn, subject.getAlumns().get(0));
        Assertions.assertEquals(alumn.getSchedule(), subject.getAlumns().get(0).getSchedule());
    }

    @Test
    public void shouldAddINTEGRALAlumnWhenSubjectScheduleIsINTEGRAL() {
        alumn.setSchedule(ScheduleEnum.INTEGRAL);
        subject.setSchedule(ScheduleEnum.INTEGRAL);
        subject.addAlumn(alumn);
        Assertions.assertEquals(alumn, subject.getAlumns().get(0));
        Assertions.assertEquals(alumn.getSchedule(), subject.getAlumns().get(0).getSchedule());
    }

    @Test
    public void shouldAddNOTURNOAlumnWhenSubjectScheduleIsINTEGRAL() {
        subject.setSchedule(ScheduleEnum.INTEGRAL);
        alumn.setSchedule(ScheduleEnum.NOTURNO);
        subject.addAlumn(alumn);
        Assertions.assertEquals(alumn, subject.getAlumns().get(0));
        Assertions.assertEquals(alumn.getSchedule(), subject.getAlumns().get(0).getSchedule());
    }

    @Test
    public void shouldAddDIURNOAlumnWhenSubjectScheduleIsINTEGRAL() {
        subject.setSchedule(ScheduleEnum.INTEGRAL);
        alumn.setSchedule(ScheduleEnum.DIURNO);
        subject.addAlumn(alumn);
        Assertions.assertEquals(alumn, subject.getAlumns().get(0));
        Assertions.assertEquals(alumn.getSchedule(), subject.getAlumns().get(0).getSchedule());
    }

    @Test
    public void shouldThrowSchedulesDoesntMatchExceptionWhenSubjectScheduleIsDIURNOAndAlumnScheduleIsNOTURNO() {
        subject.setSchedule(ScheduleEnum.DIURNO);
        alumn.setSchedule(ScheduleEnum.NOTURNO);
        Assertions.assertThrows(SchedulesDoesntMatchException.class, () -> {
            subject.addAlumn(alumn);
        });
    }

    @Test
    public void shouldThrowSchedulesDoesntMatchExceptionWhenSubjectScheduleIsNOTURNOAndAlumnScheduleIsDIURNO() {
        subject.setSchedule(ScheduleEnum.NOTURNO);
        alumn.setSchedule(ScheduleEnum.DIURNO);
        Assertions.assertThrows(SchedulesDoesntMatchException.class, () -> {
            subject.addAlumn(alumn);
        });
    }

    @Test
    public void shouldThrowSubjectNotOfferedExceptionWhenSubjectIsntOffered() {
        subject.setOffered(false);
        Assertions.assertThrows(SubjectNotOfferedException.class, () -> {
            subject.addAlumn(alumn);
        });
    }
}
