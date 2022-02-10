package cn.tongdun.owl.type;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 2:37 PM
 */
public enum OwlType {
    /**
     * Maps to {@link Integer}
     */
    INT,
    /**
     * Maps to {@link java.math.BigDecimal}
     */
    DOUBLE,
    /**
     * Maps to {@link Boolean}
     */
    BOOLEAN,
    /**
     * Maps to {@link String}
     */
    STRING,
    /**
     * Maps to {@link java.util.List} interface
     */
    LIST,
    /**
     * Unknown means type of such variables is not declared in DSL unit, usually because those variables are global
     * variables. <br/>
     * Hint: Global variables may have different type definition as they are declared by owl's user. In that case, user
     * must provide a way to translate their own types into owl's.
     */
    UNKNOWN
}
