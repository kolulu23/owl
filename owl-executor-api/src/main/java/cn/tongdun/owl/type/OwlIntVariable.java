package cn.tongdun.owl.type;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 5:50 PM
 */
public class OwlIntVariable extends OwlVariable {
    private static final long serialVersionUID = -954272864570577715L;

    private Integer value;

    public OwlIntVariable(String id, OwlType type) {
        this.id = id;
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public OwlType getType() {
        return this.type;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "OwlIntVariable{" +
                "value=" + value +
                ", id='" + id + '\'' +
                ", type=" + type +
                '}';
    }
}
