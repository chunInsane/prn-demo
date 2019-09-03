package my.chuninsane.prn.operator;

import my.chuninsane.prn.PRN;
import my.chuninsane.prn.PRNBigDecimal;
import my.chuninsane.prn.operator.impl.BatchOperator;
import my.chuninsane.prn.operator.impl.PopOperator;
import my.chuninsane.prn.operator.impl.PushOperator;
import my.chuninsane.prn.util.LoggerHolder;

/**
 * Function operator
 *
 * @author chuninsane
 */
public abstract class FunctionOperator extends CancelledOperator {

    public abstract PRNBigDecimal apply(PRNBigDecimal opElement);

    @Override
    public void operate(PRN prn) {
        PRNBigDecimal[] opElements = safePop(prn, 1);
        PRNBigDecimal opElement = opElements[0];
        PRNBigDecimal result;
        try {
            result = apply(opElement);
        } catch (Exception e) {
            push(prn, opElement);
            throw e;
        }

        LoggerHolder.DEFAULT.info("Execute {}, opElement={} result={}.",
                this.getClass().getSimpleName(), opElement, result);
        prn.getDataStack().push(result);

        // undo operators : pop push
        Operator popOperator = new PopOperator();
        Operator pushOperator = new PushOperator(opElement);
        this.undoOperator = new BatchOperator(popOperator, pushOperator);
    }
}
