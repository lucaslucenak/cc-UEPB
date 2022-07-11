package com.map.labdois.entities;

import com.map.labdois.enums.CourseEnum;
import com.map.labdois.enums.ScheduleEnum;
import com.map.labdois.enums.SubjectEnum;
import com.map.labdois.exceptions.SchedulesDoesntMatchException;
import com.map.labdois.exceptions.SubjectNotOfferedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AcademicControlTest {
    private University university;

    @BeforeEach
    void setUp() throws Exception {
        university = new University();
        university.addNewTeacher("Sabrina", 25, "sabrina@uepb.com", "83987654321", ScheduleEnum.INTEGRAL);
        university.addNewSubject(SubjectEnum.Calculo,  ScheduleEnum.INTEGRAL, true, university.getTeachers().get(0));
        university.addNewStudent("Daniel", 21, "daniel@uepb.com", "83912341234", 10.0, ScheduleEnum.DIURNO);
    }

    @Test
    public void shouldAddSubjectIntoStudent() {
        university.getCA().addSubjectIntoStudent("Daniel", SubjectEnum.Calculo, university);

        Assertions.assertEquals(university.getSubjects().get(0).getStudents().get(0), university.getStudents().get(0));
    }

    @Test
    public void shouldReturnSubjectStudentQuantity() {
        university.getCA().addSubjectIntoStudent("Daniel", SubjectEnum.Calculo, university);
        university.addNewStudent("Lucas", 21, "daniel@uepb.com", "83912341234", 10.0, ScheduleEnum.DIURNO);
        university.getCA().addSubjectIntoStudent("Lucas", SubjectEnum.Calculo, university);

        Assertions.assertEquals(2, university.getCA().getSubjectStudentQuantity(SubjectEnum.Calculo, university));
    }

    @Test
    public void shouldThrowSubjectNotOfferedExceptionWhenSubjectIsntOffered() {

        university.getSubjects().get(0).setIsOffered(false);
        Assertions.assertThrows(SubjectNotOfferedException.class, () -> {
            university.getCA().addSubjectIntoStudent("Daniel", SubjectEnum.Calculo, university);
        });

    }

    @Test
    public void shouldThrowSchedulesDoesntMatchExceptionWhenSchedulesDoesntMatches() {
        university.getStudents().get(0).getRdm().setSchedule(ScheduleEnum.DIURNO);
        university.getSubjects().get(0).setSchedule(ScheduleEnum.NOTURNO);
        Assertions.assertThrows(SchedulesDoesntMatchException.class, () -> {
            university.getCA().addSubjectIntoStudent("Daniel", SubjectEnum.Calculo, university);
        });
    }
}
