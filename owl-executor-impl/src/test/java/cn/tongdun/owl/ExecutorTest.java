package cn.tongdun.owl;

import cn.tongdun.owl.context.OwlDSLContext;
import cn.tongdun.owl.executor.OwlDSLExecutionResult;
import cn.tongdun.owl.executor.OwlDSLExecutor;
import cn.tongdun.owl.type.OwlIntVariable;
import cn.tongdun.owl.type.OwlVariable;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author liutianlu
 * <br/>Created 2022/2/15 7:08 PM
 */
@SuppressWarnings("FieldCanBeLocal")
public class ExecutorTest {
    private static OwlDSLContext owlDSLContext;

    private static OwlDSLExecutor owlDSLExecutor;

    private static final String TEST_FILE = "src/test/java/cn/tongdun/owl/example/ifelse.txt";
    private static final String TEST_FILE_FUNC = "src/test/java/cn/tongdun/owl/example/func.txt";

    @BeforeAll
    static void init() throws IOException {
        owlDSLContext = new OwlDSLContext();
        OwlIntVariable globalVar = new OwlIntVariable("@simpleSetMetric");
        globalVar.setValue(-11911L);
        owlDSLContext.addVariable(globalVar, true);
        owlDSLExecutor = new OwlDSLExecutor(owlDSLContext);
    }

    @Test
    public void testCompile() throws IOException {
        ParseTree parseTree = (ParseTree) owlDSLExecutor.compile(new FileInputStream(new File(TEST_FILE).getCanonicalPath()));
        Assertions.assertNotNull(parseTree);
        System.out.println(parseTree.toStringTree());
    }

    @Test
    public void testExecution() throws IOException {
        OwlDSLExecutionResult result = (OwlDSLExecutionResult) owlDSLExecutor.execute(new FileInputStream(new File(TEST_FILE).getCanonicalPath()));
        Assertions.assertTrue(result.isSuccess());
        System.out.println(result.getResult());

        result = (OwlDSLExecutionResult) owlDSLExecutor.execute(new FileInputStream(new File(TEST_FILE_FUNC).getCanonicalPath()));
        Assertions.assertFalse(result.isSuccess());
        System.out.println(result.getErrorList());
    }
}
