package com.map.labdois.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class University {

    private List<Subject> subjects = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private AcademicControl CA;

    public University(AcademicControl academicControl) {

    }

    public University() {
    }

//    public void addTeacher(Teacher teacher) {
//        teachers.add(teacher);
//    }
//
//    public void addStudent(Student student) {
//        students.add(student);
//    }
//
//    public void addCourse(Course course) {
//        courses.add(course);
//    }
}
