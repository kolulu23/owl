package cn.tongdun.owl;

import cn.tongdun.owl.context.OwlDSLContext;
import cn.tongdun.owl.executor.OwlDSLExecutionResult;
import cn.tongdun.owl.executor.OwlDSLExecutor;
import cn.tongdun.owl.executor.OwlExecutionUnit;
import cn.tongdun.owl.type.OwlIntVariable;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author liutianlu
 * <br/>Created 2022/2/15 7:08 PM
 */
@SuppressWarnings("FieldCanBeLocal")
class ExecutorTest {
    private static OwlDSLContext owlDSLContext;

    private static OwlDSLExecutor owlDSLExecutor;

    private static final String TEST_FILE = "src/test/java/cn/tongdun/owl/example/ifelse.txt";
    private static final String TEST_FILE_FUNC = "src/test/java/cn/tongdun/owl/example/func.txt";

    // @BeforeAll
    static void init() {
        owlDSLContext = new OwlDSLContext();
        OwlIntVariable globalVar = new OwlIntVariable("@simpleSetMetric");
        globalVar.setValue(-11911L);
        owlDSLContext.addVariable(globalVar, true);
        owlDSLExecutor = new OwlDSLExecutor(owlDSLContext);
    }

    // @Test
    void testCompile() throws IOException {
        OwlExecutionUnit unit = new OwlExecutionUnit();
        unit.setName("Test Compile");
        unit.setSource(new FileInputStream(new File(TEST_FILE).getCanonicalPath()));
        ParseTree parseTree = (ParseTree) owlDSLExecutor.compile(unit);
        Assertions.assertNotNull(parseTree);
        System.out.println(parseTree.toStringTree());
    }

    // @Test
    void testExecution() throws IOException {
        OwlExecutionUnit unit = new OwlExecutionUnit();
        unit.setName("Test Exec IF-ELSE");
        unit.setSource(new FileInputStream(new File(TEST_FILE).getCanonicalPath()));
        OwlDSLExecutionResult result = (OwlDSLExecutionResult) owlDSLExecutor.execute(unit);
        System.out.println(result.getErrorList());
        System.out.println(result.getResult());

        OwlExecutionUnit funcUnit = new OwlExecutionUnit();
        funcUnit.setName("Test FUNC");
        funcUnit.setSource(new FileInputStream(new File(TEST_FILE_FUNC).getCanonicalPath()));
        result = (OwlDSLExecutionResult) owlDSLExecutor.execute(funcUnit);
        System.out.println(result.getErrorList());
        System.out.println(result.getResult());
    }

    // @Test
    void testExecutionWithCache() throws IOException {
        OwlExecutionUnit unit = new OwlExecutionUnit();
        unit.setName("Test Exec With Cache");
        unit.setSource(new FileInputStream(new File(TEST_FILE).getCanonicalPath()));
        OwlDSLExecutionResult result = (OwlDSLExecutionResult) owlDSLExecutor.execute(unit);
        Assertions.assertNotNull(result);
        System.out.println(result.getErrorList());
        System.out.println(result.getResult());

        // Owl context is reset after execution, all global variables are lost
        OwlIntVariable globalVar = new OwlIntVariable("@simpleSetMetric");
        globalVar.setValue(-11911L);
        unit.setSource(new FileInputStream(new File(TEST_FILE).getCanonicalPath()));
        owlDSLContext.addVariable(globalVar, true);
        result = (OwlDSLExecutionResult) owlDSLExecutor.execute(unit);
        Assertions.assertNotNull(result);
        System.out.println(result.getErrorList());
        System.out.println(result.getResult());
    }
}
