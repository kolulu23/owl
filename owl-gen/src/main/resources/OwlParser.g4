grammar OwlParser;
import OwlLexer;

prog        : statement+ EOF ;

block       : '{' statement* '}' ;

/**
 * A statement returns nothing to the DSL unit.
 * Note that 'assignValue' must use a declared varibale name.
 */
statement   : expr SEMI                                         # Stat_Expr
            | vardef SEMI                                       # Stat_Def
            | ID '=' expr SEMI                                  # Stat_Assign
            | IF LP expr RP block                               # Stat_If
            | IF LP expr RP block ELSE block                    # Stat_If_Else
            | RETURN expr                                       # Stat_Return
            | SEMI                                              # Stat_Blank
            ;

/**
 * Variable definition is a statement.
 * Specially, list variable is limited to one-dimension C-like array so that list can contains dynamic types.
 * Also, variables are copied into list when init a new list, which means there are no reference in our DSL.
 * To perform value update for non-list varibales, you must explicitly assign something to ID.
 */
vardef      : T_INT ID '=' expr                                 # Def_Int
            | T_DOUBLE ID '=' expr                              # Def_Double
            | T_BOOLEAN ID '=' expr                             # Def_Boolean
            | T_STRING ID '=' expr                              # Def_String
            | T_LIST ID '=' arr                                 # Def_List
            ;
/**
 * All kinds of expressions.
 * We diliberately add function call into expression to help us make semantic analysis and evaluation.
 * For function calls, if the type of any given arg doesn't match function definition, error could be thrown.
 * You can find function definitions in 'OwlLexer.g4'.
 */
expr        : expr op=(MUL|DIV) expr                            # MulDiv
            | expr op=(ADD|SUB) expr                            # AddSub
            | expr op=(LT|GT|EQ|LTEQ|GTEQ|NEQ) expr             # CompareNum
            | expr op=(AND|OR) expr                             # BoolExpr
            | var                                               # VarRef
            | LP expr RP                                        # ParenExpr
            | FN_RAND LP RP                                     # Fn_Rand
            | FN_ABS LP expr RP                                 # Fn_Abs
            | FN_CEIL LP expr RP                                # Fn_Ceil
            | FN_FLOOR LP expr RP                               # Fn_Floor
            | FN_AVG LP expr RP                                 # Fn_Avg
            | FN_MAX LP expr (',' expr)*? RP                    # Fn_Max
            | FN_MIN LP expr (',' expr)*? RP                    # Fn_Min
            | FN_SUM LP expr (',' expr)*? RP                    # Fn_Sum
            | FN_STD LP expr (',' expr)*? RP                    # Fn_Std
            | FN_VARIANCE LP expr (',' expr)*? RP               # Fn_Variance
            | FN_ROUND LP expr (',' INT)? RP                    # Fn_Round
            | FN_TRIM LP expr RP                                # Fn_Trim
            | FN_CONCAT LP expr ',' expr (',' sep=expr)? RP     # Fn_Concat
            | FN_LEN LP expr RP                                 # Fn_Len
            | FN_SUBSTR LP expr ',' start=INT ',' end=INT RP    # Fn_Substr
            | FN_CONTAINS LP expr ',' expr RP                   # Fn_Contains
            | FN_NOT_CONTAINS LP expr ',' expr RP               # Fn_NotContains
            | FN_EQ LP expr ',' expr RP                         # Fn_Eq
            | FN_NEQ LP expr ',' expr RP                        # Fn_NEq
            | FN_NVL LP expr ',' expr RP                        # Fn_Nvl
            | FN_UNION LP expr ',' expr RP                      # Fn_Union
            | FN_APPEND LP expr ',' expr RP                     # Fn_Append
            | FN_SORT LP expr (',' asc=expr)? RP                # Fn_Sort
            | FN_DEDUP LP expr RP                               # Fn_Dedup
            | FN_INTERSECTION LP expr ',' expr RP               # Fn_Intersection
            | FN_ISNULL LP expr RP                              # Fn_IsNull
            | FN_ISNOTNULL LP expr RP                           # Fn_IsNotNull
            | FN_TOSTRING LP expr RP                            # Fn_ToString
            | FN_TONUMBER LP expr RP                            # Fn_ToNumber
            ;

/**
 * Local variable or global variable
 */
var         : ID                                                # Var_Identifier
            | glbvar                                            # Var_GlobalVar
            | literal                                           # Var_Literal
            ;

arr         : '[' var (',' var)* ']'
            | '[' ']' ;

/**
 * Primitive type literals
 */
literal     : INT
            | '-' INT
            | DOUBLE
            | '-' DOUBLE
            | STRING
            | BOOLEAN
            ;

/**
 * Global variables
 */
glbvar       : K_GLB_VAR_PREFIX ID ;