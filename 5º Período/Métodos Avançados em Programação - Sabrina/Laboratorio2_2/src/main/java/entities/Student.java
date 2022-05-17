package entities;

import enumerations.ScheduleEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Student extends People{

    private ScheduleEnum schedule;
    private List<Subject> subjects = new ArrayList<>();

    public Student(String name, Integer age, String email, String phoneNumber, ScheduleEnum schedule) {
        super(name, age, email, phoneNumber);
        this.schedule = schedule;
    }

    public Student(ScheduleEnum schedule) {
        this.schedule = schedule;
    }

    public Student() {
    }
}
