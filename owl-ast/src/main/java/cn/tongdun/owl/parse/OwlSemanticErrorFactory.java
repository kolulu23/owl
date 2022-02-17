package cn.tongdun.owl.parse;

import cn.tongdun.owl.error.OwlSemanticError;
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

    /**
     * 将Java的异常栈信息构建成约定的错误类型
     *
     * @param stackTraceElement Java异常栈信息
     * @return 约定的语义错误信息
     * @see StackTraceElement
     */
    public static OwlSemanticError semanticErrorOf(StackTraceElement stackTraceElement) {
        OwlSemanticError semanticError = new OwlSemanticError();
        if (stackTraceElement == null) {
            return semanticError;
        }
        semanticError.setCodeSegment(stackTraceElement.toString());
        semanticError.setLine(stackTraceElement.getLineNumber());
        return semanticError;
    }

    /**
     * This function can not process given args. <br/>
     * In Owl, some functions accept various arguments, those args may or may not have the same type.
     * As a result, args sent by caller that can not suffice the function's declaration will leads to undefined behaviour
     *
     * @param context  parsing context.
     * @param funcName function name
     * @return sem error
     */
    public static OwlSemanticError noOperableArgForFunc(ParserRuleContext context, String funcName) {
        OwlSemanticError semanticError = semanticErrorOf(context);
        semanticError.setMessage(String.format(OwlSemanticErrorEnum.NON_OPERABLE_ARG_FOR_FUNCTION.getErrorMsg(), funcName));
        return semanticError;
    }
}
