package entities;

import enumns.ScheduleEnum;
import exceptions.SubjectNotOfferedException;
import exceptions.DifferentShedule;

import java.util.ArrayList;
import java.util.List;

public class Alumn {

    private Long id;
    private String name;
    private ScheduleEnum schedule;
    private List<Subject> subjects = new ArrayList<>();

    public Alumn() {
    }

    public Alumn(Long id, String name, ScheduleEnum schedule) {
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

    public ScheduleEnum getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleEnum schedule) {
        this.schedule = schedule;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(Subject subject) {
        if (!subject.getOffered()) {
            throw new SubjectNotOfferedException("Materia nao ofertada.");
        }
        if (getSchedule() != subject.getSchedule()){
            throw new DifferentShedule("Aluno matriculado em outro turno.");
        }
        subjects.add(subject);
    }
}
