package cn.tongdun.owl.executor;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
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

    default OwlExecutionResult executeFromString(String unitName, String utf8String) {
        InputStream stream = new BufferedInputStream(new ByteArrayInputStream(utf8String.getBytes(StandardCharsets.UTF_8)));
        OwlExecutionUnit unit = new OwlExecutionUnit();
        unit.setName(unitName);
        unit.setSource(stream);
        return execute(unit);
    }

    Object compile(OwlExecutionUnit executionUnit, Charset charset);

    default Object compile(OwlExecutionUnit executionUnit) {
        return compile(executionUnit, StandardCharsets.UTF_8);
    }

    default Object compileFromString(String unitName, String utf8String) {
        InputStream stream = new BufferedInputStream(new ByteArrayInputStream(utf8String.getBytes(StandardCharsets.UTF_8)));
        OwlExecutionUnit unit = new OwlExecutionUnit();
        unit.setName(unitName);
        unit.setSource(stream);
        return compile(unit);
    }

    /**
     * If you need reset state after execution, implement this method.
     */
    default void resetState() {
    }
}
