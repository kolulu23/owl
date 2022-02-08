grammar OwlParser;
import OwlCommonLexer, OwlKeywordLexer;

vardef      : T_INT var
            | T_DOUBLE var
            | T_BOOLEAN var
            | T_STRING var
            | T_ENUM var;

/**
* Variables can be local variables like 'foo' or global variables like '@foo'.
*/
var         : ID
            | K_GLB_VAR_PREFIX ID ;