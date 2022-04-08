package cn.tongdun.owl;

import cn.tongdun.owl.generated.OwlLexer;
import cn.tongdun.owl.generated.OwlParser;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.io.IOException;

/**
 * @author liutianlu
 * <br/>Created 2022/2/11 10:01 AM
 */
public class OwlTestUtil {
    public static OwlParser getParserFromString(String input) {
        OwlLexer lexer = new OwlLexer(CharStreams.fromString(input));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        return new OwlParser(tokenStream);
    }

    public static OwlParser getParserFromString(String input, ANTLRErrorListener lexerSyntaxErrorListener){
        OwlLexer lexer = new OwlLexer(CharStreams.fromString(input));
        lexer.removeErrorListeners();
        lexer.addErrorListener(lexerSyntaxErrorListener);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        return new OwlParser(tokenStream);
    }

    public static OwlParser getParserFromFile(String path){
        OwlLexer lexer = null;
        try {
            lexer = new OwlLexer(CharStreams.fromFileName(new File(path).getCanonicalPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert lexer != null;
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        return new OwlParser(tokenStream);
    }
}
