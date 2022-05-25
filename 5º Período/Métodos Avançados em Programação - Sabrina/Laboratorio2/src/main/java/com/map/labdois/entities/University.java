package com.map.labdois.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class University {

    private List<Course> courses = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public University() {
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }
}
