package my.chuninsane.prn.operator;

import my.chuninsane.prn.PRN;
import my.chuninsane.prn.PRNBigDecimal;
import my.chuninsane.prn.operator.impl.ClearOperator;
import my.chuninsane.prn.operator.impl.PushOperator;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author chuninsane
 */
public class ClearOperatorTest {

    @Test
    public void testOperate() {
        PRN prn = new PRN();
        new PushOperator(new PRNBigDecimal("1")).operate(prn);
        new PushOperator(new PRNBigDecimal("2")).operate(prn);
        new PushOperator(new PRNBigDecimal("3")).operate(prn);
        Assert.assertEquals(3, prn.getDataStack().size());

        Operator operator = new ClearOperator();
        operator.operate(prn);
        Assert.assertTrue(prn.getDataStack().isEmpty());
    }

    @Test
    public void testUndo() {
        PRN prn = new PRN();
        new PushOperator(new PRNBigDecimal("1")).operate(prn);
        new PushOperator(new PRNBigDecimal("2")).operate(prn);
        new PushOperator(new PRNBigDecimal("3")).operate(prn);
        CancelledOperator operator = new ClearOperator();
        operator.operate(prn);
        Assert.assertTrue(prn.getDataStack().isEmpty());
        operator.undo(prn);
        Assert.assertEquals(3, prn.getDataStack().size());
    }
}
