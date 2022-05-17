package entities;

import enumerations.ScheduleEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Subject {

    private Teacher teacher;
    private List<Student> students = new ArrayList<>();
    private ScheduleEnum schedule;
    private Boolean isOffered;

    public Subject(Teacher teacher, ScheduleEnum schedule, Boolean isOffered) {
        this.teacher = teacher;
        this.schedule = schedule;
        this.isOffered = isOffered;
    }

    public Subject() {
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}
