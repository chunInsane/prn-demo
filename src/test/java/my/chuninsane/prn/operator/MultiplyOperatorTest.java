package my.chuninsane.prn.operator;

import my.chuninsane.prn.PRN;
import my.chuninsane.prn.PRNBigDecimal;
import my.chuninsane.prn.operator.impl.MultiplyOperator;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author chuninsane
 */
public class MultiplyOperatorTest {

    @Test
    public void testOperate() {
        PRN prn = new PRN();
        prn.getDataStack().push(new PRNBigDecimal("9999"));
        prn.getDataStack().push(new PRNBigDecimal("0.11111"));
        Operator operator = new MultiplyOperator();
        operator.operate(prn);
        PRNBigDecimal result = prn.getDataStack().pop();
        Assert.assertEquals(new PRNBigDecimal("1110.98889"), result);
    }

    @Test
    public void testUndo() {
        PRN prn = new PRN();
        prn.getDataStack().push(new PRNBigDecimal("9999"));
        prn.getDataStack().push(new PRNBigDecimal("0.11111"));
        CancelledOperator operator = new MultiplyOperator();
        operator.operate(prn);
        Assert.assertEquals(1, prn.getDataStack().size());
        operator.undo(prn);
        Assert.assertEquals(2, prn.getDataStack().size());
    }
}
