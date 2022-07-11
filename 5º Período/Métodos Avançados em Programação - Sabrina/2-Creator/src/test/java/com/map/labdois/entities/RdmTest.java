package com.map.labdois.entities;

import com.map.labdois.enums.ScheduleEnum;
import com.map.labdois.enums.SubjectEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RdmTest {
    private University university;

    @BeforeEach
    void setUp() throws Exception {
        university = new University();
        university.addNewTeacher("Sabrina", 25, "sabrina@uepb.com", "83987654321", ScheduleEnum.INTEGRAL);
        university.addNewSubject(SubjectEnum.Calculo,  ScheduleEnum.INTEGRAL, true, university.getTeachers().get(0));
        university.addNewStudent("Daniel", 21, "daniel@uepb.com", "83912341234", 10.0, ScheduleEnum.DIURNO);
    }

    @Test
    public void shouldAddSubjectIntoRdm() {
        university.getStudents().get(0).getRdm().addSubjectIntoRdm(university.getSubjects().get(0));
        Assertions.assertEquals(university.getStudents().get(0).getRdm().getSubjects().get(0), university.getSubjects().get(0));
    }
}
