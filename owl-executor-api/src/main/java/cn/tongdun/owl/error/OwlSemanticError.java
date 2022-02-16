package cn.tongdun.owl.error;

import java.io.Serializable;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 4:27 PM
 */
public class OwlSemanticError extends OwlError implements Serializable {
    private static final long serialVersionUID = 8525287482480084500L;
    private String codeSegment;

    public OwlSemanticError() {
    }

    public OwlSemanticError(String message) {
        this.message = message;
    }

    public OwlSemanticError(int line, String codeSegment, String message) {
        this.line = line;
        this.codeSegment = codeSegment;
        this.message = message;
    }

    public String getCodeSegment() {
        return codeSegment;
    }

    public void setCodeSegment(String codeSegment) {
        this.codeSegment = codeSegment;
    }

    @Override
    public String toString() {
        return "OwlSemanticError{" +
                "line=" + line +
                ", codeSegment='" + codeSegment + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
