package app.exceptions;

/**
 * This exception will be thrown if an error occurs in the clipping process.
 * 
 * @author Luis Thiago <lthiago.github.io>
 */
public class ClipException extends Exception {

    public ClipException(String message) {
        super(message);
    } 
}