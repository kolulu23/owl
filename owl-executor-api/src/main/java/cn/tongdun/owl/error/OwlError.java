package cn.tongdun.owl.error;

import java.io.Serializable;

/**
 * @author liutianlu
 * <br/>Created 2022/2/16 4:23 PM
 */
public abstract class OwlError implements Serializable {
    private static final long serialVersionUID = -3503277129892342424L;
    protected int line;
    protected String message;

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
