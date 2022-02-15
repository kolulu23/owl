package cn.tongdun.owl;

import cn.tongdun.owl.generated.OwlParser;
import cn.tongdun.owl.parse.OwlEvalVisitor;
import cn.tongdun.owl.parse.OwlVariableListener;
import cn.tongdun.owl.type.OwlVariable;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author liutianlu
 * <br/>Created 2022/2/11 9:58 AM
 */
public class EvalTest {

    private static TestOwlContext owlContext;

    @BeforeEach
    void initContext() {
        owlContext = new TestOwlContext();
    }

    public static TestOwlContext getOwlContext() {
        return owlContext;
    }

    public static void setOwlContext(TestOwlContext owlContext) {
        EvalTest.owlContext = owlContext;
    }

    @Test
    public void testBasicArithmeticExpr() {
        OwlEvalVisitor visitor = new OwlEvalVisitor(owlContext);
        visitor.setDivideScale(6);
        OwlVariableListener listener = new OwlVariableListener();
        listener.setOwlContext(owlContext);
        OwlParser parser = OwlTestUtil.getParserFromString(OwlTestResource.FUN_1);
        ParseTree parseTree = parser.prog();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, parseTree);
        OwlVariable variable = visitor.visit(parseTree);
        System.out.println(owlContext.getSemanticErrorList());
        System.out.println(variable.getInner().getValue());
    }

    @Test
    public void testIfElse() {
        OwlEvalVisitor visitor = new OwlEvalVisitor(owlContext);
        OwlVariableListener listener = new OwlVariableListener();
        listener.setOwlContext(owlContext);
        OwlParser parser = OwlTestUtil.getParserFromFile(OwlTestResource.PATH_TO_IFELSE);
        ParseTree parseTree = parser.prog();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, parseTree);
        OwlVariable variable = visitor.visit(parseTree);
        System.out.println(owlContext.getSemanticErrorList());
        System.out.println(variable.getInner().getValue());
    }
}
