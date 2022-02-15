package cn.tongdun.owl;

import cn.tongdun.owl.context.OwlDSLContext;
import cn.tongdun.owl.executor.OwlDSLExecutor;
import cn.tongdun.owl.type.OwlIntVariable;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author liutianlu
 * <br/>Created 2022/2/15 7:08 PM
 */
@SuppressWarnings("FieldCanBeLocal")
public class ExecutorTest {
    private static OwlDSLContext owlDSLContext;

    private static OwlDSLExecutor owlDSLExecutor;

    private static FileInputStream testFile;

    private static final String TEST_FILE = "/Users/liutianlu/Projects/JavaProjects/owl/owl-ast/src/test/java/cn/tongdun/owl/example/ifelse.txt";

    @BeforeAll
    static void init() throws FileNotFoundException {
        owlDSLContext = new OwlDSLContext();
        OwlIntVariable globalVar = new OwlIntVariable("@simpleSetMetric");
        globalVar.setValue(11911L);
        owlDSLContext.addVariable(globalVar, true);
        owlDSLExecutor = new OwlDSLExecutor(owlDSLContext);
        testFile = new FileInputStream(new File(TEST_FILE));
    }

    @Test
    public void testCompile() {
        ParseTree parseTree = (ParseTree) owlDSLExecutor.compile(testFile);
        Assertions.assertNotNull(parseTree);
        System.out.println(parseTree.toStringTree());
    }

    @Test
    public void testExecution() {
        Object result = owlDSLExecutor.execute(testFile);
        Assertions.assertNotNull(result);
        System.out.println(owlDSLContext.getVariableMap());
        System.out.println(owlDSLContext.listAllGlobalVariables());
        System.out.println(owlDSLContext.listAllSemanticErrors());
        System.out.println(result);
    }
}
