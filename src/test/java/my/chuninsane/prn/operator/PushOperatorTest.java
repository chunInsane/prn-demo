package my.chuninsane.prn.operator;

import my.chuninsane.prn.PRN;
import my.chuninsane.prn.PRNBigDecimal;
import my.chuninsane.prn.operator.impl.PushOperator;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author chuninsane
 */
public class PushOperatorTest {

    @Test
    public void testOperate() {
        PRN prn = new PRN();
        Operator operator = new PushOperator(new PRNBigDecimal("1"));
        operator.operate(prn);
        Assert.assertFalse(prn.getDataStack().isEmpty());
    }

    @Test
    public void testUndo() {
        PRN prn = new PRN();
        CancelledOperator operator = new PushOperator(new PRNBigDecimal("1"));
        operator.operate(prn);
        Assert.assertFalse(prn.getDataStack().isEmpty());
        operator.undo(prn);
        Assert.assertTrue(prn.getDataStack().isEmpty());
    }
}
