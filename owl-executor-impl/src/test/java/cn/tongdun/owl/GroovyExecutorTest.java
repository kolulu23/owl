package cn.tongdun.owl;

import cn.tongdun.owl.context.OwlGroovyContext;
import cn.tongdun.owl.example.groovy.GroovyInterface;
import cn.tongdun.owl.executor.OwlExecutionResult;
import cn.tongdun.owl.executor.OwlExecutionUnit;
import cn.tongdun.owl.executor.OwlGroovyExecutionResult;
import cn.tongdun.owl.executor.OwlGroovyExecutor;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.codehaus.groovy.ast.stmt.Statement;
import org.codehaus.groovy.ast.stmt.WhileStatement;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.customizers.SecureASTCustomizer;
import org.codehaus.groovy.syntax.Types;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ao.li
 * @date 2022/2/16 7:27 下午
 */
public class GroovyExecutorTest {

    private static final String TEST_CORRECT_GROOVY_FILE = "src/test/java/cn/tongdun/owl/example/groovy/CorrectGroovyDemo.groovy";

    private static final String TEST_INCORRECT_GROOVY_FILE = "src/test/java/cn/tongdun/owl/example/groovy/IncorrectGroovyDemo.groovy";

    private static final String TEST_CAST_GROOVY_OBJECT_FILE = "src/test/java/cn/tongdun/owl/example/groovy/ImplementsInterfaceGroovy.groovy";

    private static final String TEST_INCORRECT_GROOVY_FILE_TXT = "src/test/java/cn/tongdun/owl/example/groovy/IncorrectGroovyDemo.txt";

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

    @Test
    void testSecureASTCustomizer() throws IOException, InstantiationException, IllegalAccessException {
        final SecureASTCustomizer secure = new SecureASTCustomizer();// 创建SecureASTCustomizer
        secure.setClosuresAllowed(true);// 禁止使用闭包
        List<Integer> tokensBlacklist = new ArrayList<>();
        tokensBlacklist.add(Types.KEYWORD_WHILE);// 添加关键字黑名单 while和goto
        tokensBlacklist.add(Types.KEYWORD_GOTO);
        secure.setTokensBlacklist(tokensBlacklist);
        secure.setIndirectImportCheckEnabled(true);// 设置直接导入检查
        List<String> list = new ArrayList<>();// 添加导入黑名单，用户不能导入JSONObject
        list.add("com.alibaba.fastjson.JSONObject");
        secure.setImportsBlacklist(list);
        List<Class<? extends Statement>> statementBlacklist = new ArrayList<>();// statement 黑名单，不能使用while循环块
        statementBlacklist.add(WhileStatement.class);
        secure.setStatementsBlacklist(statementBlacklist);
        final CompilerConfiguration config = new CompilerConfiguration();// 自定义CompilerConfiguration，设置AST
        config.addCompilationCustomizers(secure);
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader(this.getClass().getClassLoader(), config);
        Class parseClass = groovyClassLoader.parseClass(new File(TEST_CORRECT_GROOVY_FILE));
        GroovyObject groovyObject = (GroovyObject) parseClass.newInstance();
        Map<String, String> inputParamMap = new HashMap<>();
        inputParamMap.put("param1", "A001");
        Object res = groovyObject.invokeMethod("run", inputParamMap);
        System.out.println(res);
    }


    @Test
    void testCastExternalInterfaceToGroovyObj() throws IOException {
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

        GroovyObject groovyObject = (GroovyObject) groovyInterface;
        Map<String, String> resMap = (Map<String, String>) groovyObject.invokeMethod("run", inputParamMap);
        System.out.println("resMap="+resMap);
    }

    @Test
    void testExecuteFromInstance() throws IOException {
        // 构建上下文
        OwlGroovyContext groovyContext = new OwlGroovyContext();
        groovyContext.setInvokedMethodName("run");
        Map<String, String> inputParamMap = new HashMap<>();
        inputParamMap.put("param1", "A001");
        groovyContext.setInputParam(inputParamMap);

        // 加载执行器
        OwlGroovyExecutor groovyExecutor = new OwlGroovyExecutor(groovyContext);
        OwlExecutionUnit owlExecutionUnit = new OwlExecutionUnit();
        owlExecutionUnit.setName("testExecuteFromInstance");
        owlExecutionUnit.setSource(new FileInputStream(new File(TEST_INCORRECT_GROOVY_FILE).getCanonicalPath()));

        OwlExecutionResult executionResult = groovyExecutor.executeFromInstance(groovyExecutor.compile(owlExecutionUnit));
        System.out.println(executionResult);
    }

    @Test
    void testCompileError() throws IOException {
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
        owlExecutionUnit.setSource(new FileInputStream(new File(TEST_INCORRECT_GROOVY_FILE_TXT).getCanonicalPath()));
        groovyExecutor.compile(owlExecutionUnit);
        System.out.println("语义错误信息：" + groovyContext.listAllSemanticErrors());
    }
}
