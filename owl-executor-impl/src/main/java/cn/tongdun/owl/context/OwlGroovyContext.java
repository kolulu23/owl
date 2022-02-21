package cn.tongdun.owl.context;

import cn.tongdun.owl.error.OwlSemanticError;
import cn.tongdun.owl.parse.OwlSemanticErrorFactory;
import cn.tongdun.owl.type.OwlVariable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * groovy的执行上下文,
 * 存储groovy脚本的入参、出参、调用方法名、编译或运行时的错误信息等
 *
 * @author ao.li
 * @date 2022/2/16 3:53 下午
 */
public class OwlGroovyContext implements OwlContext {

    private static final String DEFAULT_INVOKED_METHOD_NAME = "run";

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

    /**
     * Possible semantic errors leading to undefined behaviour.
     */
    private List<OwlSemanticError> semanticErrorList;

    public OwlGroovyContext() {
        this.invokedMethodName = DEFAULT_INVOKED_METHOD_NAME;
        this.semanticErrorList = new ArrayList<>();
    }

    @Override
    public OwlVariable getVariable(String id) {
        return null;
    }

    @Override
    public void addVariable(OwlVariable variable, boolean global) {

    }

    @Override
    public Collection<OwlVariable> listAllGlobalVariables() {
        return null;
    }

    @Override
    public void addSemanticError(OwlSemanticError semanticError) {
        this.semanticErrorList.add(semanticError);
    }

    /**
     * 从Java异常信息中提取Groovy脚本编译或运行时的错误信息
     *
     * @param e 异常
     */
    public void addSemanticErrorFromException(Exception e) {
        StackTraceElement[] stackTraceElements = e.getStackTrace();
        StackTraceElement stackTraceElement = (stackTraceElements != null && stackTraceElements.length > 0) ? stackTraceElements[0] : null;
        OwlSemanticError semanticError = OwlSemanticErrorFactory.semanticErrorOf(stackTraceElement);
        semanticError.setMessage(e.getLocalizedMessage());
        this.semanticErrorList.add(semanticError);
    }

    @Override
    public Collection<OwlSemanticError> listAllSemanticErrors() {
        return this.semanticErrorList;
    }

    @Override
    public void reset() {
        this.inputParam = null;
        this.outputParam = null;
        this.invokedMethodName = DEFAULT_INVOKED_METHOD_NAME;
        this.semanticErrorList.clear();
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
