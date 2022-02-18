package cn.tongdun.owl.executor;

import cn.tongdun.owl.error.OwlError;
import cn.tongdun.owl.type.OwlVariable;

import java.io.Serializable;
import java.util.List;

/**
 * Holds result and error info.
 *
 * @author liutianlu
 * <br/>Created 2022/2/16 4:06 PM
 */
public class OwlDSLExecutionResult extends OwlExecutionResult implements Serializable {
    private static final long serialVersionUID = 1090921374339501695L;

    /**
     * Execution of a DSL unit return a variable
     */
    private OwlVariable result;

    public void setResult(OwlVariable result) {
        this.result = result;
    }

    public Object getResult() {
        return result.getInner().getValue();
    }

    public OwlVariable getOriginalResult() {
        return result;
    }

    @Override
    public String toString() {
        return "OwlDSLExecutionResult{" +
                "result=" + result +
                ", success=" + success +
                ", errorList=" + errorList +
                '}';
    }
}
