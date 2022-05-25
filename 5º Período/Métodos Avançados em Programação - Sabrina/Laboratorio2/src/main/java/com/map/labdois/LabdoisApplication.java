package com.map.labdois;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.map.labdois.entities.Coordination;
import com.map.labdois.entities.Coordinator;
import com.map.labdois.entities.Course;
import com.map.labdois.entities.Student;
import com.map.labdois.entities.Subject;
import com.map.labdois.entities.Teacher;
import com.map.labdois.entities.University;
import com.map.labdois.enums.CourseEnum;
import com.map.labdois.enums.ScheduleEnum;
import com.map.labdois.enums.SubjectEnum;

@SpringBootApplication
public class LabdoisApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabdoisApplication.class, args);
		
		 University uepb = new University();

	        Course computacao = new Course(CourseEnum.Computacao);
	        uepb.addCourse(computacao);

	        Coordination coordinationComputacao = new Coordination(computacao);
	        
	        Coordinator wellington = new Coordinator("Wellington", 24, "wellington@uepb.com", "839869999");
	        computacao.setCoordination(coordinationComputacao);
	        coordinationComputacao.setCoordinator(wellington);
	        
	        Teacher sabrina = new Teacher("Sabrina", 25, "sabrina@uepb.com", "83987654321", ScheduleEnum.INTEGRAL);
	        uepb.addTeacher(sabrina);
	        
	        Student daniel = new Student("Daniel", 21, "daniel@uepb.com", "83912341234", ScheduleEnum.INTEGRAL);
	        uepb.addStudent(daniel);
	        
	        Student lucas = new Student("Lucas", 20, "lucas@uepb.com", "83943214321", ScheduleEnum.INTEGRAL);
	        uepb.addStudent(daniel);
	        
	        Subject calculo = new Subject(SubjectEnum.Calculo, sabrina, ScheduleEnum.INTEGRAL, true);
	        computacao.addSubject(calculo);
	        
	        Subject algoritmos = new Subject(SubjectEnum.Algoritmos, sabrina, ScheduleEnum.DIURNO, true);
	        computacao.addSubject(algoritmos);
	        
	        System.out.println("a. Quais disciplinas um professor está ministrando:");
	        coordinationComputacao.addTeacherIntoSubject(sabrina, calculo);
	        coordinationComputacao.addTeacherIntoSubject(sabrina, algoritmos);
	        for (Subject subject : sabrina.getSubjects()) {
	            System.out.println("Professor(a): " + subject.getTeacher().getName() + " | Matéria: "+ subject.getName());
	        }
	        
	        System.out.println("\nb. Qual o horário de um professor:");
	        System.out.println("Professora: " + sabrina.getName() + " | Horário: " + sabrina.getSchedule());

	        System.out.println("\nc. Quais os alunos de uma dada disciplina:");
	        coordinationComputacao.addStudentIntoSubject(lucas, calculo);
	        coordinationComputacao.addStudentIntoSubject(daniel, calculo);
	        coordinationComputacao.addStudentIntoSubject(daniel, algoritmos);
	        for (Student student : calculo.getStudents()) {
	            System.out.println("Disciplina: " + calculo.getName() + " | Aluno: " + student.getName());
	        }

	        System.out.println("\nd. Quais as disciplinas de um aluno:");
	        for (Subject subject : daniel.getSubjects()) {
	            System.out.println("Aluno: " + daniel.getName() + " | Disciplina: " + subject.getName());
	        }

	        System.out.println("\ne. Qual o horário de um aluno:");
	        System.out.println("Aluno: " + lucas.getName() + " | Horário: " + lucas.getSchedule());

	        System.out.println("\nf. Qual o número de alunos de uma disciplina:");
	        System.out.println("Aluno: " + calculo.getName() + " | Quantidade de alunos: " + coordinationComputacao.getAlumnsQtt(calculo));

	}
	

}
