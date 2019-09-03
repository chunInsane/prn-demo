package my.chuninsane.prn.operator.impl;

import my.chuninsane.prn.PRN;
import my.chuninsane.prn.PRNBigDecimal;
import my.chuninsane.prn.operator.CancelledOperator;
import my.chuninsane.prn.util.LoggerHolder;

/**
 * Push operator
 *
 * @author chuninsane
 */
public class PushOperator extends CancelledOperator {

    private PRNBigDecimal opElement;

    public PushOperator(PRNBigDecimal opElement) {
        this.opElement = opElement;
    }

    @Override
    public void operate(PRN prn) {
        prn.getDataStack().push(opElement);
        LoggerHolder.DEFAULT.info("Execute PushOperator, opElement={}.", opElement);

        // undo operators : pop
        this.undoOperator = new PopOperator();
    }
}
