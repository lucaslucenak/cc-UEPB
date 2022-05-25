package com.map.labdois.entities;

import java.util.List;

import com.map.labdois.enums.ScheduleEnum;
import com.map.labdois.exceptions.SchedulesDoesntMatchException;
import com.map.labdois.exceptions.SubjectNotOfferedException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coordination {
    private Coordinator coordinator;
    private Course course;

    public Coordination(Course course) {
        this.course = course;
    }

    public Coordination() {
    }
    
    public List<Student> getSubjectStudents(Subject subject) {
    	return subject.getStudents();
    }
    
    public void addSubjectIntoTeacher(Subject subject, Teacher teacher) {
    	teacher.addSubject(subject);
    }
    
    public void addSubjectIntoCourse(Subject subject, Course course) {
    	course.addSubject(subject);
    }
    
    public void addSubjectIntoStudent(Subject subject, Student student) {
    	student.addSubject(subject);
    }
    
    public int getAlumnsQtt(Subject subject) {
        return subject.getStudents().size();
    }

    public void addStudentIntoSubject(Student student, Subject subject) {
        if (!subject.getIsOffered()) {
            throw new SubjectNotOfferedException("Materia nao ofertada.");
        }

        if (subject.getSchedule() != student.getSchedule() && subject.getSchedule() != ScheduleEnum.INTEGRAL &&
                student.getSchedule() != ScheduleEnum.INTEGRAL) {
            throw new SchedulesDoesntMatchException("O horário do aluno e o horário da matéria não batem.");
        }
        subject.addStudent(student);
        student.addSubject(subject);
    }

    public void addTeacherIntoSubject(Teacher teacher, Subject subject) {
        if (!subject.getIsOffered()) {
            throw new SubjectNotOfferedException("Materia nao ofertada.");
        }
        if (subject.getSchedule() != teacher.getSchedule() && subject.getSchedule() != ScheduleEnum.INTEGRAL &&
        teacher.getSchedule() != ScheduleEnum.INTEGRAL) {
            throw new SchedulesDoesntMatchException("O horário do professor e o horário da matéria não batem.");
        }
        teacher.addSubject(subject);
        subject.setTeacher(teacher);
    }
}
