package cn.tongdun.owl.context;

import cn.tongdun.owl.error.OwlSemanticError;
import cn.tongdun.owl.type.OwlVariable;

import java.util.Collection;

/**
 * Stores variables, semantic errors and expression results.
 *
 * @author liutianlu
 * <br/>Created 2022/2/10 5:04 PM
 */
public interface OwlContext {
    /**
     * Get variable by its id
     *
     * @param id identifier
     * @return variable object, could be null.
     */
    OwlVariable getVariable(String id);

    /**
     * Is this identifier has been declared
     *
     * @param id identifier
     * @return returns true if given id belongs to a variable
     */
    default boolean isVariableDeclared(String id) {
        return getVariable(id) != null;
    }

    /**
     * Add or update a variable by its id.
     *
     * @param variable local or global variable
     * @param global   is this a global variable
     */
    void addVariable(OwlVariable variable, boolean global);

    /**
     * Get all global variable references in one DSL
     *
     * @return List of global variables, the list can not be null.
     */
    Collection<OwlVariable> listAllGlobalVariables();

    /**
     * Add a semantic error to this context
     *
     * @param semanticError semantic error like using undeclared or uninitialized variables
     */
    void addSemanticError(OwlSemanticError semanticError);

    /**
     * Get all semantic errors.
     *
     * @return semantic error list
     */
    Collection<OwlSemanticError> listAllSemanticErrors();

    /**
     * Reset this context for another round of execution.
     * Use it if you want to separate different DSL execution units.<br/>
     */
    void reset();
}
