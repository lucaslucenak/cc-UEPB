package exceptions;

public class FigureCongruenceOrParallelismBreakException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public FigureCongruenceOrParallelismBreakException(String msg) {
        super(msg);
    }
}
