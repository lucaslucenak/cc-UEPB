package exceptions;

public class RoleExistsExceptions extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RoleExistsExceptions(String msg) {
        super(msg);
    }
}
