import entities.Administrative;
import entities.Bill;
import entities.Financial;

import java.util.List;

public class Facade {
    Administrative administrative = new Administrative();
    Financial financial = new Financial();

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
}