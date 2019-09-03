package my.chuninsane.prn.exception;

/**
 * Insufficient parameter exception
 *
 * @author chuninsane
 */
public class InsufficientParameterException extends PRNException {

    private static final long serialVersionUID = -600735716634568884L;

    public InsufficientParameterException() {
    }

    public InsufficientParameterException(String message) {
        super(message);
    }

    public InsufficientParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}
