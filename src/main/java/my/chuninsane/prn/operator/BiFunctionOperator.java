package my.chuninsane.prn.operator;

import my.chuninsane.prn.PRN;
import my.chuninsane.prn.PRNBigDecimal;
import my.chuninsane.prn.operator.impl.BatchOperator;
import my.chuninsane.prn.operator.impl.PopOperator;
import my.chuninsane.prn.operator.impl.PushOperator;
import my.chuninsane.prn.util.LoggerHolder;

/**
 * BiFunction operator
 *
 * @author chuninsane
 */
public abstract class BiFunctionOperator extends CancelledOperator {

    public abstract PRNBigDecimal apply(PRNBigDecimal leftOpElement, PRNBigDecimal rightOpElement);

    @Override
    public void operate(PRN prn) {
        PRNBigDecimal[] opElements = safePop(prn, 2);
        PRNBigDecimal leftOpElement = opElements[0];
        PRNBigDecimal rightOpElement = opElements[1];
        PRNBigDecimal result;
        try {
            result = apply(leftOpElement, rightOpElement);
        } catch (Exception e) {
            // rollback
            push(prn, leftOpElement);
            push(prn, rightOpElement);
            throw e;
        }

        LoggerHolder.DEFAULT.info("Execute {}, leftOpElement={} rightOpElement={} result={}.",
                this.getClass().getSimpleName(), leftOpElement, rightOpElement, result);
        prn.getDataStack().push(result);

        // undo operators : pop push push
        Operator popOperator = new PopOperator();
        Operator leftPushOperator = new PushOperator(leftOpElement);
        Operator rightPushOperator = new PushOperator(rightOpElement);
        this.undoOperator = new BatchOperator(popOperator, leftPushOperator, rightPushOperator);
    }
}
