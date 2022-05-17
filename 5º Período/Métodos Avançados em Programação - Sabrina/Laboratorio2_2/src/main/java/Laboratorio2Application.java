import entities.*;
import enumerations.CourseEnum;
import enumerations.ScheduleEnum;

import java.util.Arrays;

public class Laboratorio2Application {
    public static void main(String[] args) {
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
        Subject calculo = new Subject(sabrina, ScheduleEnum.INTEGRAL, true);
        computacao.addSubject(calculo);


        System.out.println("a. Quais disciplinas um professor está ministrando:");

        System.out.println("b. Qual o horário de um professor:");

        System.out.println("c. Quais os alunos de uma dada disciplina:");

        System.out.println("d. Quais as disciplinas de um aluno:");

        System.out.println("e. Qual o horário de um aluno:");

        System.out.println("f. Qual o número de alunos de uma disciplina:");


    }
}
