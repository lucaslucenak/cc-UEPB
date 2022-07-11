package entities;

import java.util.List;

public class Administrative {

    public Administrative() {
    }

    public StringBuilder organizeMeeting(List<String> participants, String date, String schedule, String title) {
        StringBuilder meeting = new StringBuilder("Titulo da reunião: " + title + "\nParcicipantes: ");
        for (String i : participants){
            meeting.append(i).append("\n");
        }
        meeting.append("Data: ").append(date).append("\n").append("Hora: ").append(schedule);
        return meeting;
    }

    public String scheduleMeetingOnCalendar(String title) {
        return "Reunião " + title + " agendada";
    }

    public StringBuilder organizeInterview(List<String> participants, String date, String schedule, String title) {
        StringBuilder interview = new StringBuilder("Titulo da entrevista: "+ title + "\nParcicipantes: ");
        for (String i : participants){
            interview.append(i).append("\n");
        }
        interview.append("Data: ").append(date).append("\n").append("Hora: ").append(schedule);
        return interview;
    }

    public String scheduleInterviewOnCalendar(String title) {
        return "Entrevista " + title + " agendada";
    }
}
