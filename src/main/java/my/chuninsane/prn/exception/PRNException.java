package my.chuninsane.prn.exception;

/**
 * @author chuninsane
 */
public class PRNException extends RuntimeException {

    private static final long serialVersionUID = 555975860074453007L;

    public PRNException() {
    }

    public PRNException(String message) {
        super(message);
    }

    public PRNException(String message, Throwable cause) {
        super(message, cause);
    }
}
