package my.chuninsane.prn;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * @author chuninsane
 */
public class PRNBigDecimal implements Comparable<PRNBigDecimal>  {

    private final static int SCALE = 15;

    private final static int DISPLAY_SCALE = 10;

    private final static int DEFAULT_ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;

    private BigDecimal bd;

    public PRNBigDecimal(String in) {
        this.bd = new BigDecimal(in).setScale(SCALE, DEFAULT_ROUNDING_MODE);
    }

    public PRNBigDecimal(BigDecimal bd) {
        this.bd = new BigDecimal(bd.toString()).setScale(SCALE, DEFAULT_ROUNDING_MODE);
    }

    public PRNBigDecimal add(PRNBigDecimal augend) {
        BigDecimal result = bd.add(augend.bd);
        return new PRNBigDecimal(result);
    }

    public PRNBigDecimal subtract(PRNBigDecimal subtrahend) {
        BigDecimal result = bd.subtract(subtrahend.bd);
        return new PRNBigDecimal(result);
    }

    public PRNBigDecimal multiply(PRNBigDecimal multiplicand) {
        BigDecimal result = bd.multiply(multiplicand.bd);
        return new PRNBigDecimal(result);
    }

    public PRNBigDecimal divide(PRNBigDecimal divisor) {
        BigDecimal result = bd.divide(divisor.bd, SCALE, DEFAULT_ROUNDING_MODE);
        return new PRNBigDecimal(result);
    }

    public PRNBigDecimal sqrt() {
        // fixme need more precision
        BigDecimal x = new BigDecimal(Math.sqrt(bd.doubleValue()));
        BigDecimal result = x.add(new BigDecimal(bd.subtract(x.multiply(x)).doubleValue() / (x.doubleValue() * 2.0)));
        return new PRNBigDecimal(result);
    }

    @Override
    public int compareTo(PRNBigDecimal other) {
        return bd.compareTo(other.bd);
    }

    @Override
    public String toString() {
        NumberFormat format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(DISPLAY_SCALE);
        format.setRoundingMode(RoundingMode.DOWN);
        return format.format(bd);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PRNBigDecimal that = (PRNBigDecimal) o;
        return bd.equals(that.bd);
    }

    @Override
    public int hashCode() {
        return bd.hashCode();
    }
}
