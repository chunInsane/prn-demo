package my.chuninsane.prn.exception;

/**
 * Algorithm exception
 *
 * @author chuninsane
 */
public class AlgorithmException extends PRNException {

    private static final long serialVersionUID = -4976911387591266160L;

    public AlgorithmException() {
    }

    public AlgorithmException(String message) {
        super(message);
    }

    public AlgorithmException(String message, Throwable cause) {
        super(message, cause);
    }
}
