package entities;

import enumerations.CourseEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Course {

    private CourseEnum name;
    private Coordination coordination;
    private List<Subject> subjects = new ArrayList<>();

    public Course(CourseEnum name) {
        this.name = name;
    }

    public Course() {
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }
}
