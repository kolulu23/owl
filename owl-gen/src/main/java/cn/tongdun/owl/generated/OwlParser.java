package cn.tongdun.owl.generated;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OwlParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, ADD = 7, SUB = 8, MUL = 9, DIV = 10,
            LT = 11, GT = 12, EQ = 13, LTEQ = 14, GTEQ = 15, NEQ = 16, AND = 17, OR = 18, FN_ABS = 19,
            FN_AVG = 20, FN_MUL = 21, FN_DIV = 22, FN_CEIL = 23, FN_FLOOR = 24, FN_MAX = 25, FN_MIN = 26,
            FN_RAND = 27, FN_ROUND = 28, FN_SUM = 29, FN_STD = 30, FN_VARIANCE = 31, FN_TRIM = 32,
            FN_CONCAT = 33, FN_LEN = 34, FN_UNION = 35, FN_INTERSECTION = 36, FN_APPEND = 37,
            FN_DEDUP = 38, FN_SORT = 39, FN_SUBSTR = 40, FN_CONTAINS = 41, FN_NOT_CONTAINS = 42,
            FN_NEQ = 43, FN_EQ = 44, FN_NVL = 45, FN_ISNULL = 46, FN_ISNOTNULL = 47, FN_TOSTRING = 48,
            FN_TONUMBER = 49, T_INT = 50, T_DOUBLE = 51, T_BOOLEAN = 52, T_STRING = 53, T_LIST = 54,
            K_GLB_VAR_PREFIX = 55, LP = 56, RP = 57, INT = 58, DOUBLE = 59, STRING = 60, RETURN = 61,
            IF = 62, ELSE = 63, BOOLEAN = 64, ID = 65, SEMI = 66, WS = 67, LINE_COMMENT = 68;
    public static final int
            RULE_prog = 0, RULE_block = 1, RULE_statement = 2, RULE_vardef = 3, RULE_expr = 4,
            RULE_var = 5, RULE_arr = 6, RULE_literal = 7, RULE_glbvar = 8;

    private static String[] makeRuleNames() {
        return new String[]{
                "prog", "block", "statement", "vardef", "expr", "var", "arr", "literal",
                "glbvar"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'{'", "'}'", "'='", "','", "'['", "']'", "'+'", "'-'", "'*'",
                "'/'", "'<'", "'>'", "'=='", "'<='", "'>='", "'!='", "'and'", "'or'",
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, "'int'", "'double'", "'boolean'",
                "'string'", "'list'", "'@'", "'('", "')'", null, null, null, "'return'",
                "'if'", "'else'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, "ADD", "SUB", "MUL", "DIV",
                "LT", "GT", "EQ", "LTEQ", "GTEQ", "NEQ", "AND", "OR", "FN_ABS", "FN_AVG",
                "FN_MUL", "FN_DIV", "FN_CEIL", "FN_FLOOR", "FN_MAX", "FN_MIN", "FN_RAND",
                "FN_ROUND", "FN_SUM", "FN_STD", "FN_VARIANCE", "FN_TRIM", "FN_CONCAT",
                "FN_LEN", "FN_UNION", "FN_INTERSECTION", "FN_APPEND", "FN_DEDUP", "FN_SORT",
                "FN_SUBSTR", "FN_CONTAINS", "FN_NOT_CONTAINS", "FN_NEQ", "FN_EQ", "FN_NVL",
                "FN_ISNULL", "FN_ISNOTNULL", "FN_TOSTRING", "FN_TONUMBER", "T_INT", "T_DOUBLE",
                "T_BOOLEAN", "T_STRING", "T_LIST", "K_GLB_VAR_PREFIX", "LP", "RP", "INT",
                "DOUBLE", "STRING", "RETURN", "IF", "ELSE", "BOOLEAN", "ID", "SEMI",
                "WS", "LINE_COMMENT"
        };
    }

    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "Owl.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public OwlParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class ProgContext extends ParserRuleContext {
        public TerminalNode EOF() {
            return getToken(OwlParser.EOF, 0);
        }

        public List<StatementContext> statement() {
            return getRuleContexts(StatementContext.class);
        }

        public StatementContext statement(int i) {
            return getRuleContext(StatementContext.class, i);
        }

        public ProgContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prog;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterProg(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitProg(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitProg(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ProgContext prog() throws RecognitionException {
        ProgContext _localctx = new ProgContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_prog);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(19);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(18);
                            statement();
                        }
                    }
                    setState(21);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & ((1L << (SUB - 8)) | (1L << (FN_ABS - 8)) | (1L << (FN_AVG - 8)) | (1L << (FN_CEIL - 8)) | (1L << (FN_FLOOR - 8)) | (1L << (FN_MAX - 8)) | (1L << (FN_MIN - 8)) | (1L << (FN_RAND - 8)) | (1L << (FN_ROUND - 8)) | (1L << (FN_SUM - 8)) | (1L << (FN_STD - 8)) | (1L << (FN_VARIANCE - 8)) | (1L << (FN_TRIM - 8)) | (1L << (FN_CONCAT - 8)) | (1L << (FN_LEN - 8)) | (1L << (FN_UNION - 8)) | (1L << (FN_INTERSECTION - 8)) | (1L << (FN_APPEND - 8)) | (1L << (FN_DEDUP - 8)) | (1L << (FN_SORT - 8)) | (1L << (FN_SUBSTR - 8)) | (1L << (FN_CONTAINS - 8)) | (1L << (FN_NOT_CONTAINS - 8)) | (1L << (FN_NEQ - 8)) | (1L << (FN_EQ - 8)) | (1L << (FN_NVL - 8)) | (1L << (FN_ISNULL - 8)) | (1L << (FN_ISNOTNULL - 8)) | (1L << (FN_TOSTRING - 8)) | (1L << (FN_TONUMBER - 8)) | (1L << (T_INT - 8)) | (1L << (T_DOUBLE - 8)) | (1L << (T_BOOLEAN - 8)) | (1L << (T_STRING - 8)) | (1L << (T_LIST - 8)) | (1L << (K_GLB_VAR_PREFIX - 8)) | (1L << (LP - 8)) | (1L << (INT - 8)) | (1L << (DOUBLE - 8)) | (1L << (STRING - 8)) | (1L << (RETURN - 8)) | (1L << (IF - 8)) | (1L << (BOOLEAN - 8)) | (1L << (ID - 8)) | (1L << (SEMI - 8)))) != 0));
                setState(23);
                match(EOF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class BlockContext extends ParserRuleContext {
        public List<StatementContext> statement() {
            return getRuleContexts(StatementContext.class);
        }

        public StatementContext statement(int i) {
            return getRuleContext(StatementContext.class, i);
        }

        public BlockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_block;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterBlock(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitBlock(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitBlock(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BlockContext block() throws RecognitionException {
        BlockContext _localctx = new BlockContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_block);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(25);
                match(T__0);
                setState(29);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & ((1L << (SUB - 8)) | (1L << (FN_ABS - 8)) | (1L << (FN_AVG - 8)) | (1L << (FN_CEIL - 8)) | (1L << (FN_FLOOR - 8)) | (1L << (FN_MAX - 8)) | (1L << (FN_MIN - 8)) | (1L << (FN_RAND - 8)) | (1L << (FN_ROUND - 8)) | (1L << (FN_SUM - 8)) | (1L << (FN_STD - 8)) | (1L << (FN_VARIANCE - 8)) | (1L << (FN_TRIM - 8)) | (1L << (FN_CONCAT - 8)) | (1L << (FN_LEN - 8)) | (1L << (FN_UNION - 8)) | (1L << (FN_INTERSECTION - 8)) | (1L << (FN_APPEND - 8)) | (1L << (FN_DEDUP - 8)) | (1L << (FN_SORT - 8)) | (1L << (FN_SUBSTR - 8)) | (1L << (FN_CONTAINS - 8)) | (1L << (FN_NOT_CONTAINS - 8)) | (1L << (FN_NEQ - 8)) | (1L << (FN_EQ - 8)) | (1L << (FN_NVL - 8)) | (1L << (FN_ISNULL - 8)) | (1L << (FN_ISNOTNULL - 8)) | (1L << (FN_TOSTRING - 8)) | (1L << (FN_TONUMBER - 8)) | (1L << (T_INT - 8)) | (1L << (T_DOUBLE - 8)) | (1L << (T_BOOLEAN - 8)) | (1L << (T_STRING - 8)) | (1L << (T_LIST - 8)) | (1L << (K_GLB_VAR_PREFIX - 8)) | (1L << (LP - 8)) | (1L << (INT - 8)) | (1L << (DOUBLE - 8)) | (1L << (STRING - 8)) | (1L << (RETURN - 8)) | (1L << (IF - 8)) | (1L << (BOOLEAN - 8)) | (1L << (ID - 8)) | (1L << (SEMI - 8)))) != 0)) {
                    {
                        {
                            setState(26);
                            statement();
                        }
                    }
                    setState(31);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(32);
                match(T__1);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StatementContext extends ParserRuleContext {
        public StatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_statement;
        }

        public StatementContext() {
        }

        public void copyFrom(StatementContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class Stat_If_ElseContext extends StatementContext {
        public TerminalNode IF() {
            return getToken(OwlParser.IF, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public List<BlockContext> block() {
            return getRuleContexts(BlockContext.class);
        }

        public BlockContext block(int i) {
            return getRuleContext(BlockContext.class, i);
        }

        public TerminalNode ELSE() {
            return getToken(OwlParser.ELSE, 0);
        }

        public Stat_If_ElseContext(StatementContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterStat_If_Else(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitStat_If_Else(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitStat_If_Else(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Stat_ExprContext extends StatementContext {
        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode SEMI() {
            return getToken(OwlParser.SEMI, 0);
        }

        public Stat_ExprContext(StatementContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterStat_Expr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitStat_Expr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitStat_Expr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Stat_DefContext extends StatementContext {
        public VardefContext vardef() {
            return getRuleContext(VardefContext.class, 0);
        }

        public TerminalNode SEMI() {
            return getToken(OwlParser.SEMI, 0);
        }

        public Stat_DefContext(StatementContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterStat_Def(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitStat_Def(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitStat_Def(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Stat_AssignContext extends StatementContext {
        public TerminalNode ID() {
            return getToken(OwlParser.ID, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode SEMI() {
            return getToken(OwlParser.SEMI, 0);
        }

        public Stat_AssignContext(StatementContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterStat_Assign(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitStat_Assign(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitStat_Assign(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Stat_IfContext extends StatementContext {
        public TerminalNode IF() {
            return getToken(OwlParser.IF, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public BlockContext block() {
            return getRuleContext(BlockContext.class, 0);
        }

        public Stat_IfContext(StatementContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterStat_If(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitStat_If(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitStat_If(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Stat_ReturnContext extends StatementContext {
        public TerminalNode RETURN() {
            return getToken(OwlParser.RETURN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode SEMI() {
            return getToken(OwlParser.SEMI, 0);
        }

        public Stat_ReturnContext(StatementContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterStat_Return(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitStat_Return(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitStat_Return(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Stat_BlankContext extends StatementContext {
        public TerminalNode SEMI() {
            return getToken(OwlParser.SEMI, 0);
        }

        public Stat_BlankContext(StatementContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterStat_Blank(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitStat_Blank(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitStat_Blank(this);
            else return visitor.visitChildren(this);
        }
    }

    public final StatementContext statement() throws RecognitionException {
        StatementContext _localctx = new StatementContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_statement);
        try {
            setState(64);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
                case 1:
                    _localctx = new Stat_ExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(34);
                    expr(0);
                    setState(35);
                    match(SEMI);
                }
                break;
                case 2:
                    _localctx = new Stat_DefContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(37);
                    vardef();
                    setState(38);
                    match(SEMI);
                }
                break;
                case 3:
                    _localctx = new Stat_AssignContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(40);
                    match(ID);
                    setState(41);
                    match(T__2);
                    setState(42);
                    expr(0);
                    setState(43);
                    match(SEMI);
                }
                break;
                case 4:
                    _localctx = new Stat_IfContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(45);
                    match(IF);
                    setState(46);
                    match(LP);
                    setState(47);
                    expr(0);
                    setState(48);
                    match(RP);
                    setState(49);
                    block();
                }
                break;
                case 5:
                    _localctx = new Stat_If_ElseContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(51);
                    match(IF);
                    setState(52);
                    match(LP);
                    setState(53);
                    expr(0);
                    setState(54);
                    match(RP);
                    setState(55);
                    block();
                    setState(56);
                    match(ELSE);
                    setState(57);
                    block();
                }
                break;
                case 6:
                    _localctx = new Stat_ReturnContext(_localctx);
                    enterOuterAlt(_localctx, 6);
                {
                    setState(59);
                    match(RETURN);
                    setState(60);
                    expr(0);
                    setState(61);
                    match(SEMI);
                }
                break;
                case 7:
                    _localctx = new Stat_BlankContext(_localctx);
                    enterOuterAlt(_localctx, 7);
                {
                    setState(63);
                    match(SEMI);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class VardefContext extends ParserRuleContext {
        public VardefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_vardef;
        }

        public VardefContext() {
        }

        public void copyFrom(VardefContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class Def_ListContext extends VardefContext {
        public TerminalNode T_LIST() {
            return getToken(OwlParser.T_LIST, 0);
        }

        public TerminalNode ID() {
            return getToken(OwlParser.ID, 0);
        }

        public ArrContext arr() {
            return getRuleContext(ArrContext.class, 0);
        }

        public Def_ListContext(VardefContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterDef_List(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitDef_List(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitDef_List(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Def_DoubleContext extends VardefContext {
        public TerminalNode T_DOUBLE() {
            return getToken(OwlParser.T_DOUBLE, 0);
        }

        public TerminalNode ID() {
            return getToken(OwlParser.ID, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public Def_DoubleContext(VardefContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterDef_Double(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitDef_Double(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitDef_Double(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Def_IntContext extends VardefContext {
        public TerminalNode T_INT() {
            return getToken(OwlParser.T_INT, 0);
        }

        public TerminalNode ID() {
            return getToken(OwlParser.ID, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public Def_IntContext(VardefContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterDef_Int(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitDef_Int(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitDef_Int(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Def_BooleanContext extends VardefContext {
        public TerminalNode T_BOOLEAN() {
            return getToken(OwlParser.T_BOOLEAN, 0);
        }

        public TerminalNode ID() {
            return getToken(OwlParser.ID, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public Def_BooleanContext(VardefContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterDef_Boolean(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitDef_Boolean(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitDef_Boolean(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Def_StringContext extends VardefContext {
        public TerminalNode T_STRING() {
            return getToken(OwlParser.T_STRING, 0);
        }

        public TerminalNode ID() {
            return getToken(OwlParser.ID, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public Def_StringContext(VardefContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterDef_String(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitDef_String(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitDef_String(this);
            else return visitor.visitChildren(this);
        }
    }

    public final VardefContext vardef() throws RecognitionException {
        VardefContext _localctx = new VardefContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_vardef);
        try {
            setState(86);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_INT:
                    _localctx = new Def_IntContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(66);
                    match(T_INT);
                    setState(67);
                    match(ID);
                    setState(68);
                    match(T__2);
                    setState(69);
                    expr(0);
                }
                break;
                case T_DOUBLE:
                    _localctx = new Def_DoubleContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(70);
                    match(T_DOUBLE);
                    setState(71);
                    match(ID);
                    setState(72);
                    match(T__2);
                    setState(73);
                    expr(0);
                }
                break;
                case T_BOOLEAN:
                    _localctx = new Def_BooleanContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(74);
                    match(T_BOOLEAN);
                    setState(75);
                    match(ID);
                    setState(76);
                    match(T__2);
                    setState(77);
                    expr(0);
                }
                break;
                case T_STRING:
                    _localctx = new Def_StringContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(78);
                    match(T_STRING);
                    setState(79);
                    match(ID);
                    setState(80);
                    match(T__2);
                    setState(81);
                    expr(0);
                }
                break;
                case T_LIST:
                    _localctx = new Def_ListContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(82);
                    match(T_LIST);
                    setState(83);
                    match(ID);
                    setState(84);
                    match(T__2);
                    setState(85);
                    arr();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprContext extends ParserRuleContext {
        public ExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expr;
        }

        public ExprContext() {
        }

        public void copyFrom(ExprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class VarRefContext extends ExprContext {
        public VarContext var() {
            return getRuleContext(VarContext.class, 0);
        }

        public VarRefContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterVarRef(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitVarRef(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitVarRef(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_MaxContext extends ExprContext {
        public TerminalNode FN_MAX() {
            return getToken(OwlParser.FN_MAX, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_MaxContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_Max(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_Max(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_Max(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_NvlContext extends ExprContext {
        public TerminalNode FN_NVL() {
            return getToken(OwlParser.FN_NVL, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_NvlContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_Nvl(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_Nvl(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_Nvl(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_AppendContext extends ExprContext {
        public TerminalNode FN_APPEND() {
            return getToken(OwlParser.FN_APPEND, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_AppendContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_Append(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_Append(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_Append(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_StdContext extends ExprContext {
        public TerminalNode FN_STD() {
            return getToken(OwlParser.FN_STD, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_StdContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_Std(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_Std(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_Std(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class BoolExprContext extends ExprContext {
        public Token op;

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode AND() {
            return getToken(OwlParser.AND, 0);
        }

        public TerminalNode OR() {
            return getToken(OwlParser.OR, 0);
        }

        public BoolExprContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterBoolExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitBoolExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitBoolExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_RoundContext extends ExprContext {
        public TerminalNode FN_ROUND() {
            return getToken(OwlParser.FN_ROUND, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public TerminalNode INT() {
            return getToken(OwlParser.INT, 0);
        }

        public Fn_RoundContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_Round(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_Round(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_Round(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class MulDivContext extends ExprContext {
        public Token op;

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode MUL() {
            return getToken(OwlParser.MUL, 0);
        }

        public TerminalNode DIV() {
            return getToken(OwlParser.DIV, 0);
        }

        public MulDivContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterMulDiv(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitMulDiv(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitMulDiv(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_ToNumberContext extends ExprContext {
        public TerminalNode FN_TONUMBER() {
            return getToken(OwlParser.FN_TONUMBER, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_ToNumberContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_ToNumber(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_ToNumber(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_ToNumber(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_EqContext extends ExprContext {
        public TerminalNode FN_EQ() {
            return getToken(OwlParser.FN_EQ, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_EqContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_Eq(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_Eq(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_Eq(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_VarianceContext extends ExprContext {
        public TerminalNode FN_VARIANCE() {
            return getToken(OwlParser.FN_VARIANCE, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_VarianceContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_Variance(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_Variance(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_Variance(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_AbsContext extends ExprContext {
        public TerminalNode FN_ABS() {
            return getToken(OwlParser.FN_ABS, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_AbsContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_Abs(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_Abs(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_Abs(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_IsNullContext extends ExprContext {
        public TerminalNode FN_ISNULL() {
            return getToken(OwlParser.FN_ISNULL, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_IsNullContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_IsNull(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_IsNull(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_IsNull(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_CeilContext extends ExprContext {
        public TerminalNode FN_CEIL() {
            return getToken(OwlParser.FN_CEIL, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_CeilContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_Ceil(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_Ceil(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_Ceil(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_SubstrContext extends ExprContext {
        public Token start;
        public Token end;

        public TerminalNode FN_SUBSTR() {
            return getToken(OwlParser.FN_SUBSTR, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public List<TerminalNode> INT() {
            return getTokens(OwlParser.INT);
        }

        public TerminalNode INT(int i) {
            return getToken(OwlParser.INT, i);
        }

        public Fn_SubstrContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_Substr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_Substr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_Substr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_IsNotNullContext extends ExprContext {
        public TerminalNode FN_ISNOTNULL() {
            return getToken(OwlParser.FN_ISNOTNULL, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_IsNotNullContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_IsNotNull(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_IsNotNull(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_IsNotNull(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_UnionContext extends ExprContext {
        public TerminalNode FN_UNION() {
            return getToken(OwlParser.FN_UNION, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_UnionContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_Union(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_Union(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_Union(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class AddSubContext extends ExprContext {
        public Token op;

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode ADD() {
            return getToken(OwlParser.ADD, 0);
        }

        public TerminalNode SUB() {
            return getToken(OwlParser.SUB, 0);
        }

        public AddSubContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterAddSub(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitAddSub(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitAddSub(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_ConcatContext extends ExprContext {
        public ExprContext sep;

        public TerminalNode FN_CONCAT() {
            return getToken(OwlParser.FN_CONCAT, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_ConcatContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_Concat(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_Concat(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_Concat(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_NEqContext extends ExprContext {
        public TerminalNode FN_NEQ() {
            return getToken(OwlParser.FN_NEQ, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_NEqContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_NEq(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_NEq(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_NEq(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_DedupContext extends ExprContext {
        public TerminalNode FN_DEDUP() {
            return getToken(OwlParser.FN_DEDUP, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_DedupContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_Dedup(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_Dedup(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_Dedup(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_ToStringContext extends ExprContext {
        public TerminalNode FN_TOSTRING() {
            return getToken(OwlParser.FN_TOSTRING, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_ToStringContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_ToString(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_ToString(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_ToString(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_TrimContext extends ExprContext {
        public TerminalNode FN_TRIM() {
            return getToken(OwlParser.FN_TRIM, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_TrimContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_Trim(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_Trim(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_Trim(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_ContainsContext extends ExprContext {
        public TerminalNode FN_CONTAINS() {
            return getToken(OwlParser.FN_CONTAINS, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_ContainsContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_Contains(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_Contains(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_Contains(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_LenContext extends ExprContext {
        public TerminalNode FN_LEN() {
            return getToken(OwlParser.FN_LEN, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_LenContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_Len(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_Len(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_Len(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_IntersectionContext extends ExprContext {
        public TerminalNode FN_INTERSECTION() {
            return getToken(OwlParser.FN_INTERSECTION, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_IntersectionContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_Intersection(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_Intersection(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_Intersection(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_NotContainsContext extends ExprContext {
        public TerminalNode FN_NOT_CONTAINS() {
            return getToken(OwlParser.FN_NOT_CONTAINS, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_NotContainsContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_NotContains(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_NotContains(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_NotContains(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_RandContext extends ExprContext {
        public TerminalNode FN_RAND() {
            return getToken(OwlParser.FN_RAND, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_RandContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_Rand(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_Rand(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_Rand(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_AvgContext extends ExprContext {
        public TerminalNode FN_AVG() {
            return getToken(OwlParser.FN_AVG, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_AvgContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_Avg(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_Avg(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_Avg(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_MinContext extends ExprContext {
        public TerminalNode FN_MIN() {
            return getToken(OwlParser.FN_MIN, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_MinContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_Min(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_Min(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_Min(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_SumContext extends ExprContext {
        public TerminalNode FN_SUM() {
            return getToken(OwlParser.FN_SUM, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_SumContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_Sum(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_Sum(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_Sum(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class CompareNumContext extends ExprContext {
        public Token op;

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode LT() {
            return getToken(OwlParser.LT, 0);
        }

        public TerminalNode GT() {
            return getToken(OwlParser.GT, 0);
        }

        public TerminalNode EQ() {
            return getToken(OwlParser.EQ, 0);
        }

        public TerminalNode LTEQ() {
            return getToken(OwlParser.LTEQ, 0);
        }

        public TerminalNode GTEQ() {
            return getToken(OwlParser.GTEQ, 0);
        }

        public TerminalNode NEQ() {
            return getToken(OwlParser.NEQ, 0);
        }

        public CompareNumContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterCompareNum(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitCompareNum(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitCompareNum(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ParenExprContext extends ExprContext {
        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public ParenExprContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterParenExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitParenExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitParenExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_FloorContext extends ExprContext {
        public TerminalNode FN_FLOOR() {
            return getToken(OwlParser.FN_FLOOR, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_FloorContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_Floor(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_Floor(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_Floor(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fn_SortContext extends ExprContext {
        public ExprContext asc;

        public TerminalNode FN_SORT() {
            return getToken(OwlParser.FN_SORT, 0);
        }

        public TerminalNode LP() {
            return getToken(OwlParser.LP, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RP() {
            return getToken(OwlParser.RP, 0);
        }

        public Fn_SortContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterFn_Sort(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitFn_Sort(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitFn_Sort(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprContext expr() throws RecognitionException {
        return expr(0);
    }

    private ExprContext expr(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        ExprContext _localctx = new ExprContext(_ctx, _parentState);
        ExprContext _prevctx = _localctx;
        int _startState = 8;
        enterRecursionRule(_localctx, 8, RULE_expr, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(306);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case SUB:
                    case K_GLB_VAR_PREFIX:
                    case INT:
                    case DOUBLE:
                    case STRING:
                    case BOOLEAN:
                    case ID: {
                        _localctx = new VarRefContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;

                        setState(89);
                        var();
                    }
                    break;
                    case LP: {
                        _localctx = new ParenExprContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(90);
                        match(LP);
                        setState(91);
                        expr(0);
                        setState(92);
                        match(RP);
                    }
                    break;
                    case FN_RAND: {
                        _localctx = new Fn_RandContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(94);
                        match(FN_RAND);
                        setState(95);
                        match(LP);
                        setState(96);
                        match(RP);
                    }
                    break;
                    case FN_ABS: {
                        _localctx = new Fn_AbsContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(97);
                        match(FN_ABS);
                        setState(98);
                        match(LP);
                        setState(99);
                        expr(0);
                        setState(100);
                        match(RP);
                    }
                    break;
                    case FN_CEIL: {
                        _localctx = new Fn_CeilContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(102);
                        match(FN_CEIL);
                        setState(103);
                        match(LP);
                        setState(104);
                        expr(0);
                        setState(105);
                        match(RP);
                    }
                    break;
                    case FN_FLOOR: {
                        _localctx = new Fn_FloorContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(107);
                        match(FN_FLOOR);
                        setState(108);
                        match(LP);
                        setState(109);
                        expr(0);
                        setState(110);
                        match(RP);
                    }
                    break;
                    case FN_AVG: {
                        _localctx = new Fn_AvgContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(112);
                        match(FN_AVG);
                        setState(113);
                        match(LP);
                        setState(114);
                        expr(0);
                        setState(115);
                        match(RP);
                    }
                    break;
                    case FN_MAX: {
                        _localctx = new Fn_MaxContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(117);
                        match(FN_MAX);
                        setState(118);
                        match(LP);
                        setState(119);
                        expr(0);
                        setState(124);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 4, _ctx);
                        while (_alt != 1 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                            if (_alt == 1 + 1) {
                                {
                                    {
                                        setState(120);
                                        match(T__3);
                                        setState(121);
                                        expr(0);
                                    }
                                }
                            }
                            setState(126);
                            _errHandler.sync(this);
                            _alt = getInterpreter().adaptivePredict(_input, 4, _ctx);
                        }
                        setState(127);
                        match(RP);
                    }
                    break;
                    case FN_MIN: {
                        _localctx = new Fn_MinContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(129);
                        match(FN_MIN);
                        setState(130);
                        match(LP);
                        setState(131);
                        expr(0);
                        setState(136);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 5, _ctx);
                        while (_alt != 1 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                            if (_alt == 1 + 1) {
                                {
                                    {
                                        setState(132);
                                        match(T__3);
                                        setState(133);
                                        expr(0);
                                    }
                                }
                            }
                            setState(138);
                            _errHandler.sync(this);
                            _alt = getInterpreter().adaptivePredict(_input, 5, _ctx);
                        }
                        setState(139);
                        match(RP);
                    }
                    break;
                    case FN_SUM: {
                        _localctx = new Fn_SumContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(141);
                        match(FN_SUM);
                        setState(142);
                        match(LP);
                        setState(143);
                        expr(0);
                        setState(148);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 6, _ctx);
                        while (_alt != 1 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                            if (_alt == 1 + 1) {
                                {
                                    {
                                        setState(144);
                                        match(T__3);
                                        setState(145);
                                        expr(0);
                                    }
                                }
                            }
                            setState(150);
                            _errHandler.sync(this);
                            _alt = getInterpreter().adaptivePredict(_input, 6, _ctx);
                        }
                        setState(151);
                        match(RP);
                    }
                    break;
                    case FN_STD: {
                        _localctx = new Fn_StdContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(153);
                        match(FN_STD);
                        setState(154);
                        match(LP);
                        setState(155);
                        expr(0);
                        setState(160);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 7, _ctx);
                        while (_alt != 1 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                            if (_alt == 1 + 1) {
                                {
                                    {
                                        setState(156);
                                        match(T__3);
                                        setState(157);
                                        expr(0);
                                    }
                                }
                            }
                            setState(162);
                            _errHandler.sync(this);
                            _alt = getInterpreter().adaptivePredict(_input, 7, _ctx);
                        }
                        setState(163);
                        match(RP);
                    }
                    break;
                    case FN_VARIANCE: {
                        _localctx = new Fn_VarianceContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(165);
                        match(FN_VARIANCE);
                        setState(166);
                        match(LP);
                        setState(167);
                        expr(0);
                        setState(172);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 8, _ctx);
                        while (_alt != 1 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                            if (_alt == 1 + 1) {
                                {
                                    {
                                        setState(168);
                                        match(T__3);
                                        setState(169);
                                        expr(0);
                                    }
                                }
                            }
                            setState(174);
                            _errHandler.sync(this);
                            _alt = getInterpreter().adaptivePredict(_input, 8, _ctx);
                        }
                        setState(175);
                        match(RP);
                    }
                    break;
                    case FN_ROUND: {
                        _localctx = new Fn_RoundContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(177);
                        match(FN_ROUND);
                        setState(178);
                        match(LP);
                        setState(179);
                        expr(0);
                        setState(182);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == T__3) {
                            {
                                setState(180);
                                match(T__3);
                                setState(181);
                                match(INT);
                            }
                        }

                        setState(184);
                        match(RP);
                    }
                    break;
                    case FN_TRIM: {
                        _localctx = new Fn_TrimContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(186);
                        match(FN_TRIM);
                        setState(187);
                        match(LP);
                        setState(188);
                        expr(0);
                        setState(189);
                        match(RP);
                    }
                    break;
                    case FN_CONCAT: {
                        _localctx = new Fn_ConcatContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(191);
                        match(FN_CONCAT);
                        setState(192);
                        match(LP);
                        setState(193);
                        expr(0);
                        setState(194);
                        match(T__3);
                        setState(195);
                        expr(0);
                        setState(198);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == T__3) {
                            {
                                setState(196);
                                match(T__3);
                                setState(197);
                                ((Fn_ConcatContext) _localctx).sep = expr(0);
                            }
                        }

                        setState(200);
                        match(RP);
                    }
                    break;
                    case FN_LEN: {
                        _localctx = new Fn_LenContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(202);
                        match(FN_LEN);
                        setState(203);
                        match(LP);
                        setState(204);
                        expr(0);
                        setState(205);
                        match(RP);
                    }
                    break;
                    case FN_SUBSTR: {
                        _localctx = new Fn_SubstrContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(207);
                        match(FN_SUBSTR);
                        setState(208);
                        match(LP);
                        setState(209);
                        expr(0);
                        setState(210);
                        match(T__3);
                        setState(211);
                        ((Fn_SubstrContext) _localctx).start = match(INT);
                        setState(212);
                        match(T__3);
                        setState(213);
                        ((Fn_SubstrContext) _localctx).end = match(INT);
                        setState(214);
                        match(RP);
                    }
                    break;
                    case FN_CONTAINS: {
                        _localctx = new Fn_ContainsContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(216);
                        match(FN_CONTAINS);
                        setState(217);
                        match(LP);
                        setState(218);
                        expr(0);
                        setState(219);
                        match(T__3);
                        setState(220);
                        expr(0);
                        setState(221);
                        match(RP);
                    }
                    break;
                    case FN_NOT_CONTAINS: {
                        _localctx = new Fn_NotContainsContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(223);
                        match(FN_NOT_CONTAINS);
                        setState(224);
                        match(LP);
                        setState(225);
                        expr(0);
                        setState(226);
                        match(T__3);
                        setState(227);
                        expr(0);
                        setState(228);
                        match(RP);
                    }
                    break;
                    case FN_EQ: {
                        _localctx = new Fn_EqContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(230);
                        match(FN_EQ);
                        setState(231);
                        match(LP);
                        setState(232);
                        expr(0);
                        setState(233);
                        match(T__3);
                        setState(234);
                        expr(0);
                        setState(235);
                        match(RP);
                    }
                    break;
                    case FN_NEQ: {
                        _localctx = new Fn_NEqContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(237);
                        match(FN_NEQ);
                        setState(238);
                        match(LP);
                        setState(239);
                        expr(0);
                        setState(240);
                        match(T__3);
                        setState(241);
                        expr(0);
                        setState(242);
                        match(RP);
                    }
                    break;
                    case FN_NVL: {
                        _localctx = new Fn_NvlContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(244);
                        match(FN_NVL);
                        setState(245);
                        match(LP);
                        setState(246);
                        expr(0);
                        setState(247);
                        match(T__3);
                        setState(248);
                        expr(0);
                        setState(249);
                        match(RP);
                    }
                    break;
                    case FN_UNION: {
                        _localctx = new Fn_UnionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(251);
                        match(FN_UNION);
                        setState(252);
                        match(LP);
                        setState(253);
                        expr(0);
                        setState(254);
                        match(T__3);
                        setState(255);
                        expr(0);
                        setState(256);
                        match(RP);
                    }
                    break;
                    case FN_APPEND: {
                        _localctx = new Fn_AppendContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(258);
                        match(FN_APPEND);
                        setState(259);
                        match(LP);
                        setState(260);
                        expr(0);
                        setState(261);
                        match(T__3);
                        setState(262);
                        expr(0);
                        setState(263);
                        match(RP);
                    }
                    break;
                    case FN_SORT: {
                        _localctx = new Fn_SortContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(265);
                        match(FN_SORT);
                        setState(266);
                        match(LP);
                        setState(267);
                        expr(0);
                        setState(270);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == T__3) {
                            {
                                setState(268);
                                match(T__3);
                                setState(269);
                                ((Fn_SortContext) _localctx).asc = expr(0);
                            }
                        }

                        setState(272);
                        match(RP);
                    }
                    break;
                    case FN_DEDUP: {
                        _localctx = new Fn_DedupContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(274);
                        match(FN_DEDUP);
                        setState(275);
                        match(LP);
                        setState(276);
                        expr(0);
                        setState(277);
                        match(RP);
                    }
                    break;
                    case FN_INTERSECTION: {
                        _localctx = new Fn_IntersectionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(279);
                        match(FN_INTERSECTION);
                        setState(280);
                        match(LP);
                        setState(281);
                        expr(0);
                        setState(282);
                        match(T__3);
                        setState(283);
                        expr(0);
                        setState(284);
                        match(RP);
                    }
                    break;
                    case FN_ISNULL: {
                        _localctx = new Fn_IsNullContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(286);
                        match(FN_ISNULL);
                        setState(287);
                        match(LP);
                        setState(288);
                        expr(0);
                        setState(289);
                        match(RP);
                    }
                    break;
                    case FN_ISNOTNULL: {
                        _localctx = new Fn_IsNotNullContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(291);
                        match(FN_ISNOTNULL);
                        setState(292);
                        match(LP);
                        setState(293);
                        expr(0);
                        setState(294);
                        match(RP);
                    }
                    break;
                    case FN_TOSTRING: {
                        _localctx = new Fn_ToStringContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(296);
                        match(FN_TOSTRING);
                        setState(297);
                        match(LP);
                        setState(298);
                        expr(0);
                        setState(299);
                        match(RP);
                    }
                    break;
                    case FN_TONUMBER: {
                        _localctx = new Fn_ToNumberContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(301);
                        match(FN_TONUMBER);
                        setState(302);
                        match(LP);
                        setState(303);
                        expr(0);
                        setState(304);
                        match(RP);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                _ctx.stop = _input.LT(-1);
                setState(322);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 14, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(320);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 13, _ctx)) {
                                case 1: {
                                    _localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(308);
                                    if (!(precpred(_ctx, 35)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 35)");
                                    setState(309);
                                    ((MulDivContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == MUL || _la == DIV)) {
                                        ((MulDivContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(310);
                                    expr(36);
                                }
                                break;
                                case 2: {
                                    _localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(311);
                                    if (!(precpred(_ctx, 34)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 34)");
                                    setState(312);
                                    ((AddSubContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == ADD || _la == SUB)) {
                                        ((AddSubContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(313);
                                    expr(35);
                                }
                                break;
                                case 3: {
                                    _localctx = new CompareNumContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(314);
                                    if (!(precpred(_ctx, 33)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 33)");
                                    setState(315);
                                    ((CompareNumContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << GT) | (1L << EQ) | (1L << LTEQ) | (1L << GTEQ) | (1L << NEQ))) != 0))) {
                                        ((CompareNumContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(316);
                                    expr(34);
                                }
                                break;
                                case 4: {
                                    _localctx = new BoolExprContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(317);
                                    if (!(precpred(_ctx, 32)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 32)");
                                    setState(318);
                                    ((BoolExprContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == AND || _la == OR)) {
                                        ((BoolExprContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(319);
                                    expr(33);
                                }
                                break;
                            }
                        }
                    }
                    setState(324);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 14, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public static class VarContext extends ParserRuleContext {
        public VarContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_var;
        }

        public VarContext() {
        }

        public void copyFrom(VarContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class Var_GlobalVarContext extends VarContext {
        public GlbvarContext glbvar() {
            return getRuleContext(GlbvarContext.class, 0);
        }

        public Var_GlobalVarContext(VarContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterVar_GlobalVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitVar_GlobalVar(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitVar_GlobalVar(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Var_IdentifierContext extends VarContext {
        public TerminalNode ID() {
            return getToken(OwlParser.ID, 0);
        }

        public Var_IdentifierContext(VarContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterVar_Identifier(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitVar_Identifier(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitVar_Identifier(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Var_LiteralContext extends VarContext {
        public LiteralContext literal() {
            return getRuleContext(LiteralContext.class, 0);
        }

        public Var_LiteralContext(VarContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterVar_Literal(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitVar_Literal(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitVar_Literal(this);
            else return visitor.visitChildren(this);
        }
    }

    public final VarContext var() throws RecognitionException {
        VarContext _localctx = new VarContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_var);
        try {
            setState(328);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case ID:
                    _localctx = new Var_IdentifierContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(325);
                    match(ID);
                }
                break;
                case K_GLB_VAR_PREFIX:
                    _localctx = new Var_GlobalVarContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(326);
                    glbvar();
                }
                break;
                case SUB:
                case INT:
                case DOUBLE:
                case STRING:
                case BOOLEAN:
                    _localctx = new Var_LiteralContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(327);
                    literal();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ArrContext extends ParserRuleContext {
        public ArrContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_arr;
        }

        public ArrContext() {
        }

        public void copyFrom(ArrContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class Arr_EmptyContext extends ArrContext {
        public Arr_EmptyContext(ArrContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterArr_Empty(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitArr_Empty(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitArr_Empty(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Arr_SizedContext extends ArrContext {
        public List<VarContext> var() {
            return getRuleContexts(VarContext.class);
        }

        public VarContext var(int i) {
            return getRuleContext(VarContext.class, i);
        }

        public Arr_SizedContext(ArrContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterArr_Sized(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitArr_Sized(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitArr_Sized(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ArrContext arr() throws RecognitionException {
        ArrContext _localctx = new ArrContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_arr);
        int _la;
        try {
            setState(343);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 17, _ctx)) {
                case 1:
                    _localctx = new Arr_SizedContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(330);
                    match(T__4);
                    setState(331);
                    var();
                    setState(336);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T__3) {
                        {
                            {
                                setState(332);
                                match(T__3);
                                setState(333);
                                var();
                            }
                        }
                        setState(338);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(339);
                    match(T__5);
                }
                break;
                case 2:
                    _localctx = new Arr_EmptyContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(341);
                    match(T__4);
                    setState(342);
                    match(T__5);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class LiteralContext extends ParserRuleContext {
        public LiteralContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_literal;
        }

        public LiteralContext() {
        }

        public void copyFrom(LiteralContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class Lit_Neg_DoubleContext extends LiteralContext {
        public TerminalNode SUB() {
            return getToken(OwlParser.SUB, 0);
        }

        public TerminalNode DOUBLE() {
            return getToken(OwlParser.DOUBLE, 0);
        }

        public Lit_Neg_DoubleContext(LiteralContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterLit_Neg_Double(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitLit_Neg_Double(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitLit_Neg_Double(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Lit_IntContext extends LiteralContext {
        public TerminalNode INT() {
            return getToken(OwlParser.INT, 0);
        }

        public Lit_IntContext(LiteralContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterLit_Int(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitLit_Int(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitLit_Int(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Lit_Neg_IntContext extends LiteralContext {
        public TerminalNode SUB() {
            return getToken(OwlParser.SUB, 0);
        }

        public TerminalNode INT() {
            return getToken(OwlParser.INT, 0);
        }

        public Lit_Neg_IntContext(LiteralContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterLit_Neg_Int(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitLit_Neg_Int(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitLit_Neg_Int(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Lit_StringContext extends LiteralContext {
        public TerminalNode STRING() {
            return getToken(OwlParser.STRING, 0);
        }

        public Lit_StringContext(LiteralContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterLit_String(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitLit_String(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitLit_String(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Lit_DoubleContext extends LiteralContext {
        public TerminalNode DOUBLE() {
            return getToken(OwlParser.DOUBLE, 0);
        }

        public Lit_DoubleContext(LiteralContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterLit_Double(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitLit_Double(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitLit_Double(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Lit_BooleanContext extends LiteralContext {
        public TerminalNode BOOLEAN() {
            return getToken(OwlParser.BOOLEAN, 0);
        }

        public Lit_BooleanContext(LiteralContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterLit_Boolean(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitLit_Boolean(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitLit_Boolean(this);
            else return visitor.visitChildren(this);
        }
    }

    public final LiteralContext literal() throws RecognitionException {
        LiteralContext _localctx = new LiteralContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_literal);
        try {
            setState(353);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 18, _ctx)) {
                case 1:
                    _localctx = new Lit_IntContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(345);
                    match(INT);
                }
                break;
                case 2:
                    _localctx = new Lit_Neg_IntContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(346);
                    match(SUB);
                    setState(347);
                    match(INT);
                }
                break;
                case 3:
                    _localctx = new Lit_DoubleContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(348);
                    match(DOUBLE);
                }
                break;
                case 4:
                    _localctx = new Lit_Neg_DoubleContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(349);
                    match(SUB);
                    setState(350);
                    match(DOUBLE);
                }
                break;
                case 5:
                    _localctx = new Lit_StringContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(351);
                    match(STRING);
                }
                break;
                case 6:
                    _localctx = new Lit_BooleanContext(_localctx);
                    enterOuterAlt(_localctx, 6);
                {
                    setState(352);
                    match(BOOLEAN);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class GlbvarContext extends ParserRuleContext {
        public TerminalNode K_GLB_VAR_PREFIX() {
            return getToken(OwlParser.K_GLB_VAR_PREFIX, 0);
        }

        public TerminalNode ID() {
            return getToken(OwlParser.ID, 0);
        }

        public GlbvarContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_glbvar;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).enterGlbvar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof OwlListener) ((OwlListener) listener).exitGlbvar(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof OwlVisitor) return ((OwlVisitor<? extends T>) visitor).visitGlbvar(this);
            else return visitor.visitChildren(this);
        }
    }

    public final GlbvarContext glbvar() throws RecognitionException {
        GlbvarContext _localctx = new GlbvarContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_glbvar);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(355);
                match(K_GLB_VAR_PREFIX);
                setState(356);
                match(ID);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 4:
                return expr_sempred((ExprContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean expr_sempred(ExprContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 35);
            case 1:
                return precpred(_ctx, 34);
            case 2:
                return precpred(_ctx, 33);
            case 3:
                return precpred(_ctx, 32);
        }
        return true;
    }

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3F\u0169\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\6\2" +
                    "\26\n\2\r\2\16\2\27\3\2\3\2\3\3\3\3\7\3\36\n\3\f\3\16\3!\13\3\3\3\3\3" +
                    "\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3" +
                    "\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4C\n\4\3\5\3\5\3" +
                    "\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5" +
                    "\5\5Y\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6" +
                    "\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3" +
                    "\6\3\6\7\6}\n\6\f\6\16\6\u0080\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u0089" +
                    "\n\6\f\6\16\6\u008c\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u0095\n\6\f\6" +
                    "\16\6\u0098\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00a1\n\6\f\6\16\6\u00a4" +
                    "\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00ad\n\6\f\6\16\6\u00b0\13\6\3" +
                    "\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00b9\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3" +
                    "\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00c9\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3" +
                    "\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6" +
                    "\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3" +
                    "\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6" +
                    "\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0111\n\6\3\6\3\6\3\6\3\6" +
                    "\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3" +
                    "\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0135\n\6\3\6\3" +
                    "\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u0143\n\6\f\6\16\6\u0146" +
                    "\13\6\3\7\3\7\3\7\5\7\u014b\n\7\3\b\3\b\3\b\3\b\7\b\u0151\n\b\f\b\16\b" +
                    "\u0154\13\b\3\b\3\b\3\b\3\b\5\b\u015a\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t" +
                    "\3\t\5\t\u0164\n\t\3\n\3\n\3\n\3\n\7~\u008a\u0096\u00a2\u00ae\3\n\13\2" +
                    "\4\6\b\n\f\16\20\22\2\6\3\2\13\f\3\2\t\n\3\2\r\22\3\2\23\24\2\u019e\2" +
                    "\25\3\2\2\2\4\33\3\2\2\2\6B\3\2\2\2\bX\3\2\2\2\n\u0134\3\2\2\2\f\u014a" +
                    "\3\2\2\2\16\u0159\3\2\2\2\20\u0163\3\2\2\2\22\u0165\3\2\2\2\24\26\5\6" +
                    "\4\2\25\24\3\2\2\2\26\27\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\31\3\2" +
                    "\2\2\31\32\7\2\2\3\32\3\3\2\2\2\33\37\7\3\2\2\34\36\5\6\4\2\35\34\3\2" +
                    "\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \"\3\2\2\2!\37\3\2\2\2\"#\7" +
                    "\4\2\2#\5\3\2\2\2$%\5\n\6\2%&\7D\2\2&C\3\2\2\2\'(\5\b\5\2()\7D\2\2)C\3" +
                    "\2\2\2*+\7C\2\2+,\7\5\2\2,-\5\n\6\2-.\7D\2\2.C\3\2\2\2/\60\7@\2\2\60\61" +
                    "\7:\2\2\61\62\5\n\6\2\62\63\7;\2\2\63\64\5\4\3\2\64C\3\2\2\2\65\66\7@" +
                    "\2\2\66\67\7:\2\2\678\5\n\6\289\7;\2\29:\5\4\3\2:;\7A\2\2;<\5\4\3\2<C" +
                    "\3\2\2\2=>\7?\2\2>?\5\n\6\2?@\7D\2\2@C\3\2\2\2AC\7D\2\2B$\3\2\2\2B\'\3" +
                    "\2\2\2B*\3\2\2\2B/\3\2\2\2B\65\3\2\2\2B=\3\2\2\2BA\3\2\2\2C\7\3\2\2\2" +
                    "DE\7\64\2\2EF\7C\2\2FG\7\5\2\2GY\5\n\6\2HI\7\65\2\2IJ\7C\2\2JK\7\5\2\2" +
                    "KY\5\n\6\2LM\7\66\2\2MN\7C\2\2NO\7\5\2\2OY\5\n\6\2PQ\7\67\2\2QR\7C\2\2" +
                    "RS\7\5\2\2SY\5\n\6\2TU\78\2\2UV\7C\2\2VW\7\5\2\2WY\5\16\b\2XD\3\2\2\2" +
                    "XH\3\2\2\2XL\3\2\2\2XP\3\2\2\2XT\3\2\2\2Y\t\3\2\2\2Z[\b\6\1\2[\u0135\5" +
                    "\f\7\2\\]\7:\2\2]^\5\n\6\2^_\7;\2\2_\u0135\3\2\2\2`a\7\35\2\2ab\7:\2\2" +
                    "b\u0135\7;\2\2cd\7\25\2\2de\7:\2\2ef\5\n\6\2fg\7;\2\2g\u0135\3\2\2\2h" +
                    "i\7\31\2\2ij\7:\2\2jk\5\n\6\2kl\7;\2\2l\u0135\3\2\2\2mn\7\32\2\2no\7:" +
                    "\2\2op\5\n\6\2pq\7;\2\2q\u0135\3\2\2\2rs\7\26\2\2st\7:\2\2tu\5\n\6\2u" +
                    "v\7;\2\2v\u0135\3\2\2\2wx\7\33\2\2xy\7:\2\2y~\5\n\6\2z{\7\6\2\2{}\5\n" +
                    "\6\2|z\3\2\2\2}\u0080\3\2\2\2~\177\3\2\2\2~|\3\2\2\2\177\u0081\3\2\2\2" +
                    "\u0080~\3\2\2\2\u0081\u0082\7;\2\2\u0082\u0135\3\2\2\2\u0083\u0084\7\34" +
                    "\2\2\u0084\u0085\7:\2\2\u0085\u008a\5\n\6\2\u0086\u0087\7\6\2\2\u0087" +
                    "\u0089\5\n\6\2\u0088\u0086\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u008b\3\2" +
                    "\2\2\u008a\u0088\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008a\3\2\2\2\u008d" +
                    "\u008e\7;\2\2\u008e\u0135\3\2\2\2\u008f\u0090\7\37\2\2\u0090\u0091\7:" +
                    "\2\2\u0091\u0096\5\n\6\2\u0092\u0093\7\6\2\2\u0093\u0095\5\n\6\2\u0094" +
                    "\u0092\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0097\3\2\2\2\u0096\u0094\3\2" +
                    "\2\2\u0097\u0099\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009a\7;\2\2\u009a" +
                    "\u0135\3\2\2\2\u009b\u009c\7 \2\2\u009c\u009d\7:\2\2\u009d\u00a2\5\n\6" +
                    "\2\u009e\u009f\7\6\2\2\u009f\u00a1\5\n\6\2\u00a0\u009e\3\2\2\2\u00a1\u00a4" +
                    "\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a5\3\2\2\2\u00a4" +
                    "\u00a2\3\2\2\2\u00a5\u00a6\7;\2\2\u00a6\u0135\3\2\2\2\u00a7\u00a8\7!\2" +
                    "\2\u00a8\u00a9\7:\2\2\u00a9\u00ae\5\n\6\2\u00aa\u00ab\7\6\2\2\u00ab\u00ad" +
                    "\5\n\6\2\u00ac\u00aa\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00af\3\2\2\2\u00ae" +
                    "\u00ac\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b2\7;" +
                    "\2\2\u00b2\u0135\3\2\2\2\u00b3\u00b4\7\36\2\2\u00b4\u00b5\7:\2\2\u00b5" +
                    "\u00b8\5\n\6\2\u00b6\u00b7\7\6\2\2\u00b7\u00b9\7<\2\2\u00b8\u00b6\3\2" +
                    "\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\7;\2\2\u00bb" +
                    "\u0135\3\2\2\2\u00bc\u00bd\7\"\2\2\u00bd\u00be\7:\2\2\u00be\u00bf\5\n" +
                    "\6\2\u00bf\u00c0\7;\2\2\u00c0\u0135\3\2\2\2\u00c1\u00c2\7#\2\2\u00c2\u00c3" +
                    "\7:\2\2\u00c3\u00c4\5\n\6\2\u00c4\u00c5\7\6\2\2\u00c5\u00c8\5\n\6\2\u00c6" +
                    "\u00c7\7\6\2\2\u00c7\u00c9\5\n\6\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2" +
                    "\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\7;\2\2\u00cb\u0135\3\2\2\2\u00cc" +
                    "\u00cd\7$\2\2\u00cd\u00ce\7:\2\2\u00ce\u00cf\5\n\6\2\u00cf\u00d0\7;\2" +
                    "\2\u00d0\u0135\3\2\2\2\u00d1\u00d2\7*\2\2\u00d2\u00d3\7:\2\2\u00d3\u00d4" +
                    "\5\n\6\2\u00d4\u00d5\7\6\2\2\u00d5\u00d6\7<\2\2\u00d6\u00d7\7\6\2\2\u00d7" +
                    "\u00d8\7<\2\2\u00d8\u00d9\7;\2\2\u00d9\u0135\3\2\2\2\u00da\u00db\7+\2" +
                    "\2\u00db\u00dc\7:\2\2\u00dc\u00dd\5\n\6\2\u00dd\u00de\7\6\2\2\u00de\u00df" +
                    "\5\n\6\2\u00df\u00e0\7;\2\2\u00e0\u0135\3\2\2\2\u00e1\u00e2\7,\2\2\u00e2" +
                    "\u00e3\7:\2\2\u00e3\u00e4\5\n\6\2\u00e4\u00e5\7\6\2\2\u00e5\u00e6\5\n" +
                    "\6\2\u00e6\u00e7\7;\2\2\u00e7\u0135\3\2\2\2\u00e8\u00e9\7.\2\2\u00e9\u00ea" +
                    "\7:\2\2\u00ea\u00eb\5\n\6\2\u00eb\u00ec\7\6\2\2\u00ec\u00ed\5\n\6\2\u00ed" +
                    "\u00ee\7;\2\2\u00ee\u0135\3\2\2\2\u00ef\u00f0\7-\2\2\u00f0\u00f1\7:\2" +
                    "\2\u00f1\u00f2\5\n\6\2\u00f2\u00f3\7\6\2\2\u00f3\u00f4\5\n\6\2\u00f4\u00f5" +
                    "\7;\2\2\u00f5\u0135\3\2\2\2\u00f6\u00f7\7/\2\2\u00f7\u00f8\7:\2\2\u00f8" +
                    "\u00f9\5\n\6\2\u00f9\u00fa\7\6\2\2\u00fa\u00fb\5\n\6\2\u00fb\u00fc\7;" +
                    "\2\2\u00fc\u0135\3\2\2\2\u00fd\u00fe\7%\2\2\u00fe\u00ff\7:\2\2\u00ff\u0100" +
                    "\5\n\6\2\u0100\u0101\7\6\2\2\u0101\u0102\5\n\6\2\u0102\u0103\7;\2\2\u0103" +
                    "\u0135\3\2\2\2\u0104\u0105\7\'\2\2\u0105\u0106\7:\2\2\u0106\u0107\5\n" +
                    "\6\2\u0107\u0108\7\6\2\2\u0108\u0109\5\n\6\2\u0109\u010a\7;\2\2\u010a" +
                    "\u0135\3\2\2\2\u010b\u010c\7)\2\2\u010c\u010d\7:\2\2\u010d\u0110\5\n\6" +
                    "\2\u010e\u010f\7\6\2\2\u010f\u0111\5\n\6\2\u0110\u010e\3\2\2\2\u0110\u0111" +
                    "\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\7;\2\2\u0113\u0135\3\2\2\2\u0114" +
                    "\u0115\7(\2\2\u0115\u0116\7:\2\2\u0116\u0117\5\n\6\2\u0117\u0118\7;\2" +
                    "\2\u0118\u0135\3\2\2\2\u0119\u011a\7&\2\2\u011a\u011b\7:\2\2\u011b\u011c" +
                    "\5\n\6\2\u011c\u011d\7\6\2\2\u011d\u011e\5\n\6\2\u011e\u011f\7;\2\2\u011f" +
                    "\u0135\3\2\2\2\u0120\u0121\7\60\2\2\u0121\u0122\7:\2\2\u0122\u0123\5\n" +
                    "\6\2\u0123\u0124\7;\2\2\u0124\u0135\3\2\2\2\u0125\u0126\7\61\2\2\u0126" +
                    "\u0127\7:\2\2\u0127\u0128\5\n\6\2\u0128\u0129\7;\2\2\u0129\u0135\3\2\2" +
                    "\2\u012a\u012b\7\62\2\2\u012b\u012c\7:\2\2\u012c\u012d\5\n\6\2\u012d\u012e" +
                    "\7;\2\2\u012e\u0135\3\2\2\2\u012f\u0130\7\63\2\2\u0130\u0131\7:\2\2\u0131" +
                    "\u0132\5\n\6\2\u0132\u0133\7;\2\2\u0133\u0135\3\2\2\2\u0134Z\3\2\2\2\u0134" +
                    "\\\3\2\2\2\u0134`\3\2\2\2\u0134c\3\2\2\2\u0134h\3\2\2\2\u0134m\3\2\2\2" +
                    "\u0134r\3\2\2\2\u0134w\3\2\2\2\u0134\u0083\3\2\2\2\u0134\u008f\3\2\2\2" +
                    "\u0134\u009b\3\2\2\2\u0134\u00a7\3\2\2\2\u0134\u00b3\3\2\2\2\u0134\u00bc" +
                    "\3\2\2\2\u0134\u00c1\3\2\2\2\u0134\u00cc\3\2\2\2\u0134\u00d1\3\2\2\2\u0134" +
                    "\u00da\3\2\2\2\u0134\u00e1\3\2\2\2\u0134\u00e8\3\2\2\2\u0134\u00ef\3\2" +
                    "\2\2\u0134\u00f6\3\2\2\2\u0134\u00fd\3\2\2\2\u0134\u0104\3\2\2\2\u0134" +
                    "\u010b\3\2\2\2\u0134\u0114\3\2\2\2\u0134\u0119\3\2\2\2\u0134\u0120\3\2" +
                    "\2\2\u0134\u0125\3\2\2\2\u0134\u012a\3\2\2\2\u0134\u012f\3\2\2\2\u0135" +
                    "\u0144\3\2\2\2\u0136\u0137\f%\2\2\u0137\u0138\t\2\2\2\u0138\u0143\5\n" +
                    "\6&\u0139\u013a\f$\2\2\u013a\u013b\t\3\2\2\u013b\u0143\5\n\6%\u013c\u013d" +
                    "\f#\2\2\u013d\u013e\t\4\2\2\u013e\u0143\5\n\6$\u013f\u0140\f\"\2\2\u0140" +
                    "\u0141\t\5\2\2\u0141\u0143\5\n\6#\u0142\u0136\3\2\2\2\u0142\u0139\3\2" +
                    "\2\2\u0142\u013c\3\2\2\2\u0142\u013f\3\2\2\2\u0143\u0146\3\2\2\2\u0144" +
                    "\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\13\3\2\2\2\u0146\u0144\3\2\2" +
                    "\2\u0147\u014b\7C\2\2\u0148\u014b\5\22\n\2\u0149\u014b\5\20\t\2\u014a" +
                    "\u0147\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u0149\3\2\2\2\u014b\r\3\2\2\2" +
                    "\u014c\u014d\7\7\2\2\u014d\u0152\5\f\7\2\u014e\u014f\7\6\2\2\u014f\u0151" +
                    "\5\f\7\2\u0150\u014e\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0152" +
                    "\u0153\3\2\2\2\u0153\u0155\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u0156\7\b" +
                    "\2\2\u0156\u015a\3\2\2\2\u0157\u0158\7\7\2\2\u0158\u015a\7\b\2\2\u0159" +
                    "\u014c\3\2\2\2\u0159\u0157\3\2\2\2\u015a\17\3\2\2\2\u015b\u0164\7<\2\2" +
                    "\u015c\u015d\7\n\2\2\u015d\u0164\7<\2\2\u015e\u0164\7=\2\2\u015f\u0160" +
                    "\7\n\2\2\u0160\u0164\7=\2\2\u0161\u0164\7>\2\2\u0162\u0164\7B\2\2\u0163" +
                    "\u015b\3\2\2\2\u0163\u015c\3\2\2\2\u0163\u015e\3\2\2\2\u0163\u015f\3\2" +
                    "\2\2\u0163\u0161\3\2\2\2\u0163\u0162\3\2\2\2\u0164\21\3\2\2\2\u0165\u0166" +
                    "\79\2\2\u0166\u0167\7C\2\2\u0167\23\3\2\2\2\25\27\37BX~\u008a\u0096\u00a2" +
                    "\u00ae\u00b8\u00c8\u0110\u0134\u0142\u0144\u014a\u0152\u0159\u0163";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}