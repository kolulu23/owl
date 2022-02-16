package cn.tongdun.owl.context;

import cn.tongdun.owl.error.OwlSemanticError;
import cn.tongdun.owl.type.OwlVariable;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * A simple DSL execution context that allows user to store and retrieve variables and semantic errors.
 *
 * @author liutianlu
 * <br/>Created 2022/2/15 6:08 PM
 */
public class OwlDSLContext implements OwlContext {

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

    public OwlDSLContext() {
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
    public Collection<OwlVariable> listAllGlobalVariables() {
        return new ArrayList<>(this.getGlobalVariableMap().values());
    }

    @Override
    public void addSemanticError(OwlSemanticError semanticError) {
        this.semanticErrorList.add(semanticError);
    }

    @Override
    public Collection<OwlSemanticError> listAllSemanticErrors() {
        return this.semanticErrorList;
    }

    @Override
    public void reset() {
        this.variableMap.clear();
        this.globalVariableMap.clear();
        this.semanticErrorList.clear();
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

    public void setSemanticErrorList(List<OwlSemanticError> semanticErrorList) {
        this.semanticErrorList = semanticErrorList;
    }
}
