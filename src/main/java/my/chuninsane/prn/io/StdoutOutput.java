package my.chuninsane.prn.io;

import my.chuninsane.prn.annotation.SPI;

/**
 * @author chuninsane
 */
@SPI(name = "stdout", isDefault = true)
public class StdoutOutput implements Output {

    @Override
    public void output(String out) {
        System.out.println(out);
    }

    @Override
    public void error(String errorMsg) {
        System.out.println(errorMsg);
    }
}
