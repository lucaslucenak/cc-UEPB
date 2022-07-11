package entities;

public class InfrastructuralSystem {

    public InfrastructuralSystem() {
    }

    public StringBuilder allocateClassroom(String room) {
        StringBuilder allocatingClassroom = new StringBuilder("Alocando a sala ");
        return allocatingClassroom.append(room);
    }

    public StringBuilder checkClassroomDisponibility(String room) {
        StringBuilder checkingClassroomDisponibility = new StringBuilder("Verificando a disponibilidade da sala ");
        return checkingClassroomDisponibility.append(room);
    }
}
