package my.chuninsane.prn.operator;

import my.chuninsane.prn.PRNBigDecimal;
import my.chuninsane.prn.exception.NotSupportCommandException;
import my.chuninsane.prn.operator.impl.PushOperator;
import my.chuninsane.prn.util.LoggerHolder;
import my.chuninsane.prn.util.ServiceLoader;

import java.util.regex.Pattern;

/**
 * Operator factory
 *
 * @author chuninsane
 */
public final class OperatorFactory {

    private static ServiceLoader<Operator> serviceLoader;

    public static Operator getOperator(final String operatorKey) {
        if (Pattern.matches("^[\\+\\-]?[\\d\\.]+$", operatorKey)) {
            return new PushOperator(new PRNBigDecimal(operatorKey));
        }

        Operator operator;
        Class<Operator> clz = loadServiceLoader().findClass(operatorKey);
        if (clz != null) {
            try {
                operator = clz.newInstance();
                if (operator != null) {
                    return operator;
                }
            } catch (Exception e) {
                LoggerHolder.DEFAULT.error("Failed to create {} operator.",  operatorKey);
            }
        }
        throw new NotSupportCommandException("Not support the " + operatorKey + " operator.");
    }

    private static synchronized ServiceLoader<Operator> loadServiceLoader() {
        if (serviceLoader == null) {
            serviceLoader = ServiceLoader.load(Operator.class);
        }
        return serviceLoader;
    }

    private OperatorFactory() {}

}
