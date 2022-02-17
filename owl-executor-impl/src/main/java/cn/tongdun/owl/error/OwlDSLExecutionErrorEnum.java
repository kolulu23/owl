package cn.tongdun.owl.error;

/**
 * @author liutianlu
 * <br/>Created 2022/2/17 12:55 PM
 */
public enum OwlDSLExecutionErrorEnum {
    PARSE_TREE_CONSTRUCTION_FAILED("Couldn't compile parse tree for %s"),
    PARSE_TREE_CACHE_NOT_FOUND("Couldn't find parse tree for %s");
    private final String errorMsg;

    OwlDSLExecutionErrorEnum(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
