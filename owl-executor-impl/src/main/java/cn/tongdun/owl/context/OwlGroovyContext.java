package cn.tongdun.owl.context;

/**
 * groovy的执行上下文,
 * 存储groovy脚本的入参、出参、调用方法名
 *
 * @author ao.li
 * @date 2022/2/16 3:53 下午
 */
public class OwlGroovyContext {

    /**
     * groovy脚本入参
     */
    private Object inputParam;

    /**
     * groovy脚本出参
     */
    private Object outputParam;

    /**
     * groovy脚本入口方法
     */
    private String invokedMethodName;

    public void reset() {
        this.inputParam = null;
        this.outputParam = null;
        this.invokedMethodName = null;
    }

    public Object getInputParam() {
        return inputParam;
    }

    public void setInputParam(Object inputParam) {
        this.inputParam = inputParam;
    }

    public Object getOutputParam() {
        return outputParam;
    }

    public void setOutputParam(Object outputParam) {
        this.outputParam = outputParam;
    }

    public String getInvokedMethodName() {
        return invokedMethodName;
    }

    public void setInvokedMethodName(String invokedMethodName) {
        this.invokedMethodName = invokedMethodName;
    }
}
