package com.map.labdois.entities;

import java.util.ArrayList;
import java.util.List;

import com.map.labdois.enums.CourseEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {

    private CourseEnum name;
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
