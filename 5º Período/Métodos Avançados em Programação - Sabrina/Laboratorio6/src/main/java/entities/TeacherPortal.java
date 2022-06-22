package entities;

public class TeacherPortal {

    public TeacherPortal() {
    }

    public StringBuilder allocateSubjectIntoTeacher(String teacher, String subject) {
        StringBuilder allocatingProcess = new StringBuilder("Alocando o(a) professor(a) ");
        return allocatingProcess.append(teacher).append(" para a disciplina ").append(subject);
    }

    public StringBuilder checkTeachersDisponibility(String teacher) {
        StringBuilder checkingTeachersDisponibility = new StringBuilder("Verificando disponibilidade do(a) professor(a) ");
        return checkingTeachersDisponibility.append(teacher);
    }

    public StringBuilder getCompanyTime(String teacher) {
        StringBuilder companyTime = new StringBuilder("Tempo de casa do professor(a) ");
        return companyTime.append(teacher);
    }

}
