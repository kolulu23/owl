package cn.tongdun.owl.parse;

import cn.tongdun.owl.context.OwlContext;
import cn.tongdun.owl.error.OwlSyntaxError;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 2:53 PM
 */
public class OwlSyntaxErrorListener extends BaseErrorListener {

    private OwlContext owlContext;

    public OwlSyntaxErrorListener(OwlContext owlContext) {
        this.owlContext = owlContext;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException e) {
        OwlSyntaxError syntaxError = new OwlSyntaxError(line, charPositionInLine, msg);
        this.owlContext.addSyntaxError(syntaxError);
    }

    public OwlContext getOwlContext() {
        return owlContext;
    }

    public void setOwlContext(OwlContext owlContext) {
        this.owlContext = owlContext;
    }
}
