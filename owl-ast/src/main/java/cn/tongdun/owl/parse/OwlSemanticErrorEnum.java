package cn.tongdun.owl.parse;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 7:10 PM
 */
public enum OwlSemanticErrorEnum {
    VARIABLE_NOT_DEFINED("Using a undefined variable: "),
    VARIABLE_TYPE_UNKNOWN("Variable %s is unknown, possibly declared but uninitialized."),
    GLOBAL_VAR_NOT_INIT("Using a uninitialized global variable: "),
    VARIABLE_ASSIGN_TO_WRONG_TYPE("Cannot assign value to variable %s, required type is %s but a %s type is provided."),
    ASSIGN_TO_UNKNOWN_VARIABLE("Trying to assign a value to a undefined or uninitialized variable %s."),
    DSL_DOES_NOT_RETURN("DSL unit missing 'return expression' or unit evalutes null value."),
    NUMBER_TYPE_REQUIRED("This operation requires a number type, i.e. INT or DOUBLE. Found %s"),
    DIVIDE_ZERO("Dividing zero leads to undefined behaviour"),
    NON_OPERABLE_ARG_FOR_FUNCTION("None of provided args is operable for this function %s"),
    WRONG_TYPE_FOR_FUNCTION("Function %s requires %s type, but %s is provided"),
    WRONG_TYPE_FOR_CONTEXT("Context %s requires %s type, but %s is provided");
    private final String errorMsg;

    OwlSemanticErrorEnum(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
