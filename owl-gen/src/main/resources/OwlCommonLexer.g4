lexer grammar OwlCommonLexer;

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