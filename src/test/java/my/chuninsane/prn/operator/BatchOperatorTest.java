package my.chuninsane.prn.operator;

import my.chuninsane.prn.PRN;
import my.chuninsane.prn.PRNBigDecimal;
import my.chuninsane.prn.operator.impl.BatchOperator;
import my.chuninsane.prn.operator.impl.PopOperator;
import my.chuninsane.prn.operator.impl.PushOperator;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author chuninsane
 */
public class BatchOperatorTest {

    @Test
    public void testOperate() {
        PRN prn = new PRN();
        Operator operator = new BatchOperator(new PushOperator(new PRNBigDecimal("1")),
                new PushOperator(new PRNBigDecimal("2")), new PushOperator(new PRNBigDecimal("3")));
        operator.operate(prn);
        Assert.assertEquals(3, prn.getDataStack().size());

        prn = new PRN();
        operator = new BatchOperator(new PushOperator(new PRNBigDecimal("1")), new PopOperator());
        operator.operate(prn);
        Assert.assertTrue(prn.getDataStack().isEmpty());
    }
}
