package my.chuninsane.prn.operator.impl;

import my.chuninsane.prn.PRN;
import my.chuninsane.prn.operator.Operator;

import java.util.Arrays;
import java.util.Collection;

/**
 * Batch operator
 *
 * @author chuninsane
 */
public class BatchOperator implements Operator {

    private Collection<Operator> operators;

    public BatchOperator(Collection<Operator> operators) {
        this.operators = operators;
    }

    public BatchOperator(Operator... operators) {
        this.operators = Arrays.asList(operators);
    }

    @Override
    public void operate(PRN prn) {
        for (Operator operator : operators) {
            operator.operate(prn);
        }
    }
}
