package my.chuninsane.prn.exception;

/**
 * @author chuninsane
 */
public class NotSupportCommandException extends PRNException {

    private static final long serialVersionUID = 8832642062750118630L;

    public NotSupportCommandException() {
    }

    public NotSupportCommandException(String message) {
        super(message);
    }

    public NotSupportCommandException(String message, Throwable cause) {
        super(message, cause);
    }
}
