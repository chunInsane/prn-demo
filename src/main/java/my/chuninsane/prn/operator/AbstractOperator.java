package my.chuninsane.prn.operator;

import my.chuninsane.prn.PRN;
import my.chuninsane.prn.PRNBigDecimal;
import my.chuninsane.prn.exception.InsufficientParameterException;

import java.util.EmptyStackException;

/**
 * @author chuninsane
 */
public abstract class AbstractOperator implements Operator {

    protected PRNBigDecimal[] safePop(PRN prn, int n) {
        PRNBigDecimal[] result = new PRNBigDecimal[n];
        int cnt = n;
        while (cnt > 0) {
            try {
                PRNBigDecimal item = pop(prn);
                result[--cnt] = item;
            } catch (Exception e) {
                while (cnt < n) {
                    prn.getDataStack().push(result[cnt++]);
                }
                throw e;
            }
        }
        return result;
    }

    private PRNBigDecimal pop(PRN prn) {
        PRNBigDecimal result;
        try {
            result = prn.getDataStack().pop();
        } catch (EmptyStackException e) {
            throw new InsufficientParameterException("insucient parameters");
        }
        return result;
    }

    protected void push(PRN prn, PRNBigDecimal... opElements) {
        if (opElements == null) {
            return;
        }

        for (PRNBigDecimal opElement : opElements) {
            prn.getDataStack().push(opElement);
        }
    }
}
