package cn.tongdun.owl.executor;

import java.io.Serializable;

/**
 * Groovy脚本的执行结果
 *
 * @author ao.li
 * @date 2022/2/21 10:32 上午
 */
public class OwlGroovyExecutionResult extends OwlExecutionResult implements Serializable {
    private static final long serialVersionUID = 6430430283873945032L;

    private Object result;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "OwlGroovyExecutionResult{" +
                "success=" + success +
                ", errorList=" + errorList +
                ", result=" + result +
                '}';
    }
}
