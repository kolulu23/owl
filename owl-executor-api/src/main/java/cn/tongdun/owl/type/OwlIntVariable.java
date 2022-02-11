package cn.tongdun.owl.type;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 5:50 PM
 */
public class OwlIntVariable extends OwlUnknownVariable<Integer> {
    private static final long serialVersionUID = -954272864570577715L;

    public OwlIntVariable() {
        super();
        this.type = OwlType.INT;
    }

    public OwlIntVariable(String id) {
        super(id);
        this.type = OwlType.INT;
    }

    public OwlIntVariable(Integer value) {
        this.type = OwlType.INT;
        this.value = value;
    }

    @Override
    public String toString() {
        return "OwlIntVariable{" +
                "value=" + getValue() +
                ", id='" + id + '\'' +
                ", type=" + type +
                '}';
    }
}
