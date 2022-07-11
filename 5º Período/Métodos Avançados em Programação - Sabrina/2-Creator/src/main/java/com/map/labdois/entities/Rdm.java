package com.map.labdois.entities;

import com.map.labdois.enums.ScheduleEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Rdm {
    private ScheduleEnum schedule;
    private List<Subject> subjects = new ArrayList<>();

    public Rdm(ScheduleEnum schedule, List<Subject> subjects) {
        this.schedule = schedule;
        this.subjects = subjects;
    }

    public Rdm(ScheduleEnum schedule) {
        this.schedule = schedule;
    }

    public Rdm() {
    }

    public void addSubjectIntoRdm(Subject subject) {
        subjects.add(subject);
    }

}
