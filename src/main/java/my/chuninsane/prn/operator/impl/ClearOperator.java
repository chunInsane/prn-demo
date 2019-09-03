package my.chuninsane.prn.operator.impl;

import my.chuninsane.prn.PRNBigDecimal;
import my.chuninsane.prn.PRN;
import my.chuninsane.prn.annotation.SPI;
import my.chuninsane.prn.operator.CancelledOperator;
import my.chuninsane.prn.operator.Operator;
import my.chuninsane.prn.util.LoggerHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clear operator
 *
 * @author chuninsane
 */
@SPI(name = "clear")
public class ClearOperator extends CancelledOperator {

    @Override
    public void operate(PRN prn) {
        int size = prn.getDataStack().size();
        List<PRNBigDecimal> clearedOpElements = new ArrayList<>(size);
        while (!prn.getDataStack().isEmpty()) {
            clearedOpElements.add(prn.getDataStack().pop());
        }
        Collections.reverse(clearedOpElements);
        LoggerHolder.DEFAULT.info("Execute ClearOperator, {}.", clearedOpElements);

        // undo operators : batch push
        List<Operator> pushOperators = new ArrayList<>(clearedOpElements.size());
        for (PRNBigDecimal opElement : clearedOpElements) {
            pushOperators.add(new PushOperator(opElement));
        }
        this.undoOperator = new BatchOperator(pushOperators);
    }
}
