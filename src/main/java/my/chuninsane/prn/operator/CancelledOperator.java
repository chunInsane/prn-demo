package my.chuninsane.prn.operator;

import my.chuninsane.prn.PRN;

/**
 * Cancelled operator
 *
 * @author chuninsane
 */
public abstract class CancelledOperator extends AbstractOperator {

    protected Operator undoOperator;

    public void undo(PRN prn) {
        if (undoOperator == null) {
            throw new IllegalStateException("Current state, can't cancel.");
        }
        undoOperator.operate(prn);
    }
}
