package my.chuninsane.prn;

import my.chuninsane.prn.io.Output;
import my.chuninsane.prn.io.StdinInput;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chuninsane
 */
public class PRNTest {

    @Test
    public void testPush() {
        List<String> outLines = new ArrayList<>();
        List<String> errorLines = new ArrayList<>();
        PRN prn = new PRN(new StdinInput(), buildOutput(outLines, errorLines));
        prn.execute("5 2");
        Assert.assertEquals("stack：5 2", getLastElement(outLines));
    }

    @Test
    public void testSqrt() {
        List<String> outLines = new ArrayList<>();
        List<String> errorLines = new ArrayList<>();
        PRN prn = new PRN(new StdinInput(), buildOutput(outLines, errorLines));
        prn.execute("2 sqrt");
        Assert.assertEquals("stack：1.4142135623", getLastElement(outLines));

        prn.execute("clear 9 sqrt");
        Assert.assertEquals("stack：3", getLastElement(outLines));
    }

    @Test
    public void testClear() {
        List<String> outLines = new ArrayList<>();
        List<String> errorLines = new ArrayList<>();
        PRN prn = new PRN(new StdinInput(), buildOutput(outLines, errorLines));
        prn.execute("5 2 -");
        Assert.assertEquals("stack：3", getLastElement(outLines));

        prn.execute("3 -");
        Assert.assertEquals("stack：0", getLastElement(outLines));

        prn.execute("clear");
        Assert.assertEquals("stack：", getLastElement(outLines));
    }

    @Test
    public void testUndo() {
        List<String> outLines = new ArrayList<>();
        List<String> errorLines = new ArrayList<>();
        PRN prn = new PRN(new StdinInput(), buildOutput(outLines, errorLines));
        prn.execute("5 4 3 2");
        Assert.assertEquals("stack：5 4 3 2", getLastElement(outLines));

        prn.execute("undo undo *");
        Assert.assertEquals("stack：20", getLastElement(outLines));

        prn.execute("5 *");
        Assert.assertEquals("stack：100", getLastElement(outLines));

        prn.execute("undo");
        Assert.assertEquals("stack：20 5", getLastElement(outLines));
    }

    @Test
    public void testDivide() {
        List<String> outLines = new ArrayList<>();
        List<String> errorLines = new ArrayList<>();
        PRN prn = new PRN(new StdinInput(), buildOutput(outLines, errorLines));
        prn.execute("7 12 2 /");
        Assert.assertEquals("stack：7 6", getLastElement(outLines));

        prn.execute("*");
        Assert.assertEquals("stack：42", getLastElement(outLines));

        prn.execute("4 /");
        Assert.assertEquals("stack：10.5", getLastElement(outLines));
    }

    @Test
    public void testMultiply() {
        List<String> outLines = new ArrayList<>();
        List<String> errorLines = new ArrayList<>();
        PRN prn = new PRN(new StdinInput(), buildOutput(outLines, errorLines));
        prn.execute("1 2 3 4 5");
        Assert.assertEquals("stack：1 2 3 4 5", getLastElement(outLines));

        prn.execute("*");
        Assert.assertEquals("stack：1 2 3 20", getLastElement(outLines));

        prn.execute("clear 3 4 -");
        Assert.assertEquals("stack：-1", getLastElement(outLines));
    }


    @Test
    public void testInsucientParameters() {
        List<String> outLines = new ArrayList<>();
        List<String> errorLines = new ArrayList<>();
        PRN prn = new PRN(new StdinInput(), buildOutput(outLines, errorLines));
        prn.execute("1 2 3 * 5 + * * 6 5");
        Assert.assertEquals("stack：11", getLastElement(outLines));
    }

    private String getLastElement(List<String> list) {
        if (list.size() <= 0) {
            return null;
        }
        return list.get(list.size() - 1);
    }


    private Output buildOutput(List<String> outLines, List<String> errorLines) {
        return new Output() {
            @Override
            public void output(String out) {
                System.out.println(out);
                outLines.add(out);
            }

            @Override
            public void error(String errorMsg) {
                System.out.println(errorMsg);
                errorLines.add(errorMsg);
            }
        };
    }
}
