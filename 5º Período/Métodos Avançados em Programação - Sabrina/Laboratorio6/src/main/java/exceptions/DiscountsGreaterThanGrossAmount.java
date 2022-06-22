package exceptions;

public class DiscountsGreaterThanGrossAmount  extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DiscountsGreaterThanGrossAmount(String msg) {
        super(msg);
    }
}
