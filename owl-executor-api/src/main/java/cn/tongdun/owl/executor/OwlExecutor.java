package cn.tongdun.owl.executor;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 6:37 PM
 */
public interface OwlExecutor {
    Object execute(InputStream inputStream, Charset charset);

    default Object execute(InputStream inputStream) {
        return execute(inputStream, StandardCharsets.UTF_8);
    }

    Object compile(InputStream inputStream, Charset charset);

    default Object compile(InputStream inputStream) {
        return compile(inputStream, StandardCharsets.UTF_8);
    }
}
