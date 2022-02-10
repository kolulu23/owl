package cn.tongdun.owl.parse;

import cn.tongdun.owl.error.OwlSyntaxError;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 2:53 PM
 */
public class OwlSyntaxErrorListener extends BaseErrorListener {

    private List<OwlSyntaxError> syntaxErrorList = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException e) {
        OwlSyntaxError syntaxError = new OwlSyntaxError(line, charPositionInLine, msg);
        this.syntaxErrorList.add(syntaxError);
    }

    public List<OwlSyntaxError> getSyntaxErrorList() {
        return syntaxErrorList;
    }

    public void setSyntaxErrorList(List<OwlSyntaxError> syntaxErrorList) {
        this.syntaxErrorList = syntaxErrorList;
    }
}
