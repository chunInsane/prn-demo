package my.chuninsane.prn.operator.impl;

import my.chuninsane.prn.PRNBigDecimal;
import my.chuninsane.prn.PRN;
import my.chuninsane.prn.operator.CancelledOperator;
import my.chuninsane.prn.util.LoggerHolder;

/**
 * Pop operator
 *
 * @author chuninsane
 */
public class PopOperator extends CancelledOperator {

    @Override
    public void operate(PRN prn) {
        PRNBigDecimal opElement = prn.getDataStack().pop();
        LoggerHolder.DEFAULT.info("Execute PopOperator, opElement={}.", opElement);

        // undo operators : push
        this.undoOperator = new PushOperator(opElement);
    }

}
