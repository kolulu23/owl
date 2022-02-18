package cn.tongdun.owl.error;

/**
 * @author liutianlu
 * <br/>Created 2022/2/17 12:58 PM
 */
public class OwlDSLExecutionErrorFactory {
    public static OwlExecutionError compileFailed(String unitName) {
        OwlExecutionError executionError = new OwlExecutionError();
        executionError.setName(unitName);
        executionError.setMessage(String.format(OwlDSLExecutionErrorEnum.PARSE_TREE_CONSTRUCTION_FAILED.getErrorMsg(), unitName));
        return executionError;
    }

    public static OwlExecutionError cacheNotFound(String unitName) {
        OwlExecutionError executionError = new OwlExecutionError();
        executionError.setName(unitName);
        executionError.setMessage(String.format(OwlDSLExecutionErrorEnum.PARSE_TREE_CACHE_NOT_FOUND.getErrorMsg(), unitName));
        return executionError;
    }
}
