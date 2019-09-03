package my.chuninsane.prn.operator.impl;

import my.chuninsane.prn.PRNBigDecimal;
import my.chuninsane.prn.annotation.SPI;
import my.chuninsane.prn.operator.BiFunctionOperator;

/**
 * Multiply operator
 *
 * @author chuninsane
 */
@SPI(name = "*")
public class MultiplyOperator extends BiFunctionOperator {

    @Override
    public PRNBigDecimal apply(PRNBigDecimal leftOpElement, PRNBigDecimal rightOpElement) {
        return leftOpElement.multiply(rightOpElement);
    }
}
