package my.chuninsane.prn.operator;

import my.chuninsane.prn.PRN;
import my.chuninsane.prn.PRNBigDecimal;
import my.chuninsane.prn.operator.impl.StackInfoOperator;
import org.junit.Test;

import java.util.Iterator;
import java.util.StringJoiner;

/**
 *
 * @author chuninsane
 */
public class StackInfoOperatorTest {

    @Test
    public void testOperate() {
        PRN prn = new PRN();
        prn.getDataStack().push(new PRNBigDecimal("1"));
        prn.getDataStack().push(new PRNBigDecimal("2"));
        prn.getDataStack().push(new PRNBigDecimal("3"));
        Operator operator = new StackInfoOperator();
        operator.operate(prn);
    }
}
