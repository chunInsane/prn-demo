package my.chuninsane.prn.operator;

import my.chuninsane.prn.PRN;
import my.chuninsane.prn.PRNBigDecimal;
import my.chuninsane.prn.operator.impl.PushOperator;
import my.chuninsane.prn.operator.impl.UndoOperator;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author chuninsane
 */
public class UndoOperatorTest {

    @Test
    public void testOperate() {
        PRN prn = new PRN();
        CancelledOperator push = new PushOperator(new PRNBigDecimal("1"));
        push.operate(prn);
        Assert.assertFalse(prn.getDataStack().isEmpty());
        prn.getUndoStack().push(push);

        Operator undo = new UndoOperator();
        undo.operate(prn);
        Assert.assertTrue(prn.getDataStack().isEmpty());
    }
}
