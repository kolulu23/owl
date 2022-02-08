grammar OwlParser;
import OwlLexer;

/**
 * Variable definition
 */
vardef      : T_INT ID
            | T_DOUBLE ID
            | T_BOOLEAN ID
            | T_STRING ID
            | T_ENUM ID;

/**
 * Global variables
 */
glbvar       : K_GLB_VAR_PREFIX ID ;