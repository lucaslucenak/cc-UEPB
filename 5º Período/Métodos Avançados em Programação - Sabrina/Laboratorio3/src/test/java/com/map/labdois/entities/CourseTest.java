//package com.map.labdois.entities;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import com.map.labdois.enums.CourseEnum;
//import com.map.labdois.enums.ScheduleEnum;
//import com.map.labdois.enums.SubjectEnum;
//
//public class CourseTest {
//
//	private Subject subject;
//	private Teacher teacher;
//	private Course course;
//
//	@BeforeEach
//	void setUp() throws Exception {
//		teacher = new Teacher("Sabrina", 25, "sabrina@uepb.com", "83987654321", ScheduleEnum.INTEGRAL);
//		subject = new Subject(SubjectEnum.Calculo, teacher, ScheduleEnum.INTEGRAL, true);
//		course = new Course(CourseEnum.Computacao);
//	}
//
//	@Test
//	public void shouldAddSubjectIntoCourse() {
//		course.addSubject(subject);
//		Assertions.assertEquals(course.getSubjects().get(0), subject);
//	}
//}
