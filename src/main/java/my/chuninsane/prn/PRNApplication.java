package my.chuninsane.prn;

import my.chuninsane.prn.util.LoggerHolder;
import my.chuninsane.prn.util.StringUtil;

import java.io.File;

/**
 * PRN Application
 *
 * @author chuninsane
 */
public class PRNApplication {

    public static void main(String[] args) {
        PRN prn = new PRN();

        // default current directory
        String logPath = System.getProperty("user.dir");
        if (args != null && args.length > 0 && StringUtil.isNotBlank(args[0])) {
            File path = new File(args[0]);
            if (!path.exists()) {
                LoggerHolder.DEFAULT.info("create log path, logPath={} result={}.", args[0], path.mkdirs());
            }
            logPath = args[0];
        }

        System.setProperty("log.path", logPath);
        prn.start();
    }
}
