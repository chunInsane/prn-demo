package my.chuninsane.prn.operator;

import my.chuninsane.prn.PRN;
import my.chuninsane.prn.PRNBigDecimal;
import my.chuninsane.prn.operator.impl.PopOperator;
import my.chuninsane.prn.operator.impl.PushOperator;
import my.chuninsane.prn.util.LoggerHolder;
import org.junit.Assert;
import org.junit.Test;

/**
 * Pop operator
 *
 * @author chuninsane
 */
public class PopOperatorTest {

    @Test
    public void testOperate() {
        PRN prn = new PRN();
        prn.getDataStack().push(new PRNBigDecimal("1"));
        Assert.assertFalse(prn.getDataStack().isEmpty());
        Operator operator = new PopOperator();
        operator.operate(prn);
        Assert.assertTrue(prn.getDataStack().isEmpty());
    }

    @Test
    public void testUndo() {
        PRN prn = new PRN();
        prn.getDataStack().push(new PRNBigDecimal("1"));
        CancelledOperator operator = new PopOperator();
        operator.operate(prn);
        Assert.assertTrue(prn.getDataStack().isEmpty());

        operator.undo(prn);
        Assert.assertFalse(prn.getDataStack().isEmpty());
    }
}
