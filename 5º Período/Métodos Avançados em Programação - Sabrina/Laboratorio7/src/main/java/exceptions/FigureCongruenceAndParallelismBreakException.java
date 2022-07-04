package exceptions;

public class FigureCongruenceAndParallelismBreakException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public FigureCongruenceAndParallelismBreakException(String msg) {
        super(msg);
    }
}
