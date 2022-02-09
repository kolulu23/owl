grammar OwlParser;
import OwlLexer;

prog        : statement+ EOF ;

block       : '{' statement* '}' ;

/**
 * A statement returns nothing to the DSL unit.
 * Note that 'assignValue' must use a declared varibale name.
 */
statement   : expr SEMI
            | vardef SEMI
            | ID '=' expr SEMI
            | SEMI;

/**
 * Variable definition is a statement.
 * Specially, list variable is limited to one-dimension C-like array so that list can contains dynamic types.
 * Also, variables are copied into list when init a new list, which means there are no reference in our DSL.
 * To perform value update for non-list varibales, you must explicitly assign something to ID.
 */
vardef      : T_INT ID '=' expr
            | T_DOUBLE ID '=' expr
            | T_BOOLEAN ID '=' expr
            | T_STRING ID '=' expr
            | T_LIST ID '=' arr
            ;
/**
 * All kinds of expressions.
 * We diliberately add function call into expression to help us make semantic analysis and evaluation.
 * For function calls, if the type of any given arg doesn't match function definition, error could be thrown.
 * You can find function definitions in 'OwlLexer.g4'.
 */
expr        : expr op=(MUL|DIV) expr
            | expr op=(ADD|SUB) expr
            | var
            | LP expr RP
            | FN_RAND LP RP
            | FN_ABS LP expr RP
            | FN_CEIL LP expr RP
            | FN_FLOOR LP expr RP
            | FN_AVG LP expr RP
            | FN_MAX LP expr (',' expr)*? RP
            | FN_MIN LP expr (',' expr)*? RP
            | FN_SUM LP expr (',' expr)*? RP
            | FN_STD LP expr (',' expr)*? RP
            | FN_VARIANCE LP expr (',' expr)*? RP
            | FN_ROUND LP expr (',' INT)? RP
            | FN_TRIM LP expr RP
            | FN_CONCAT LP expr ',' expr (',' sep=expr)? RP
            | FN_LEN LP expr RP
            | FN_SUBSTR LP expr ',' start=INT ',' end=INT RP
            | FN_CONTAINS LP expr ',' expr RP
            | FN_NOT_CONTAINS LP expr ',' expr RP
            | FN_EQ LP expr ',' expr RP
            | FN_NEQ LP expr ',' expr RP
            | FN_NVL LP expr ',' expr RP
            | FN_UNION LP expr ',' expr RP
            | FN_APPEND LP expr ',' expr RP
            | FN_DEDUP LP expr RP
            | FN_INTERSECTION LP expr ',' expr RP
            | FN_ISNULL LP expr RP
            | FN_ISNOTNULL LP expr RP
            | FN_TOSTRING LP expr RP
            | FN_TONUMBER LP expr RP
            ;

/**
 * Local variable or global variable
 */
var         : ID | glbvar | literal;

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