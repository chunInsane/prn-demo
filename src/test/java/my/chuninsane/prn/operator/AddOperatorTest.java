package my.chuninsane.prn.operator;

import my.chuninsane.prn.PRN;
import my.chuninsane.prn.PRNBigDecimal;
import my.chuninsane.prn.operator.impl.AddOperator;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author chuninsane
 */
public class AddOperatorTest {

    @Test
    public void testOperate() {
        PRN prn = new PRN();
        Operator operator = new AddOperator();
        prn.getDataStack().push(new PRNBigDecimal("1"));
        prn.getDataStack().push(new PRNBigDecimal("-1"));
        operator.operate(prn);
        PRNBigDecimal result = prn.getDataStack().pop();
        Assert.assertNotNull(result);
        Assert.assertEquals(new PRNBigDecimal("0"), result);

        prn.getDataStack().push(new PRNBigDecimal("1.123456789012345"));
        prn.getDataStack().push(new PRNBigDecimal("123456789012345.123456789012345"));
        operator.operate(prn);
        result = prn.getDataStack().pop();
        Assert.assertNotNull(result);
        Assert.assertEquals(new PRNBigDecimal("123456789012346.24691357802469"), result);
    }

    @Test
    public void testUndo() {
        PRN prn = new PRN();
        prn.getDataStack().push(new PRNBigDecimal("1"));
        prn.getDataStack().push(new PRNBigDecimal("-1"));
        CancelledOperator operator = new AddOperator();
        operator.operate(prn);
        Assert.assertEquals(1, prn.getDataStack().size());

        operator.undo(prn);
        Assert.assertEquals(2, prn.getDataStack().size());
    }
}
