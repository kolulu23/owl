package cn.tongdun.owl.parse;

import cn.tongdun.owl.error.OwlSemanticError;
import cn.tongdun.owl.type.OwlType;
import cn.tongdun.owl.type.OwlVariable;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 7:08 PM
 */
public class OwlSemanticErrorFactory {
    /**
     * Construct a semantic error from given context
     *
     * @param context parse context of any rule
     * @return a semantic error object without message
     */
    public static OwlSemanticError semanticErrorOf(ParserRuleContext context) {
        OwlSemanticError semanticError = new OwlSemanticError();
        semanticError.setCodeSegment(context.getText());
        semanticError.setLine(context.getStart().getLine());
        return semanticError;
    }
}
