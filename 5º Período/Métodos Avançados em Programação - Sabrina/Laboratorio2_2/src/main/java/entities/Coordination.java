package entities;

import enumerations.ScheduleEnum;
import exceptions.SchedulesDoesntMatchException;
import exceptions.SubjectNotOfferedException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coordination {
    private Coordinator coordinator;
    private Course course;

    public Coordination(Coordinator coordinator, Course course) {
        this.coordinator = coordinator;
        this.course = course;
    }

    public Coordination() {
    }

    public void addStudentIntoSubject(Student student, Subject subject) {
        if (!subject.getIsOffered()) {
            throw new SubjectNotOfferedException("Materia nao ofertada.");
        }

        if (subject.getSchedule() != student.getSchedule() && subject.getSchedule() != ScheduleEnum.INTEGRAL) {
            throw new SchedulesDoesntMatchException("Matéria de outro turno.");
        }
         subject.addStudent(student);
    }
}
