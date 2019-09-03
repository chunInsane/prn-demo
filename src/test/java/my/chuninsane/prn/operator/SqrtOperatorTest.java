package my.chuninsane.prn.operator;

import my.chuninsane.prn.PRN;
import my.chuninsane.prn.PRNBigDecimal;
import my.chuninsane.prn.operator.impl.SqrtOperator;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author chuninsane
 */
public class SqrtOperatorTest {

    @Test
    public void testOperate() {
        PRN prn = new PRN();
        prn.getDataStack().push(new PRNBigDecimal("4"));
        Operator operator = new SqrtOperator();
        operator.operate(prn);
        PRNBigDecimal result = prn.getDataStack().pop();
        Assert.assertEquals(new PRNBigDecimal("2"), result);
    }

    @Test
    public void testUndo() {
        PRN prn = new PRN();
        prn.getDataStack().push(new PRNBigDecimal("4"));
        CancelledOperator operator = new SqrtOperator();
        operator.operate(prn);
        Assert.assertEquals(1, prn.getDataStack().size());
        operator.undo(prn);
        Assert.assertEquals(new PRNBigDecimal("4"), prn.getDataStack().pop());
    }
}
