package my.chuninsane.prn.operator.impl;

import my.chuninsane.prn.PRNBigDecimal;
import my.chuninsane.prn.annotation.SPI;
import my.chuninsane.prn.operator.FunctionOperator;
import my.chuninsane.prn.util.LoggerHolder;

/**
 * Sqrt operator
 *
 * @author chuninsane
 */
@SPI(name = "sqrt")
public class SqrtOperator extends FunctionOperator {

    @Override
    public PRNBigDecimal apply(PRNBigDecimal opElement) {
        PRNBigDecimal result = opElement.sqrt();
        return result;
    }
}
