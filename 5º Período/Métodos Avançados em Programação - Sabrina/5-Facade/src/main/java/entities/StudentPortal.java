package entities;

public class StudentPortal {

    public StudentPortal() {
    }

    public StringBuilder getStudentHistory(String student) {
        StringBuilder studentHistory = new StringBuilder("Suposto histórico do aluno ");
        return studentHistory.append(student);
    }

    public StringBuilder getStudentRDM(String student) {
        StringBuilder studentRDM = new StringBuilder("Suposto RDM do aluno ");
        return studentRDM.append(student);
    }

}
