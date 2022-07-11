package com.map.labdois.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.map.labdois.enums.ScheduleEnum;
import com.map.labdois.enums.SubjectEnum;
import com.map.labdois.exceptions.SchedulesDoesntMatchException;
import com.map.labdois.exceptions.SubjectNotOfferedException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class University {

    private List<Subject> subjects;
    private List<Teacher> teachers;
    private List<Student> students;
    private AcademicControl CA;

    public University() {
        subjects = new ArrayList<>();
        teachers = new ArrayList<>();
        students = new ArrayList<>();

        this.CA = new AcademicControl();
    }

    public void addNewTeacher(String name, Integer age, String email, String phoneNumber, ScheduleEnum schedule) {
        teachers.add(new Teacher(name, age, email, phoneNumber, schedule));
    }

    public void addNewStudent(String name, Integer age, String email, String phoneNumber, Double cra, ScheduleEnum schedule) {
        students.add(new Student(name, age, email, phoneNumber, cra, schedule));
    }

    public void addNewSubject(SubjectEnum name, ScheduleEnum schedule, Boolean isOffered, Teacher teacher) {
        if (!isOffered) {
            throw new SubjectNotOfferedException("Matéria não ofertada");
        }
        if (teacher.getSchedule() != schedule && schedule != ScheduleEnum.INTEGRAL && teacher.getSchedule() != ScheduleEnum.INTEGRAL) {
            throw new SchedulesDoesntMatchException("Horários não compatíveis");
        }

        subjects.add(new Subject(name, schedule, isOffered, teacher));
        teacher.addSubject(subjects.stream().filter(subject -> subject.getName() == name).collect(Collectors.toList()).get(0));
    }

}
