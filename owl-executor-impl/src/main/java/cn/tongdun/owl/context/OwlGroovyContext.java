package cn.tongdun.owl.context;

import java.util.HashMap;
import java.util.Map;

/**
 * groovy的执行上下文,
 * 存储groovy脚本的入参与出参
 *
 * @author ao.li
 * @date 2022/2/16 3:53 下午
 */
public class OwlGroovyContext {

    /**
     * groovy脚本入参map
     */
    private Map<String, Object> inputParamMap;

    /**
     * groovy脚本出参map
     */
    private Map<String, Object> outputParamMap;

    /**
     * groovy脚本入口方法
     */
    private String invokeMethodName;

    public OwlGroovyContext() {
        this.inputParamMap = new HashMap<>();
        this.outputParamMap = new HashMap<>();
    }

    public Map<String, Object> getInputParamMap() {
        return inputParamMap;
    }

    public void setInputParamMap(Map<String, Object> inputParamMap) {
        this.inputParamMap = inputParamMap;
    }

    public Map<String, Object> getOutputParamMap() {
        return outputParamMap;
    }

    public void setOutputParamMap(Map<String, Object> outputParamMap) {
        this.outputParamMap = outputParamMap;
    }

    public String getInvokeMethodName() {
        return invokeMethodName;
    }

    public void setInvokeMethodName(String invokeMethodName) {
        this.invokeMethodName = invokeMethodName;
    }
}
