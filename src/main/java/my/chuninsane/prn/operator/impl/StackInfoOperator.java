package my.chuninsane.prn.operator.impl;

import my.chuninsane.prn.PRN;
import my.chuninsane.prn.PRNBigDecimal;
import my.chuninsane.prn.annotation.SPI;
import my.chuninsane.prn.operator.AbstractOperator;

import java.util.Iterator;
import java.util.StringJoiner;

/**
 * Stack operator
 *
 * @author chuninsane
 */
@SPI(name = "stack")
public class StackInfoOperator extends AbstractOperator {

    @Override
    public void operate(PRN prn) {
        Iterator<PRNBigDecimal> itr = prn.getDataStack().iterator();
        StringJoiner joiner = new StringJoiner(" ", "stack：", "");
        while (itr.hasNext()) {
            joiner.add(itr.next().toString());
        }
        prn.getOutput().output(joiner.toString());
    }
}
