package exceptions;

public class DiscountsGreaterThanGrossAmountException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DiscountsGreaterThanGrossAmountException(String msg) {
        super(msg);
    }
}
