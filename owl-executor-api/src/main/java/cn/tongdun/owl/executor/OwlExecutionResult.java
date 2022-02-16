package cn.tongdun.owl.executor;

import cn.tongdun.owl.error.OwlError;

import java.util.List;

/**
 * Execution result abstract class.
 * Make sure you are able to convert this result to a domain specific one.
 *
 * @author liutianlu
 * <br/>Created 2022/2/16 4:37 PM
 */
public abstract class OwlExecutionResult {
    /**
     * If execution is successful
     */
    protected boolean success;

    /**
     * If execution failed, there's might be syntax errors or semantic errors in your DSL unit.
     */
    protected List<? extends OwlError> errorList;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<? extends OwlError> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<? extends OwlError> errorList) {
        this.errorList = errorList;
    }
}
