package com.map.labdois.entities;

import java.util.ArrayList;
import java.util.List;

import com.map.labdois.enums.ScheduleEnum;

import com.map.labdois.enums.SubjectEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Teacher extends People {

    private ScheduleEnum schedule;
    private List<Subject> subjects = new ArrayList<>();

    public Teacher(String name, Integer age, String email, String phoneNumber, ScheduleEnum schedule) {
        super(name, age, email, phoneNumber);
        this.schedule = schedule;
    }

    public Teacher(ScheduleEnum schedule) {
        this.schedule = schedule;
    }

    public Teacher() {
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }
}
