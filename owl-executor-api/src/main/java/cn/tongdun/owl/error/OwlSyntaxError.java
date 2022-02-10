package cn.tongdun.owl.error;

import java.io.Serializable;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 2:58 PM
 */
public class OwlSyntaxError implements Serializable {
    private static final long serialVersionUID = 6768684563588005635L;
    private int line;
    private int charPosition;
    private String message;

    public OwlSyntaxError() {
    }

    public OwlSyntaxError(int line, int charPosition, String message) {
        this.line = line;
        this.charPosition = charPosition;
        this.message = message;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getCharPosition() {
        return charPosition;
    }

    public void setCharPosition(int charPosition) {
        this.charPosition = charPosition;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
