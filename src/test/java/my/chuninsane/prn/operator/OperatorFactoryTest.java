package my.chuninsane.prn.operator;

import my.chuninsane.prn.operator.impl.AddOperator;
import my.chuninsane.prn.operator.impl.ClearOperator;
import my.chuninsane.prn.operator.impl.MultiplyOperator;
import my.chuninsane.prn.operator.impl.UndoOperator;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author chuninsane
 */
public class OperatorFactoryTest {

    @Test
    public void testGetOperator() {
        Operator operator = OperatorFactory.getOperator("+");
        Assert.assertNotNull(operator);
        Assert.assertTrue(operator instanceof AddOperator);

        operator = OperatorFactory.getOperator("*");
        Assert.assertNotNull(operator);
        Assert.assertTrue(operator instanceof MultiplyOperator);

        operator = OperatorFactory.getOperator("clear");
        Assert.assertNotNull(operator);
        Assert.assertTrue(operator instanceof ClearOperator);

        operator = OperatorFactory.getOperator("undo");
        Assert.assertNotNull(operator);
        Assert.assertTrue(operator instanceof UndoOperator);

        operator = OperatorFactory.getOperator("UnDo");
        Assert.assertNotNull(operator);
        Assert.assertTrue(operator instanceof UndoOperator);
    }
}