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
//public class UniversityTest {
//
//	private Subject subject;
//	private Teacher teacher;
//	private Student student;
//	private University university;
//	private Course course;
//
//	@BeforeEach
//	void setUp() throws Exception {
//		university = new University();
//
//		teacher = new Teacher("Sabrina", 25, "sabrina@uepb.com", "83987654321", ScheduleEnum.INTEGRAL);
//		subject = new Subject(SubjectEnum.Calculo, teacher, ScheduleEnum.INTEGRAL, true);
//		student = new Student("Daniel", 21, "daniel@uepb.com", "83912341234", ScheduleEnum.INTEGRAL);
//		course = new Course(CourseEnum.Computacao);
//
//	}
//
//	@Test
//	public void shouldAddTeacher() {
//		university.addTeacher(teacher);
//		Assertions.assertEquals(teacher, university.getTeachers().get(0));
//	}
//
//	@Test
//	public void shouldAddStudent() {
//		university.addStudent(student);
//		Assertions.assertEquals(student, university.getStudents().get(0));
//	}
//
//	@Test
//	public void shouldAddCourse() {
//		university.addCourse(course);
//		Assertions.assertEquals(course, university.getCourses().get(0));
//	}
//}
