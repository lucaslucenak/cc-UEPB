package com.map.labdois.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.map.labdois.enums.CourseEnum;
import com.map.labdois.enums.ScheduleEnum;
import com.map.labdois.enums.SubjectEnum;

public class SubjectTest {
    private University university;

    @BeforeEach
    void setUp() throws Exception {
        university = new University();
        university.addNewTeacher("Sabrina", 25, "sabrina@uepb.com", "83987654321", ScheduleEnum.INTEGRAL);
        university.addNewSubject(SubjectEnum.Calculo,  ScheduleEnum.INTEGRAL, true, university.getTeachers().get(0));
        university.addNewStudent("Daniel", 21, "daniel@uepb.com", "83912341234", 10.0, ScheduleEnum.DIURNO);
    }

    @Test
    public void shouldAddStudentIntoSubject() {
        university.getSubjects().get(0).addStudent(university.getStudents().get(0));
        Assertions.assertEquals(university.getStudents().get(0), university.getSubjects().get(0).getStudents().get(0));
    }


//	@BeforeEach
//	void setUp() throws Exception {
//		teacher = new Teacher("Sabrina", 25, "sabrina@uepb.com", "83987654321", ScheduleEnum.INTEGRAL);
//		subject = new Subject(SubjectEnum.Calculo, teacher, ScheduleEnum.INTEGRAL, true);
//		student = new Student("Daniel", 21, "daniel@uepb.com", "83912341234", ScheduleEnum.INTEGRAL);
//	}
//
//	@Test
//	public void shouldAddSubjectIntoStudent() {
//		subject.addStudent(student);
//		Assertions.assertEquals(subject.getStudents().get(0), student);
//	}
}
