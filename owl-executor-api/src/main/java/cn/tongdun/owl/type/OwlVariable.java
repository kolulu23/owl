package cn.tongdun.owl.type;

/**
 * Note: you don't see a variable's value until it has been downcast into subclasses like {@link OwlIntVariable}
 *
 * @author liutianlu
 * <br/>Created 2022/2/10 3:26 PM
 */
public abstract class OwlVariable {

    /**
     * Identifier of this variable
     */
    protected String id;

    /**
     * Data type
     */
    protected OwlType type;

    public abstract String getId();

    public abstract OwlType getType();
}
