package exceptions;

public class FigureWithAttributeEqualsZeroException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public FigureWithAttributeEqualsZeroException(String msg) {
        super(msg);
    }
}
