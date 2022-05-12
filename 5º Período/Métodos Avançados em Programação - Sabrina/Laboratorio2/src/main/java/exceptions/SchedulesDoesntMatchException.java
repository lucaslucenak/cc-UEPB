package exceptions;

public class SchedulesDoesntMatchException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SchedulesDoesntMatchException(String msg) {
        super(msg);
    }
}
