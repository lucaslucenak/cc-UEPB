package com.map.labdois.entities;

import java.util.ArrayList;
import java.util.List;

import com.map.labdois.enums.ScheduleEnum;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends People {

    private Rdm rdm;
    private Double cra;

    public Student(String name, Integer age, String email, String phoneNumber, Rdm rdm, Double cra) {
        super(name, age, email, phoneNumber);
        this.rdm = rdm;
        this.cra = cra;
    }

    public Student(Rdm rdm, Double cra) {
        this.rdm = rdm;
        this.cra = cra;
    }

    public Student() {
    }

//    public void addSubject(Subject subject) {
//        subjects.add(subject);
//    }
}
