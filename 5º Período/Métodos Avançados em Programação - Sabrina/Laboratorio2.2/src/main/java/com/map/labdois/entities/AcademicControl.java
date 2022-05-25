package com.map.labdois.entities;

import com.map.labdois.enums.ScheduleEnum;
import com.map.labdois.exceptions.SchedulesDoesntMatchException;
import com.map.labdois.exceptions.SubjectNotOfferedException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class AcademicControl {


    public AcademicControl() {
    }

    public void addSubjectIntoStudent(Student student, Subject subject) {

        if (!subject.getIsOffered()) {
            throw new SubjectNotOfferedException("Materia nao ofertada.");
        }

        if (subject.getSchedule() != student.getRdm().getSchedule() && subject.getSchedule() != ScheduleEnum.INTEGRAL &&
                student.getRdm().getSchedule() != ScheduleEnum.INTEGRAL) {
            throw new SchedulesDoesntMatchException("O horário do aluno e o horário da matéria não batem.");
        }
        subject.addStudent(student);
        student.getRdm().addSubjectIntoRdm(subject);
    }

    public Double getStudentCra(Student student) {
        return student.getCra();
    }

    public ScheduleEnum getTeacherSchedule(Teacher teacher) {
        return teacher.getSchedule();
    }

    public List<Subject> getStudentSubjects(Student student) {
        return student.getRdm().getSubjects();
    }

    public ScheduleEnum getStudentSchedule(Student student) {
        return student.getRdm().getSchedule();
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

    public List<Student> getSubjectStudents(Subject subject) {
        return subject.getStudents();
    }

    public int getSubjectStudentQuantity(Subject subject) {
        return subject.getStudents().size();
    }

    public List<Subject> getTeacherSubjects(Teacher teacher) {
        return teacher.getSubjects();
    }

}
