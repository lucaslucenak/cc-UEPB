package entities;

import enumns.ScheduleEnum;
import exceptions.SchedulesDoesntMatchException;
import exceptions.SubjectNotOfferedException;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private Long id;
    private String name;
    private Teacher teacher;
    private List<Alumn> alumns = new ArrayList<>();
    private ScheduleEnum schedule;
    private Boolean isOffered;

    public Subject() {
    }

    public Subject(Long id, String name, Teacher teacher, ScheduleEnum schedule, Boolean isOffered) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.schedule = schedule;
        this.isOffered = isOffered;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Alumn> getAlumns() {
        return alumns;
    }

    public ScheduleEnum getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleEnum schedule) {
        this.schedule = schedule;
    }

    public Boolean getOffered() {
        return isOffered;
    }

    public void setOffered(Boolean offered) {
        isOffered = offered;
    }

    public int getAlumnsQtt() {
        return alumns.size();
    }

    public void addAlumn(Alumn alumn) {
        //subject integral
        //aluno noturno
        if (!getOffered()) {
            throw new SubjectNotOfferedException("Materia nao ofertada.");
        }

        if (getSchedule() != alumn.getSchedule() && getSchedule() != ScheduleEnum.INTEGRAL) {
            throw new SchedulesDoesntMatchException("Matéria de outro turno.");
        }
        alumns.add(alumn);
    }
}
