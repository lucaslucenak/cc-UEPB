package com.map.labdois;

import com.map.labdois.entities.*;
import com.map.labdois.entities.Rdm;
import com.map.labdois.enums.CourseEnum;
import com.map.labdois.enums.ScheduleEnum;
import com.map.labdois.enums.SubjectEnum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

@SpringBootApplication
public class LabdoisApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabdoisApplication.class, args);

		University UEPB = new University();

		Course computacao = new Course(CourseEnum.Computacao);

//		Teacher sabrina = new Teacher("Sabrina", 25, "sabrina@uepb.com", "83987654321", ScheduleEnum.INTEGRAL);
		UEPB.addNewTeacher("Sabrina", 25, "sabrina@uepb.com", "83987654321", ScheduleEnum.INTEGRAL);
//		CA.addTeacherIntoUniversity(sabrina, UEPB);


//		Student daniel = new Student("Daniel", 21, "daniel@uepb.com", "83912341234", 10.0, ScheduleEnum.INTEGRAL);
		UEPB.addNewStudent("Daniel", 21, "daniel@uepb.com", "83912341234", 10.0, ScheduleEnum.INTEGRAL);
//		UEPB.getCA().addStudentIntoUniversity(daniel, UEPB);

		UEPB.addNewStudent("Lucas", 20, "lucas@uepb.com", "83943214321", 10.0, ScheduleEnum.INTEGRAL);
//		UEPB.getCA().addStudentIntoUniversity(lucas, UEPB);


//		UEPB.addNewSubject(SubjectEnum.Calculo, ScheduleEnum.INTEGRAL, true, UEPB.getTeachers().stream().filter(teacher -> Objects.equals(teacher.getName(), "Sabrina")));
//		System.exit(0);
//		UEPB.getCA().setSubjectTeacher(UEPB.getTeachers().stream().filter(teacher -> Objects.equals(teacher.getName(), "Sabrina")));
//		System.out.println(UEPB.getSubjects().get(0).getTeacher());


//		Subject calculo = new Subject(SubjectEnum.Calculo, sabrina, ScheduleEnum.INTEGRAL, true);
//		UEPB.getCA().addSubjectIntoUniversity(calculo, UEPB);
//
//		Subject algoritmos = new Subject(SubjectEnum.Algoritmos, sabrina, ScheduleEnum.DIURNO, true);
//		UEPB.getCA().addSubjectIntoUniversity(algoritmos, UEPB);
//
//		System.out.println("a. Quais disciplinas um professor está ministrando:");
//		UEPB.getCA().addTeacherIntoSubject(sabrina, calculo);
//		UEPB.getCA().addTeacherIntoSubject(sabrina, algoritmos);
//		for (Subject subject : UEPB.getCA().getTeacherSubjects(sabrina)) {
//			System.out.println("Professor(a): " + subject.getTeacher().getName() + " | Matéria: "+ subject.getName());
//		}
//
//		System.out.println("\nb. Qual o horário de um professor:");
//		System.out.println("Professora: " + sabrina.getName() + " | Horário: " + UEPB.getCA().getTeacherSchedule(sabrina));
//		System.out.println("\nc. Quais os alunos de uma dada disciplina:");
//		UEPB.getCA().addSubjectIntoStudent(lucas, calculo);
//		UEPB.getCA().addSubjectIntoStudent(daniel, calculo);
//		UEPB.getCA().addSubjectIntoStudent(daniel, algoritmos);
//		for (Student student : UEPB.getCA().getSubjectStudents(calculo)) {
//			System.out.println("Disciplina: " + calculo.getName() + " | Aluno: " + student.getName());
//		}
//
//		System.out.println("\nd. Quais as disciplinas de um aluno:");
//		for (Subject subject : UEPB.getCA().getStudentSubjects(daniel)) {
//			System.out.println("Aluno: " + daniel.getName() + " | Disciplina: " + subject.getName());
//		}
//
//		System.out.println("\ne. Qual o horário de um aluno:");
//		System.out.println("Aluno: " + lucas.getName() + " | Horário: " + UEPB.getCA().getStudentSchedule(lucas));
//
//		System.out.println("\nf. Qual o número de alunos de uma disciplina:");
//		System.out.println("Aluno: " + calculo.getName() + " | Quantidade de alunos: " + UEPB.getCA().getSubjectStudentQuantity(calculo));

	}
}
