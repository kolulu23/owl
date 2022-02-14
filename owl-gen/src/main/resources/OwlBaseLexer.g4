lexer grammar OwlBaseLexer;

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
NEQ                         : '!=' ;
AND                         : 'and' ;
OR                          : 'or' ;

/********** Basic Math Functions(Returns number) **********/

/**
 * Returns the absolute value of given number
 * @arg : int | double
 * @returns : int | double
 */
FN_ABS                      : K_FN_PREFIX 'abs' ;

/**
 * Returns the average value of given series of number
 * @arg : list
 * @returns : double
 */
FN_AVG                      : K_FN_PREFIX 'avg' ;
FN_MUL                      : K_FN_PREFIX 'mul' ;       // Not used
FN_DIV                      : K_FN_PREFIX 'div' ;       // Not used

/**
 * Ceiling a number, defualt precision is 1
 * @arg : int | double
 * @returns : int
 */
FN_CEIL                     : K_FN_PREFIX 'ceil' ;

/**
 * Floor a number, defualt precision is 1
 * @arg : int | double
 * @returns : int
 */
FN_FLOOR                    : K_FN_PREFIX 'floor' ;

/**
 * Get the maximum of given arg list.
 * This function takes one or more arguments. Non-number args are ignored.
 * @arg : int | double
 * @argN : int | double
 * @returns : int | double
 */
FN_MAX                      : K_FN_PREFIX 'max' ;

/**
 * Get the minimum of given arg list
 * This function takes one or more arguments. Non-number args are ignored.
 * @arg : int | double
 * @argN : int | double
 * @returns : int | double
 */
FN_MIN                      : K_FN_PREFIX 'min' ;

/**
 * Returns a pseudorandom double value between zero (inclusive) and one (exclusive).
 * @returns : double
 */
FN_RAND                     : K_FN_PREFIX 'random' ;

/**
 * Rounding a number with half-up method, defualt precision is 1.
 * When arg2 is provided, this function will use it as rounding precision.
 * For example, #round(6.6667, 2) evaluates to 6.7 and #round(6.6667, 0) evaluates to 6.6667
 * @arg1 : int | double
 * @arg2 : int
 * @returns : double
 */
FN_ROUND                    : K_FN_PREFIX 'round' ;
FN_SUM                      : K_FN_PREFIX 'sum' ;
FN_STD                      : K_FN_PREFIX 'std' ;
FN_VARIANCE                 : K_FN_PREFIX 'variance' ;

/**
 * @arg : string
 * @returns : string
 * Trims heading and trialing whitespaces. Returns the trimmed value.
 */
FN_TRIM                     : K_FN_PREFIX 'trim' ;

/**
 * @arg1 : string | int | double
 * @arg2 : string | int | double
 * @arg3 : string (optional)
 * @returns : string
 * Concats two args together with a separator. int and double values are converted into string first.
 */
FN_CONCAT                   : K_FN_PREFIX 'concat' ;

/**
 * @arg : string | list | int | double
 * @returns : int
 * Returns the length of given arg. int and double values are converted into string first.
 */
FN_LEN                      : K_FN_PREFIX 'len' ;

/**
 * @arg1 : list
 * @arg2 : list
 * @returns : list
 * Returns the union of two collection args. For list args, de-duplication will be performed first.
 */
FN_UNION                    : K_FN_PREFIX 'union' ;

/**
 * @arg1 : list
 * @arg2 : list
 * @returns : list
 * Returns the intersection of two collection args. For list args, de-duplication will be performed first.
 */
FN_INTERSECTION             : K_FN_PREFIX 'intersect' ;

/**
 * @arg1 : list
 * @arg2 : any
 * @returns : void
 * Append arg2 to list arg1.
 */
FN_APPEND                   : K_FN_PREFIX 'append' ;

/**
 * @arg : list
 * @returns : list
 * Returns a de-duplicated list, leave original one untouched.
 */
FN_DEDUP                    : K_FN_PREFIX 'dedup' ;

/**
 * @arg1 : list
 * @arg2 : boolean (optional)
 * @returns : list
 * Returns a ascending sorted list. Default value of @arg2 is true, meaning that it's doing ascending sort.
 * This function uses natural orders in this list, for example, 1 > 0, "axe" < "alice", "10" < "2".
 */
FN_SORT                     : K_FN_PREFIX 'sort' ;

/**
 * @arg1 : string
 * @arg2 : int
 * @arg3 : int
 * @returns : string
 * Returns a subtring of arg1 start from arg2 end to arg3. Indices are start from 0.
 * For example, #substring('hello world', 0, 4) will return 'hello'.
 */
FN_SUBSTR                   : K_FN_PREFIX 'substring' ;

/**
 * @arg1 : string | list
 * @arg2 : string | any
 * @returns : boolean
 * Returns true if arg1 contains arg2, false if not.
 */
FN_CONTAINS                 : K_FN_PREFIX 'contains' ;
FN_NOT_CONTAINS             : K_FN_PREFIX 'notContains' ;

/**
 * @arg1 : any
 * @arg2 : any
 * @returns : boolean
 * Not equals.
 */
FN_NEQ                      : K_FN_PREFIX 'neq';

/**
 * @arg1 : any
 * @arg2 : any
 * @returns : boolean
 * Equals. Compare variable type and variable content.
 * We only impls partial eq, that is, #eq(null, null) is true.
 */
FN_EQ                       : K_FN_PREFIX 'eq' ;

/**
 * @arg1 : expr
 * @arg2 : expr
 * @returns : boolean
 * Takes two expressions as its arguments.
 * Evaluates both expressions, return the first expression reuslt if it does not return null or empty string.
 * Otherwise return the second. If both expression evals to non-null, then the first one will be returned.
 */
FN_NVL                      : K_FN_PREFIX 'nvl';

/**
 * @arg : any
 * @returns : boolean
 * Check expression evaluation result, returns a boolean.
 * Returns true if arg is null, false if arg is anything else.
 */
FN_ISNULL                   : K_FN_PREFIX 'isNull' ;

/**
 * @arg : any
 * @returns : boolean
 * Return the opposite of the above one.
 */
FN_ISNOTNULL                : K_FN_PREFIX 'isNotNull' ;

/**
 * @arg : any
 * @returns : string
 * Convert arg to string. This method will return 'null' if arg is null.
 */
FN_TOSTRING                 : K_FN_PREFIX 'toString' ;

/**
 * @arg : string | int | double
 * @returns : int | double
 * Convert arg to number. Returns null if arg cannot be converted.
 */
FN_TONUMBER                 : K_FN_PREFIX 'toNumber' ;

/********** Primitive Types **********/
T_INT                       : 'int' ;
T_DOUBLE                    : 'double' ;
T_BOOLEAN                   : 'boolean' ;
T_STRING                    : 'string' ;
T_LIST                      : 'list' ;

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

// Left and right parenthesis
LP                          : '(' ;
RP                          : ')' ;

// Signed integers and 0. Note: The actuall integer implementation is totally relies on JVM
INT             : '0' | '1'..'9' '0'..'9'* ;

// Sgined double values
DOUBLE          : DIGIT+ '.' DIGIT*
                |        '.' DIGIT+
                ;

// RAW strings. Unicodes like \u0298 are not translated.
// This rule does not take care about of escapes other than \"
STRING          : '"' ( '\\"' | . )*? '"';

// Keyword of return
RETURN          : 'return';

// Keyword of if
IF              : 'if' ;
ELSE            : 'else' ;

// Boolean lexer rules
BOOLEAN         : TRUE | FALSE ;
fragment TRUE   : 'true' ;
fragment FALSE  : 'false' ;

// Valid identifiers like 'foo', '_bar' and '__init0__'. Note that we allow it to be start with digits.
ID              : [a-zA-Z0-9_]+ ;

// Each line must have this ';' to become a statement or expression
SEMI            : ';'+ ;

// Digits bigger than or eqaul to zero, basically singed integers and 0
fragment DIGIT  : [0-9] ;

// White spaces
WS              : [ \t\r\n]+ -> skip ;

// Line comment
LINE_COMMENT    : '//' ~[\r\n\t]* -> channel(HIDDEN) ;