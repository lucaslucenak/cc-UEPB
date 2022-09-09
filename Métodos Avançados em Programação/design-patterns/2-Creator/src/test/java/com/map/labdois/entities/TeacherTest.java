package com.map.labdois.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.map.labdois.enums.CourseEnum;
import com.map.labdois.enums.ScheduleEnum;
import com.map.labdois.enums.SubjectEnum;

public class TeacherTest {
    private University university;

    @BeforeEach
    void setUp() throws Exception {
        university = new University();
        university.addNewTeacher("Sabrina", 25, "sabrina@uepb.com", "83987654321", ScheduleEnum.INTEGRAL);
        university.addNewSubject(SubjectEnum.Calculo,  ScheduleEnum.INTEGRAL, true, university.getTeachers().get(0));
        university.addNewStudent("Daniel", 21, "daniel@uepb.com", "83912341234", 10.0, ScheduleEnum.DIURNO);
    }

    @Test
    public void shouldAddSubjectIntoTeacher() {
        university.getTeachers().get(0).addSubject(university.getSubjects().get(0));
        Assertions.assertEquals(university.getTeachers().get(0).getSubjects().get(0), university.getSubjects().get(0));
    }
}
