package cn.tongdun.owl.type;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 2:37 PM
 */
public enum OwlType {
    /**
     * Maps to {@link Integer}
     */
    INT("int"),
    /**
     * Maps to {@link java.math.BigDecimal}
     */
    DOUBLE("double"),
    /**
     * Maps to {@link Boolean}
     */
    BOOLEAN("double"),
    /**
     * Maps to {@link String}
     */
    STRING("string"),
    /**
     * Maps to {@link java.util.List} interface
     */
    LIST("list"),
    /**
     * Unknown means type of such variables is not declared in DSL unit, usually because those variables are global
     * variables. <br/>
     * Hint: Global variables may have different type definition as they are declared by owl's user. In that case, user
     * must provide a way to translate their own types into owl's.
     */
    UNKNOWN("");

    /**
     * Key for writing DSL
     */
    String key;

    OwlType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
