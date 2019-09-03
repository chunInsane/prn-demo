package my.chuninsane.prn;

/**
 * @author chuninsane
 */
public class OperatorKey {

    private String key;

    private int pos;

    private int endPos;

    public OperatorKey(String key, int pos, int endPos) {
        this.key = key;
        this.pos = pos;
        this.endPos = endPos;
    }

    public String getKey() {
        return key;
    }

    public int getPos() {
        return pos;
    }

    public int getEndPos() {
        return endPos;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OperatorKey{");
        sb.append("key='").append(key).append('\'');
        sb.append(", pos=").append(pos);
        sb.append(", endPos=").append(endPos);
        sb.append('}');
        return sb.toString();
    }
}
