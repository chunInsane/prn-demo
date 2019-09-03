package my.chuninsane.prn.operator;

import my.chuninsane.prn.PRN;
import my.chuninsane.prn.PRNBigDecimal;
import my.chuninsane.prn.exception.AlgorithmException;
import my.chuninsane.prn.operator.impl.DivideOperator;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author chuninsane
 */
public class DivideOperatorTest {

    @Test
    public void testOperate() {
        PRN prn = new PRN();
        Operator operator = new DivideOperator();
        prn.getDataStack().push(new PRNBigDecimal("5"));
        prn.getDataStack().push(new PRNBigDecimal("-2"));
        operator.operate(prn);
        PRNBigDecimal result = prn.getDataStack().pop();
        Assert.assertNotNull(result);
        Assert.assertEquals(new PRNBigDecimal("-2.5"), result);
    }

    @Test(expected = AlgorithmException.class)
    public void testDivideZero() {
        PRN prn = new PRN();
        Operator operator = new DivideOperator();
        prn.getDataStack().push(new PRNBigDecimal("5"));
        prn.getDataStack().push(new PRNBigDecimal("0"));
        operator.operate(prn);
    }

    @Test
    public void testUndo() {
        PRN prn = new PRN();
        prn.getDataStack().push(new PRNBigDecimal("5"));
        prn.getDataStack().push(new PRNBigDecimal("-2"));
        CancelledOperator operator = new DivideOperator();
        operator.operate(prn);
        Assert.assertEquals(1, prn.getDataStack().size());

        operator.undo(prn);
        Assert.assertEquals(2, prn.getDataStack().size());
    }
}
