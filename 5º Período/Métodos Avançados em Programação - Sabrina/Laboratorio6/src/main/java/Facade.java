import entities.*;

import java.util.List;

public class Facade {
    Administrative administrative = new Administrative();
    Financial financial = new Financial();
    TeacherPortal teacherPortal = new TeacherPortal();
    StudentPortal studentPortal = new StudentPortal();

    public Facade() {
    }

    public void scheduleNewMeeting(List<String> participants, String date, String schedule, String title) {
        System.out.println(administrative.organizeMeeting(participants, date, schedule, title));
        System.out.println(administrative.scheduleMeetingOnCalendar(title));
    }

    public void scheduleNewInterview(List<String> participants, String date, String schedule, String title) {
        System.out.println(administrative.organizeInterview(participants, date, schedule, title));
        System.out.println(administrative.scheduleInterviewOnCalendar(title));
    }

    public void showAccountBalance(List<Bill> payroll) {
        System.out.println(financial.getAccountBalance(payroll));
    }

    public void showPayroll(String title, Double discounts, Double bruteValue) {
        System.out.println(financial.getPayRoll(title, discounts, bruteValue));
    }

    public void allocateSubjectIntoTeacher(String teacher, String subject) {
        System.out.println(teacherPortal.verifyTeachersDisponibility(teacher));
        System.out.println(teacherPortal.allocateSubjectIntoTeacher(teacher, subject));
    }

    public void getStudentHistory(String student) {
        System.out.println(studentPortal.getStudentHistory(student));
    }

    public void getStudentRDM(String student) {
        System.out.println(studentPortal.getStudentRDM(student));
    }
}