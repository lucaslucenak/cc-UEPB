package exceptions;

public class EmployeeCantBeActorAndCameramanException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EmployeeCantBeActorAndCameramanException(String msg) {
        super(msg);
    }
}
