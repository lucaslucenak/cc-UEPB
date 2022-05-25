package com.map.labdois.entities;

import com.map.labdois.enums.ScheduleEnum;
import com.map.labdois.enums.SubjectEnum;
import com.map.labdois.exceptions.SchedulesDoesntMatchException;
import com.map.labdois.exceptions.SubjectNotOfferedException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Stream;

@Getter
@Setter
@Builder
public class AcademicControl {


    public AcademicControl() {
    }

    public Integer getSubjectStudentQuantity(SubjectEnum subject, University university) {
        Subject sbj = null;
        for (Subject x : university.getSubjects()) {
            if (x.getName() == subject) {
                sbj = x;
            }
        }
        return  sbj.getStudents().size();
//        university.getSubjects().stream().filter(sbj -> sbj.getName() == subject).forEach(sbj -> sbj.getStudents().size());
    }

    public void addSubjectIntoStudent(String studentName, SubjectEnum subject, University university) {
        Student studentToSet = null;
        Subject subjectToSet = null;

        for (Subject sbj : university.getSubjects()) {
            if (sbj.getName() == subject) {
                subjectToSet = sbj;
            }
        }
        for (Student std : university.getStudents()) {
            if (std.getName().equals(studentName)) {
                studentToSet = std;
            }
        }

        if (!subjectToSet.getIsOffered()) {
            throw new SubjectNotOfferedException("Matéria não ofertada");
        }

        if (studentToSet.getRdm().getSchedule() != subjectToSet.getSchedule() && subjectToSet.getSchedule() != ScheduleEnum.INTEGRAL && studentToSet.getRdm().getSchedule() != ScheduleEnum.INTEGRAL) {
            throw new SchedulesDoesntMatchException("Horários não compatíveis");
        }
        studentToSet.getRdm().addSubjectIntoRdm(subjectToSet);
        subjectToSet.addStudent(studentToSet);
    }

    public List<Teacher> getUniversityTeachers(University university) {
        return university.getTeachers();
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

//    public void addTeacherIntoSubject(Teacher teacher, Subject subject) {
//        if (!subject.getIsOffered()) {
//            throw new SubjectNotOfferedException("Materia nao ofertada.");
//        }
//        if (subject.getSchedule() != teacher.getSchedule() && subject.getSchedule() != ScheduleEnum.INTEGRAL &&
//                teacher.getSchedule() != ScheduleEnum.INTEGRAL) {
//            throw new SchedulesDoesntMatchException("O horário do professor e o horário da matéria não batem.");
//        }
//        teacher.addSubject(subject);
//        subject.setTeacher(teacher);
//    }

    public List<Student> getSubjectStudents(Subject subject) {
        return subject.getStudents();
    }

//    public int getSubjectStudentQuantity(Subject subject) {
//        return subject.getStudents().size();
//    }

    public List<Subject> getTeacherSubjects(Teacher teacher) {
        return teacher.getSubjects();
    }

    public void addTeacherIntoUniversity(Teacher teacher, University university) {
        university.getTeachers().add(teacher);
    }

    public void addStudentIntoUniversity(Student student, University university) {
        university.getStudents().add(student);
    }

    public void addSubjectIntoUniversity(Subject subject, University university) {
        university.getSubjects().add(subject);
    }


}
