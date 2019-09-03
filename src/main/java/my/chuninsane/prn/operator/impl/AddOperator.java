package my.chuninsane.prn.operator.impl;

import my.chuninsane.prn.PRNBigDecimal;
import my.chuninsane.prn.annotation.SPI;
import my.chuninsane.prn.operator.BiFunctionOperator;
import my.chuninsane.prn.util.LoggerHolder;

/**
 * Add operator
 *
 * @author chuninsane
 */
@SPI(name = "+")
public class AddOperator extends BiFunctionOperator {

    @Override
    public PRNBigDecimal apply(PRNBigDecimal leftOpElement, PRNBigDecimal rightOpElement) {
        return leftOpElement.add(rightOpElement);
    }
}
