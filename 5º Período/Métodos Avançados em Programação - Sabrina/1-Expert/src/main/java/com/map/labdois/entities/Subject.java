package com.map.labdois.entities;

import java.util.ArrayList;
import java.util.List;

import com.map.labdois.enums.ScheduleEnum;
import com.map.labdois.enums.SubjectEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Subject {

    private SubjectEnum name;
    private Teacher teacher;
    private List<Student> students = new ArrayList<>();
    private ScheduleEnum schedule;
    private Boolean isOffered;

    public Subject(SubjectEnum name, Teacher teacher, ScheduleEnum schedule, Boolean isOffered) {
        this.name = name;
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