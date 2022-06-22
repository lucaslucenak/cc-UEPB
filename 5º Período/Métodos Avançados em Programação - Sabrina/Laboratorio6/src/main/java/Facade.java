import entities.*;

import java.util.List;

public class Facade {
    Administrative administrative = new Administrative();
    Financial financial = new Financial();
    TeacherPortal teacherPortal = new TeacherPortal();
    StudentPortal studentPortal = new StudentPortal();
    Warehouse warehouse = new Warehouse();
    InfrastructuralSystem infrastructuralSystem = new InfrastructuralSystem();

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

    public void showPayroll(String title, Double discounts, Double grossAmount) {
        System.out.println(financial.getPayRoll(title, discounts, grossAmount));
    }

    public void allocateSubjectIntoTeacher(String teacher, String subject) {
        System.out.println(teacherPortal.checkTeachersDisponibility(teacher));
        System.out.println(teacherPortal.allocateSubjectIntoTeacher(teacher, subject));
    }

    public void getCompanyTime(String teacher) {
        System.out.println(teacherPortal.getCompanyTime(teacher));
    }

    public void getStudentHistory(String student) {
        System.out.println(studentPortal.getStudentHistory(student));
    }

    public void getStudentRDM(String student) {
        System.out.println(studentPortal.getStudentRDM(student));
    }

    public void getWarehouseInventory() {
        System.out.println(warehouse.getInventory());
    }

    public void requestPurchaseOrder(String product) {
        System.out.println(warehouse.requestPurchaseOrder(product));
        System.out.println(warehouse.confirmPurchaseOrder(product));
    }

    public void allocateClassroom(String classroom) {
        System.out.println(infrastructuralSystem.checkClassroomDisponibility(classroom));
        System.out.println(infrastructuralSystem.allocateClassroom(classroom));
    }

}