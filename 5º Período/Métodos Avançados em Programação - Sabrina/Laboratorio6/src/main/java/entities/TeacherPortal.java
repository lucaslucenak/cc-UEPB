package entities;

public class TeacherPortal {

    public TeacherPortal() {
    }

    public StringBuilder allocateSubjectIntoTeacher(String teacher, String subject) {
        StringBuilder allocatingProcess = new StringBuilder("Alocando o(a) professor(a) ");
        return allocatingProcess.append(teacher).append(" para a disciplina ").append(subject);
    }

    public StringBuilder verifyTeachersDisponibility(String teacher) {
        StringBuilder checkingTeachersDisponibility = new StringBuilder("Verificando disponibilidade do(a) professor(a) ");
        return checkingTeachersDisponibility.append(teacher);
    }

}
