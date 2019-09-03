package my.chuninsane.prn.operator.impl;

import my.chuninsane.prn.PRNBigDecimal;
import my.chuninsane.prn.annotation.SPI;
import my.chuninsane.prn.exception.AlgorithmException;
import my.chuninsane.prn.operator.BiFunctionOperator;

/**
 * Divide operator
 *
 * @author chuninsane
 */
@SPI(name = "/")
public class DivideOperator extends BiFunctionOperator {

    @Override
    public PRNBigDecimal apply(PRNBigDecimal leftOpElement, PRNBigDecimal rightOpElement) {
        if (rightOpElement.equals(new PRNBigDecimal("0"))) {
            throw new AlgorithmException("/ by zero");
        }
        return leftOpElement.divide(rightOpElement);
    }
}
