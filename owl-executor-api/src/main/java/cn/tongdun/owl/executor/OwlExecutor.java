package cn.tongdun.owl.executor;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 6:37 PM
 */
public interface OwlExecutor {
    OwlExecutionResult execute(OwlExecutionUnit executionUnit, Charset charset);

    default OwlExecutionResult execute(OwlExecutionUnit executionUnit) {
        return execute(executionUnit, StandardCharsets.UTF_8);
    }

    Object compile(OwlExecutionUnit executionUnit, Charset charset);

    default Object compile(OwlExecutionUnit executionUnit) {
        return compile(executionUnit, StandardCharsets.UTF_8);
    }

    /**
     * If you need reset state after execution, implement this method.
     */
    default void resetState() {
    }
}
