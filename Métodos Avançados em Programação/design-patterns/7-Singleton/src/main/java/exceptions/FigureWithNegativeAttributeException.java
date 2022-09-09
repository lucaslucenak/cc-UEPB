package exceptions;

public class FigureWithNegativeAttributeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public FigureWithNegativeAttributeException(String msg) {
        super(msg);
    }
}
