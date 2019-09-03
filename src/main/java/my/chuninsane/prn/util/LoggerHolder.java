package my.chuninsane.prn.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logger holder
 *
 * @author chuninsane
 */
public final class LoggerHolder {

    public final static Logger DEFAULT = LoggerFactory.getLogger("default");

    private LoggerHolder() {}
}
