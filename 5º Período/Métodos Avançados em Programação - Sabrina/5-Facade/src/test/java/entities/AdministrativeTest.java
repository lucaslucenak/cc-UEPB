package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AdministrativeTest {
    Administrative administrative;

    @BeforeEach
    void setUp() {
        administrative = new Administrative();
    }

    @Test
    public void shouldOrganizeMeeting() {
        List<String> participants = new ArrayList<>();
        participants.add("Lucas");
        participants.add("Daniel");

        StringBuilder expected = new StringBuilder("Titulo da reunião: Promoção\n" +
                "Parcicipantes: Lucas\n" +
                "Daniel\n" +
                "Data: 22/06/2022\n" +
                "Hora: 18:00");
        Assertions.assertEquals(expected.toString(), administrative.organizeMeeting(participants, "22/06/2022", "18:00", "Promoção").toString());
    }

    @Test
    public void shouldScheduleMeetingOnCalendar() {
        Assertions.assertEquals(administrative.scheduleMeetingOnCalendar("Promoção"), "Reunião Promoção agendada");
    }

    @Test
    public void shouldOrganizeInterview() {
        List<String> participants = new ArrayList<>();
        participants.add("Lucas");
        participants.add("Daniel");

        StringBuilder expected = new StringBuilder("Titulo da entrevista: Estágio\n" +
                "Parcicipantes: Lucas\n" +
                "Daniel\n" +
                "Data: 22/06/2022\n" +
                "Hora: 18:00");
        Assertions.assertEquals(expected.toString(), administrative.organizeInterview(participants, "22/06/2022", "18:00", "Estágio").toString());
    }

    @Test
    public void shouldScheduleInterviewOnCalendar() {
        Assertions.assertEquals("Entrevista Estágio agendada", administrative.scheduleInterviewOnCalendar("Estágio"));
    }


}
