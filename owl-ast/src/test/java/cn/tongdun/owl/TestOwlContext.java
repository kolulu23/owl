package cn.tongdun.owl;

import cn.tongdun.owl.context.OwlContext;
import cn.tongdun.owl.error.OwlSemanticError;
import cn.tongdun.owl.error.OwlSyntaxError;
import cn.tongdun.owl.type.OwlVariable;
import org.junit.platform.commons.util.StringUtils;

import java.util.*;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 5:13 PM
 */
public class TestOwlContext implements OwlContext {

    /**
     * Holds all defined local variables
     */
    private Map<String, OwlVariable> variableMap;

    /**
     * Global variables are optional, a DSL unit may have zero global variables if it doesn't explicitly refer one.
     */
    private Map<String, OwlVariable> globalVariableMap;

    /**
     * Possible semantic errors leading to undefined behaviour.
     */
    private List<OwlSemanticError> semanticErrorList;

    public TestOwlContext() {
        this.setVariableMap(new HashMap<>());
        this.setGlobalVariableMap(new HashMap<>());
        this.setSemanticErrorList(new ArrayList<>());
    }

    @Override
    public OwlVariable getVariable(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        if (this.variableMap.containsKey(id)) {
            return this.variableMap.get(id);
        }
        if (this.globalVariableMap.containsKey(id)) {
            return this.globalVariableMap.get(id);
        }
        return null;
    }

    @Override
    public void addVariable(OwlVariable variable, boolean global) {
        if (global) {
            this.globalVariableMap.put(variable.getId(), variable);
        } else {
            this.variableMap.put(variable.getId(), variable);
        }
    }

    @Override
    public List<OwlVariable> listAllGlobalVariables() {
        return new ArrayList<>(this.getGlobalVariableMap().values());
    }

    @Override
    public void addSemanticError(OwlSemanticError semanticError) {
        this.semanticErrorList.add(semanticError);
    }

    @Override
    public Collection<OwlSemanticError> listAllSemanticErrors() {
        return this.getSemanticErrorList();
    }

    @Override
    public void addSyntaxError(OwlSyntaxError owlSyntaxError) {

    }

    @Override
    public Collection<OwlSyntaxError> listAllSyntaxErrors() {
        return null;
    }

    @Override
    public void reset() {

    }

    public Map<String, OwlVariable> getVariableMap() {
        return variableMap;
    }

    public void setVariableMap(Map<String, OwlVariable> variableMap) {
        this.variableMap = variableMap;
    }

    public Map<String, OwlVariable> getGlobalVariableMap() {
        return globalVariableMap;
    }

    public void setGlobalVariableMap(Map<String, OwlVariable> globalVariableMap) {
        this.globalVariableMap = globalVariableMap;
    }

    public List<OwlSemanticError> getSemanticErrorList() {
        return semanticErrorList;
    }

    public void setSemanticErrorList(List<OwlSemanticError> semanticErrorList) {
        this.semanticErrorList = semanticErrorList;
    }
}
