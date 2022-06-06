package com.map.labdois;

import com.map.labdois.entities.*;
import com.map.labdois.entities.Rdm;
import com.map.labdois.enums.CourseEnum;
import com.map.labdois.enums.ScheduleEnum;
import com.map.labdois.enums.SubjectEnum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LabdoisApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabdoisApplication.class, args);

		University UEPB = new University();
		AcademicControl CA = new AcademicControl();


		Teacher sabrina = new Teacher("Sabrina", 25, "sabrina@uepb.com", "83987654321", ScheduleEnum.INTEGRAL);
		CA.addTeacherIntoUniversity(sabrina, UEPB);

		Student daniel = new Student("Daniel", 21, "daniel@uepb.com", "83912341234", new Rdm(ScheduleEnum.INTEGRAL), 10.0);
		CA.addStudentIntoUniversity(daniel, UEPB);

		Student lucas = new Student("Lucas", 20, "lucas@uepb.com", "83943214321", new Rdm(ScheduleEnum.INTEGRAL), 10.0);
		CA.addStudentIntoUniversity(lucas, UEPB);

		Subject calculo = new Subject(SubjectEnum.Calculo, sabrina, ScheduleEnum.INTEGRAL, true);
		CA.addSubjectIntoUniversity(calculo, UEPB);

		Subject algoritmos = new Subject(SubjectEnum.Algoritmos, sabrina, ScheduleEnum.DIURNO, true);
		CA.addSubjectIntoUniversity(algoritmos, UEPB);

		System.out.println("a. Quais disciplinas um professor está ministrando:");
		CA.addTeacherIntoSubject(sabrina, calculo);
		CA.addTeacherIntoSubject(sabrina, algoritmos);
		for (Subject subject : CA.getTeacherSubjects(sabrina)) {
			System.out.println("Professor(a): " + subject.getTeacher().getName() + " | Matéria: "+ subject.getName());
		}

		System.out.println("\nb. Qual o horário de um professor:");
		System.out.println("Professora: " + sabrina.getName() + " | Horário: " + CA.getTeacherSchedule(sabrina));
		System.out.println("\nc. Quais os alunos de uma dada disciplina:");
		CA.addSubjectIntoStudent(lucas, calculo);
		CA.addSubjectIntoStudent(daniel, calculo);
		CA.addSubjectIntoStudent(daniel, algoritmos);
		for (Student student : CA.getSubjectStudents(calculo)) {
			System.out.println("Disciplina: " + calculo.getName() + " | Aluno: " + student.getName());
		}

		System.out.println("\nd. Quais as disciplinas de um aluno:");
		for (Subject subject : CA.getStudentSubjects(daniel)) {
			System.out.println("Aluno: " + daniel.getName() + " | Disciplina: " + subject.getName());
		}

		System.out.println("\ne. Qual o horário de um aluno:");
		System.out.println("Aluno: " + lucas.getName() + " | Horário: " + CA.getStudentSchedule(lucas));

		System.out.println("\nf. Qual o número de alunos de uma disciplina:");
		System.out.println("Aluno: " + calculo.getName() + " | Quantidade de alunos: " + CA.getSubjectStudentQuantity(calculo));

	}
}
