package my.chuninsane.prn.util;

/**
 * @author chuninsane
 */
public final class StringUtil {

    public static boolean isBlank(CharSequence sequence) {
        return sequence == null || sequence.length() <= 0;
    }

    public static boolean isNotBlank(CharSequence sequence) {
        return !isBlank(sequence);
    }

    public static boolean hasText(CharSequence str) {
        if (isBlank(str)) {
            return false;
        }
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private StringUtil() {}

}
