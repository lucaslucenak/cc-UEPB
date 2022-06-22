import entities.Administrative;
import entities.Bill;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Facade facade = new Facade();
        List<String> participants = new ArrayList<>();
        participants.add("Lucas");
        participants.add("Daniel");
        facade.scheduleNewMeeting(participants, "22/06/2022", "18:00", "Promoção");
        System.out.println("------------------------------------------------------------------------");
        facade.scheduleNewInterview(participants, "22/06/2022", "18:00", "Promoção");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------");
        List<Bill> accountBalance = new ArrayList<>();
        accountBalance.add(new Bill("Agua", 75.68));
        accountBalance.add(new Bill("Energia", 30.68));
        facade.showAccountBalance(accountBalance);
        System.out.println("------------------------------------------------------------------------");
        facade.showPayroll("Folha de pagamento de lucas", 100.00, 1000.00);
        System.out.println("------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------");
        facade.allocateSubjectIntoTeacher("Sabrina", "MAP");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------");
        facade.getStudentHistory("Daniel");
        facade.getStudentRDM("Lucas");

    }
}
