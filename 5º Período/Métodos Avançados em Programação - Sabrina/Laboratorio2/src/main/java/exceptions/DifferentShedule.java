package exceptions;

public class DifferentShedule extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DifferentShedule(String msg) {
        super(msg);
    }
}
