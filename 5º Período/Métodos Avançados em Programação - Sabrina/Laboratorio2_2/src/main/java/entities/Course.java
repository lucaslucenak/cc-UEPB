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
    private List<Student> students = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private Coordination coordination;

    public Course(Coordination coordination) {
        this.coordination = coordination;
    }

    public Course() {
    }
}
