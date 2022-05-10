package entities;

import java.util.ArrayList;
import java.util.List;

public class Teacher {

    private Long id;
    private String name;
    private String schedule;
    private List<Subject> subjects = new ArrayList<>();

    public Teacher() {
    }

    public Teacher(Long id, String name, String schedule) {
        this.id = id;
        this.name = name;
        this.schedule = schedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }
}