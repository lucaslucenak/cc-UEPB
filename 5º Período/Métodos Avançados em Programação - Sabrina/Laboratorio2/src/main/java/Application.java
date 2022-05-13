import entities.Alumn;
import entities.Subject;
import entities.Teacher;
import enumns.ScheduleEnum;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Teacher teacher = new Teacher(1L, "Sabrina", ScheduleEnum.INTEGRAL);

        Alumn lucas = new Alumn(1L, "Lucas", ScheduleEnum.INTEGRAL);
        Alumn daniel = new Alumn(2L, "Daniel", ScheduleEnum.INTEGRAL);

        Subject math = new Subject(1L, "Matemática", teacher, ScheduleEnum.INTEGRAL, true);
        Subject science = new Subject(2L, "Ciência", teacher, ScheduleEnum.NOTURNO, true);
        Subject history = new Subject(3L, "História", teacher, ScheduleEnum.DIURNO, true);

        teacher.addSubject(math);
        teacher.addSubject(science);
        teacher.addSubject(history);

        lucas.addSubject(math);
        lucas.addSubject(science);
        lucas.addSubject(history);
        daniel.addSubject(math);
        daniel.addSubject(history);

        math.addAlumn(lucas);
        science.addAlumn(lucas);
        history.addAlumn(lucas);
        math.addAlumn(daniel);
        history.addAlumn(daniel);

        System.out.println("a. Quais disciplinas um professor está ministrando:");
        for(Subject subject : teacher.getSubjects()) {
            System.out.println("Professor(a): " + subject.getTeacher().getName() + " | Matéria: "+ subject.getName());
        }

        System.out.println("b. Qual o horário de um professor:");
        System.out.println("Professora: " + teacher.getName() + " | Horário: " + teacher.getSchedule());

        System.out.println("c. Quais os alunos de uma dada disciplina:");
        System.out.println(science.getName());
        for(Alumn alumn : science.getAlumns()) {
            System.out.println(alumn.getName());
        }

        System.out.println("d. Quais as disciplinas de um aluno:");
        System.out.println(lucas.getName());
        for(Subject subject : lucas.getSubjects()) {
            System.out.println(subject.getName());
        }

        System.out.println("e. Qual o horário de um aluno:");
        System.out.println("Aluno: " + daniel.getName() + " | Horário: " + daniel.getSchedule());

        System.out.println("f. Qual o número de alunos de uma disciplina:");
        System.out.println("Matemática tem " + math.getAlumnsQtt() + " alunos");
    }
}
