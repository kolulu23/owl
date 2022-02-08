lexer grammar OwlLexer;

/********** Arithmetic Operations *********/
ADD                         : '+' ;
SUB                         : '-' ;
MUL                         : '*' ;
DIV                         : '/' ;
LT                          : '<' ;
GT                          : '>' ;
EQ                          : '==' ;
LTEQ                        : '<=' ;
GTEQ                        : '>=' ;
NOTEQ                       : '!=' ;
AND                         : 'and' ;
OR                          : 'or' ;

/********** Basic Math Functions **********/
FN_ABS                      : K_FN_PREFIX 'abs' ;
FN_AVG                      : K_FN_PREFIX 'avg' ;
FN_MUL                      : K_FN_PREFIX 'mul' ;
FN_DIV                      : K_FN_PREFIX 'div' ;
FN_CEIL                     : K_FN_PREFIX 'ceil' ;
FN_FLOOR                    : K_FN_PREFIX 'floor' ;
FN_MAX                      : K_FN_PREFIX 'max' ;
FN_MIN                      : K_FN_PREFIX 'min' ;
FN_RAND                     : K_FN_PREFIX 'random' ;
FN_ROUND                    : K_FN_PREFIX 'round' ;
FN_SUM                      : K_FN_PREFIX 'sum' ;
FN_STD                      : K_FN_PREFIX 'std' ;
FN_VARIANCE                 : K_FN_PREFIX 'variance' ;

/**
 * @arg : string
 * Trims heading and trialing whitespaces. Returns the trimmed value.
 */
FN_TRIM                     : K_FN_PREFIX 'trim' ;

/**
 * @arg1 : string | int | double
 * @arg2 : string | int | double
 * Concats two args together. int and double values are converted into string first.
 */
FN_CONCAT                   : K_FN_PREFIX 'concat' ;

/**
 * @arg : string | list | set | int | double
 * Returns the length of given arg. int and double values are converted into string first.
 */
FN_LEN                      : K_FN_PREFIX 'len' ;

/**
 * @arg1 : string
 * @arg2 : int
 * @arg3 : int
 * Returns a subtring of arg1 start from arg2 end to arg3. Indices are start from 0.
 * For example, #substring('hello world', 0, 4) will return 'hello'.
 */
FN_SUBSTR                   : K_FN_PREFIX 'substring' ;

/**
 * @arg1 : string
 * @arg2 : string
 * Returns true if arg1 contains arg2, false if not.
 */
FN_CONTAINS                 : K_FN_PREFIX 'contains' ;
FN_NOT_CONTAINS             : K_FN_PREFIX 'notContains' ;

/**
 * @arg1 : any
 * @arg2 : any
 * Not equals.
 */
FN_NEQ                      : K_FN_PREFIX 'neq';

/**
 * @arg1 : any
 * @arg2 : any
 * Equals. Compare variable type and variable content.
 * We only impls partial eq, that is, #eq(null, null) is true.
 */
FN_EQ                       : K_FN_PREFIX 'eq' ;

/**
 * @arg1 : expr
 * @arg2 : expr
 * Takes two expressions as its arguments.
 * Evaluates both expressions, return the first expression reuslt if it does not return null or empty string.
 * Otherwise return the second. If both expression evals to non-null, then the first one will be returned.
 */
FN_NVL                      : K_FN_PREFIX 'nvl';

/**
 * @arg : any
 * Check expression evaluation result, returns a boolean.
 * Returns true if arg is null, false if arg is anything else.
 */
FN_ISNULL                   : K_FN_PREFIX 'isNull' ;

/**
 * @arg : any
 * Return the opposite of the above one.
 */
FN_ISNOTNULL                : K_FN_PREFIX 'isNotNull' ;

/**
 * @arg : any
 * Convert arg to string. This method will return 'null' if arg is null.
 */
FN_TOSTRING                 : K_FN_PREFIX 'toString' ;

/**
 * @arg : string | int | double
 * Convert arg to number. Returns null if arg cannot be converted.
 */
FN_TONUMBER                 : K_FN_PREFIX 'toNumber' ;

/**
 * @arg : string
 * Convert arg to datatime type.
 */
FN_TODATETIME               : K_FN_PREFIX 'toDateTime' ;

/********** Primitive Types **********/
T_INT                       : 'int' ;
T_DOUBLE                    : 'double' ;
T_BOOLEAN                   : 'boolean' ;
T_STRING                    : 'string' ;
T_ENUM                      : 'enum' ;

/**
 * Reference a global varible with this prefix.
 * Global variables are stored somewhere else, for example MySQL, Redis or even HDFS depending on
 * what executor client choose to use or implement.
 * Global variables are immutable to Owl executors.
 * Global variables are pre-loaded into Owl's execution Context.
 */
K_GLB_VAR_PREFIX            : '@' ;

/**
 * Reference a pre-defined function with this prefix.
 * Functions are like prefabricated actions that allows user send arguments to a context in application runtime
 * and egresses result to local variables or function caller.
 */
fragment K_FN_PREFIX        : '#' ;

// Signed integers and 0. Note: The actuall integer implementation is totally relies on JVM
INT             : DIGIT ;

// Sgined double values
DOUBLE          : DIGIT '.' FIGURE ;

// RAW strings. Unicodes like \u0298 are not translated.
STRING          : '"' ( '\\"' | . )*? '"';

// Keyword of return
RETURN          : 'return';

// Boolean lexer rules
BOOLEAN         : TRUE | FALSE ;
fragment TRUE   : 'true' ;
fragment FALSE  : 'false' ;

// Valid identifiers like 'foo', '_bar' and '__init0__'. Note that we allow it to be start with digits.
ID              : [a-zA-Z0-9_]+ ;

// Each line must have this ';' to become a statement or expression
SEMI            : ';'+ ;

// A number of figures, could be with leading zeros
fragment FIGURE : [0-9]+ ;

// Digits bigger than or eqaul to zero, basically singed integers and 0
fragment DIGIT  : '0' | '1'..'9' '0'..'9'* ;

// White spaces
WS              : [ \t\r\n]+ -> skip ;

// Line comment
LINE_COMMENT    : '//' ~[\r\n\t]* -> channel(HIDDEN) ;