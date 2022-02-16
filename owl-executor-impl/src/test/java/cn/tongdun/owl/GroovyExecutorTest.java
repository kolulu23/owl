package cn.tongdun.owl;

import cn.tongdun.owl.context.OwlGroovyContext;
import cn.tongdun.owl.executor.OwlGroovyExecutor;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ao.li
 * @date 2022/2/16 7:27 下午
 */
public class GroovyExecutorTest {

    private static final String TEST_CORRECT_GROOVY_FILE = "src/test/java/cn/tongdun/owl/example/CorrectGroovyDemo.groovy";

    private static final String TEST_INCORRECT_GROOVY_FILE = "src/test/java/cn/tongdun/owl/example/IncorrectGroovyDemo.groovy";


    @Test
    void testExecute() throws IOException {
        // 构建上下文
        OwlGroovyContext groovyContext = new OwlGroovyContext();
        groovyContext.setInvokeMethodName("run");
        Map<String, Object> inputParamMap = new HashMap<>();
        inputParamMap.put("param1", "A001");
        groovyContext.setInputParamMap(inputParamMap);

        // 加载执行器
        OwlGroovyExecutor groovyExecutor = new OwlGroovyExecutor(groovyContext);
        Map<String, Object> resMap = (Map<String, Object>) groovyExecutor.execute(new FileInputStream(new File(TEST_INCORRECT_GROOVY_FILE).getCanonicalPath()));
    }
}
