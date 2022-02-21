package cn.tongdun.owl;

import cn.tongdun.owl.context.OwlGroovyContext;
import cn.tongdun.owl.example.groovy.GroovyInterface;
import cn.tongdun.owl.executor.OwlExecutionResult;
import cn.tongdun.owl.executor.OwlExecutionUnit;
import cn.tongdun.owl.executor.OwlGroovyExecutionResult;
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

    private static final String TEST_CORRECT_GROOVY_FILE = "src/test/java/cn/tongdun/owl/example/groovy/CorrectGroovyDemo.groovy";

    private static final String TEST_INCORRECT_GROOVY_FILE = "src/test/java/cn/tongdun/owl/example/groovy/IncorrectGroovyDemo.groovy";

    private static final String TEST_CAST_GROOVY_OBJECT_FILE = "src/test/java/cn/tongdun/owl/example/groovy/ImplementsInterfaceGroovy.groovy";

    private static final String EXECUTE_RESULT = "res";

    @Test
    void testCorrectExecute() throws IOException {
        // 构建上下文
        OwlGroovyContext groovyContext = new OwlGroovyContext();
        groovyContext.setInvokedMethodName("run");
        Map<String, Object> inputParamMap = new HashMap<>();
        inputParamMap.put("param1", "A001");
        groovyContext.setInputParam(inputParamMap);

        // 加载执行器
        OwlGroovyExecutor groovyExecutor = new OwlGroovyExecutor(groovyContext);
        OwlExecutionUnit owlExecutionUnit = new OwlExecutionUnit();
        owlExecutionUnit.setName("testCorrectExecute");
        owlExecutionUnit.setSource(new FileInputStream(new File(TEST_CORRECT_GROOVY_FILE).getCanonicalPath()));
        OwlGroovyExecutionResult executionResult = (OwlGroovyExecutionResult) groovyExecutor.execute(owlExecutionUnit);
        Map<String, Object> resMap = (Map<String, Object>) executionResult.getResult();

        assert "2021".equals(String.valueOf(resMap.get(EXECUTE_RESULT)));
    }

    @Test
    void testIncorrectExecute() throws IOException {
        // 构建上下文
        OwlGroovyContext groovyContext = new OwlGroovyContext();
        groovyContext.setInvokedMethodName("run");
        Map<String, Object> inputParamMap = new HashMap<>();
        inputParamMap.put("param1", "A001");
        groovyContext.setInputParam(inputParamMap);

        // 加载执行器
        OwlGroovyExecutor groovyExecutor = new OwlGroovyExecutor(groovyContext);
        OwlExecutionUnit owlExecutionUnit = new OwlExecutionUnit();
        owlExecutionUnit.setName("testCorrectExecute");
        owlExecutionUnit.setSource(new FileInputStream(new File(TEST_INCORRECT_GROOVY_FILE).getCanonicalPath()));
        OwlExecutionResult executionResult = groovyExecutor.execute(owlExecutionUnit);
        System.out.println("语义错误信息：" + executionResult.getErrorList());
    }

    @Test
    void testCastGroovyObject() throws IOException {
        // 构建上下文
        OwlGroovyContext groovyContext = new OwlGroovyContext();
        groovyContext.setInvokedMethodName("run");
        Map<String, String> inputParamMap = new HashMap<>();
        inputParamMap.put("param1", "A001");
        groovyContext.setInputParam(inputParamMap);

        // 加载执行器
        OwlGroovyExecutor groovyExecutor = new OwlGroovyExecutor(groovyContext);
        OwlExecutionUnit owlExecutionUnit = new OwlExecutionUnit();
        owlExecutionUnit.setName("testCorrectExecute");
        owlExecutionUnit.setSource(new FileInputStream(new File(TEST_CAST_GROOVY_OBJECT_FILE).getCanonicalPath()));

        GroovyInterface groovyInterface = (GroovyInterface) groovyExecutor.compile(owlExecutionUnit);
        Map<String, String> resMap = groovyInterface.run(inputParamMap);
        System.out.println("resMap="+resMap);
    }
}
