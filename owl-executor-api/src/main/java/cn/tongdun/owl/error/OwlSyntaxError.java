package cn.tongdun.owl.error;

import java.io.Serializable;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 2:58 PM
 */
public class OwlSyntaxError extends OwlError implements Serializable {
    private static final long serialVersionUID = 6768684563588005635L;
    private int charPosition;

    public OwlSyntaxError() {
    }

    public OwlSyntaxError(int line, int charPosition, String message) {
        this.line = line;
        this.charPosition = charPosition;
        this.message = message;
    }

    public int getCharPosition() {
        return charPosition;
    }

    public void setCharPosition(int charPosition) {
        this.charPosition = charPosition;
    }

    @Override
    public String toString() {
        return "OwlSyntaxError{" +
                "line=" + line +
                ", charPosition=" + charPosition +
                ", message='" + message + '\'' +
                '}';
    }
}
