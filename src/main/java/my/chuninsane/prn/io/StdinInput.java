package my.chuninsane.prn.io;

import my.chuninsane.prn.annotation.SPI;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author chuninsane
 */
@SPI(name = "stdin", isDefault = true)
public class StdinInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public void close() throws IOException {
        if (scanner != null) {
            scanner.close();
        }
    }
}
