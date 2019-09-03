package my.chuninsane.prn.io;

import java.io.Closeable;

/**
 * @author chuninsane
 */
public interface Input extends Closeable {

    boolean hasNextLine();

    String nextLine();
}
