package my.chuninsane.prn.operator.impl;

import my.chuninsane.prn.PRN;
import my.chuninsane.prn.annotation.SPI;
import my.chuninsane.prn.operator.CancelledOperator;
import my.chuninsane.prn.operator.Operator;
import my.chuninsane.prn.util.LoggerHolder;

/**
 * Undo operator
 *
 * @author chuninsane
 */
@SPI(name = "undo")
public class UndoOperator implements Operator {

    @Override
    public void operate(PRN prn) {
        CancelledOperator operator = prn.getUndoStack().pop();
        LoggerHolder.DEFAULT.info("Execute UndoOperator.");
        operator.undo(prn);
    }
}
