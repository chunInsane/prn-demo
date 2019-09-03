package my.chuninsane.prn.operator;

import my.chuninsane.prn.PRN;
import my.chuninsane.prn.PRNBigDecimal;
import my.chuninsane.prn.operator.impl.SubtractOperator;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author chuninsane
 */
public class SubtractOperatorTest {

    @Test
    public void testOperate() {
        PRN prn = new PRN();
        prn.getDataStack().push(new PRNBigDecimal("1"));
        prn.getDataStack().push(new PRNBigDecimal("1"));
        Operator operator = new SubtractOperator();
        operator.operate(prn);
        PRNBigDecimal result = prn.getDataStack().pop();
        Assert.assertEquals(new PRNBigDecimal("0"), result);
    }

    @Test
    public void testUndo() {
        PRN prn = new PRN();
        prn.getDataStack().push(new PRNBigDecimal("1"));
        prn.getDataStack().push(new PRNBigDecimal("1"));
        CancelledOperator operator = new SubtractOperator();
        operator.operate(prn);
        Assert.assertEquals(1, prn.getDataStack().size());
        operator.undo(prn);
        Assert.assertEquals(2, prn.getDataStack().size());
    }
}
