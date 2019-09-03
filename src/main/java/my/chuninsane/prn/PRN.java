package my.chuninsane.prn;

import my.chuninsane.prn.io.Input;
import my.chuninsane.prn.io.Output;
import my.chuninsane.prn.operator.CancelledOperator;
import my.chuninsane.prn.operator.Operator;
import my.chuninsane.prn.operator.OperatorFactory;
import my.chuninsane.prn.util.LoggerHolder;
import my.chuninsane.prn.util.ServiceLoader;

import java.util.*;

/**
 * @author chuninsane
 */
public class PRN {

    private Stack<PRNBigDecimal> dataStack;

    private Stack<CancelledOperator> undoStack;

    private Input input;

    private Output output;

    public PRN() {
        this(ServiceLoader.load(Input.class).newDefault(),
                ServiceLoader.load(Output.class).newDefault());
    }

    PRN(Input input, Output output) {
        this.dataStack = new Stack<>();
        this.undoStack = new Stack<>();

        this.input = input;
        this.output = output;
    }

    public void start() {
        while (input.hasNextLine()) {
            String line = input.nextLine();
            execute(line);
        }
    }

    void execute(final String line) {
        Iterator<OperatorKey> iterator = new Itr(line);
        OperatorKey operatorKey = null;
        try {
            Operator operator = null;
            while (iterator.hasNext()) {
                operatorKey = iterator.next();
                operator = OperatorFactory.getOperator(operatorKey.getKey());
                operator.operate(this);

                // success
                if (operator instanceof CancelledOperator) {
                    undoStack.push((CancelledOperator) operator);
                }
            }
        } catch (Exception e) {
            LoggerHolder.DEFAULT.error("Catch exception", e);
            if (operatorKey == null) {
                output.error(String.format("illegal input: %s", line));
            } else {
                output.error(String.format("operator %s (position: %s): %s",
                        operatorKey.getKey(), operatorKey.getPos() + 1, e.getMessage()));
            }
        } finally {
            stack();
        }

        if (operatorKey != null && iterator.hasNext()) {
            output.error(String.format("(%s) operators not executed due to the previous error",
                    line.substring(operatorKey.getEndPos())));
        }
    }

    /**
     * execute stack operate
     */
    private void stack() {
        Operator operator = OperatorFactory.getOperator("stack");
        operator.operate(this);
    }

    private static class Itr implements Iterator<OperatorKey> {

        private int index = 0;

        private String content;

        private List<Integer> startOffsets = new ArrayList<>();

        private List<Integer> endOffsets = new ArrayList<>();

        public Itr(String content) {
            this.content = content;
            int offset = 0;
            while (offset < content.length()) {
                if (Character.isSpaceChar(content.charAt(offset))) {
                    offset++;
                    continue;
                }
                int startOffset = offset;
                while (offset < content.length() && !Character.isSpaceChar(content.charAt(offset))) {
                    offset++;
                }
                int endOffset = offset;
                startOffsets.add(startOffset);
                endOffsets.add(endOffset);
            }
        }

        @Override
        public boolean hasNext() {
            return index < startOffsets.size();
        }

        @Override
        public OperatorKey next() {
            if (index >= startOffsets.size()) {
                throw new NoSuchElementException();
            }
            int startOffset = startOffsets.get(index);
            int endOffset = endOffsets.get(index);
            String result = content.substring(startOffset, endOffset);
            index++;
            return new OperatorKey(result, startOffset, endOffset);
        }
    }

    public Stack<PRNBigDecimal> getDataStack() {
        return dataStack;
    }

    public Stack<CancelledOperator> getUndoStack() {
        return undoStack;
    }

    public Output getOutput() {
        return output;
    }
}
